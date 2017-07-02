package controllers

import javax.inject._

import dal.VideoRepository
import models.Video
import play.api.mvc._
import service.{IVideoService, VideoService}

import scala.concurrent.ExecutionContext


case class VideoGallery(id: Long,
                        title: String,
                        likes: Long,
                        dislikes: Long,
                        views: Long,
                        uploadedAgo: String)

@Singleton
class HomeController @Inject()(cc: ControllerComponents, repo: VideoRepository, service: IVideoService)(implicit ec: ExecutionContext)
  extends AbstractController(cc) {

  def index() = Action.async { implicit request: Request[AnyContent] =>
    service.findAllVideos().map { video =>
      Ok(views.html.index(video))
    }
  }

  def getThumbnail(id: Long) = Action.async { implicit request: Request[AnyContent] =>
    repo.find(id).map { video =>
      val data = video.get.image.get

      Ok(data.getBytes(1, data.length().asInstanceOf[Int])).as("image/jpeg")
    }
  }

}
