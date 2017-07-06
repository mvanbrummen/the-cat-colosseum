package controllers


import java.io._
import java.nio.file.Paths
import javax.inject._
import javax.sql.rowset.serial.SerialBlob

import dal.VideoRepository
import org.apache.commons.io.IOUtils
import play.api.data.Forms._
import play.api.data._
import play.api.i18n.I18nSupport
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}

import scala.concurrent.ExecutionContext

case class VideoUploadData(title: String, description: String)

@Singleton
class UploadController @Inject()(cc: ControllerComponents, repo: VideoRepository)(implicit ec: ExecutionContext)
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

  def uploadPost() = Action(parse.multipartFormData) { implicit request =>
    uploadForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest("nope")
      },
      uploadData => {
        request.body.file("file").map { video =>
          val filename = video.filename
          val contentType = video.contentType

          val tempFilePath = s"/tmp/video/$filename"

          video.ref.moveTo(Paths.get(tempFilePath), replace = true)

          val thumbnail = new File(tempFilePath)
          val fileInput = new FileInputStream(thumbnail)

          val videoId = repo.insert(uploadData.title, uploadData.description, new SerialBlob(IOUtils.toByteArray(fileInput)))
        }
        Ok(uploadData.title)
      }
    )
  }

}
