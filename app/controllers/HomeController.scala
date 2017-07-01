package controllers

import javax.inject._

import dal.VideoRepository
import models.Video
import play.api.mvc._

import scala.concurrent.ExecutionContext


case class VideoGallery(id: Long,
                        title: String,
                        views: Long,
                        likes: Long,
                        dislikes: Long,
                        uploadedAgo: String)

@Singleton
class HomeController @Inject()(cc: ControllerComponents, repo: VideoRepository)(implicit ec: ExecutionContext)
  extends AbstractController(cc) {

  def index() = Action.async { implicit request: Request[AnyContent] =>
    repo.list().map { videos =>
      Ok(views.html.index(videos.map(Video.toVideoGallery)))
    }
  }

  def getThumbnail(id: Long) = Action.async { implicit request: Request[AnyContent] =>
    repo.find(id).map { video =>
      val data = video.get.image.get

      Ok(data.getBytes(1, data.length().asInstanceOf[Int])).as("image/jpeg")
    }
  }

}
