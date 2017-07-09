package controllers

import java.nio.file.Paths
import java.util.UUID
import javax.inject._

import dal.VideoRepository
import play.api.Configuration
import play.api.data.Forms._
import play.api.data._
import play.api.i18n.I18nSupport
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}

import scala.concurrent.{ExecutionContext, Future}

case class VideoUploadData(title: String, description: String)

@Singleton
class UploadController @Inject()(cc: ControllerComponents, repo: VideoRepository, config: Configuration)(implicit ec: ExecutionContext)
  extends AbstractController(cc) with I18nSupport {

  val uploadForm = Form(
    mapping(
      "title" -> nonEmptyText,
      "description" -> nonEmptyText
    )(VideoUploadData.apply)(VideoUploadData.unapply)
  )

  def upload() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.upload(uploadForm))
  }

  def uploadPost() = Action(parse.multipartFormData).async { implicit request =>
    uploadForm.bindFromRequest.fold(
      formWithErrors => {
        Future.successful(BadRequest("nope"))
      },
      uploadData => {
        val fileOption: Option[Future[Long]] = request.body.file("video").flatMap { video =>
          request.body.file("image").map { image =>
            val contentType = video.contentType

            val imgFilePath = s"${config.underlying.getString("file.upload.path.thumbnail")}/${UUID.randomUUID()}.jpeg"
            val vidFilePath = s"${config.underlying.getString("file.upload.path.video")}/${UUID.randomUUID()}.mp4"

            video.ref.moveTo(Paths.get(vidFilePath), replace = true)
            image.ref.moveTo(Paths.get(imgFilePath), replace = true)

            repo.insert(uploadData.title, uploadData.description, imgFilePath, vidFilePath).map { id =>
              id
            }
          }
        }
        fileOption.map { f =>
          f.map { id => Redirect(routes.VideoController.watch(id)) }
        } getOrElse {
          Future.successful(BadRequest("nope"))
        }
      }
    )
  }

}
