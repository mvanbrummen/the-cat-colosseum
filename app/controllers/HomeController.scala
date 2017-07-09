package controllers

import javax.inject._

import dal.VideoRepository
import play.api.mvc._
import service.IVideoService

import scala.concurrent.ExecutionContext


case class VideoGallery(id: Long,
                        title: String,
                        likes: Long,
                        dislikes: Long,
                        views: Long,
                        thumbnailLocation: String,
                        uploadedAgo: String)

@Singleton
class HomeController @Inject()(cc: ControllerComponents, repo: VideoRepository, service: IVideoService)(implicit ec: ExecutionContext)
  extends AbstractController(cc) {

  def index() = Action.async { implicit request: Request[AnyContent] =>
    service.findAllVideos().map { video =>
      Ok(views.html.index(video))
    }
  }

}
