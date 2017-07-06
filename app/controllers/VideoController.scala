package controllers

import java.io.File
import javax.inject._

import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import service.IVideoService

import scala.concurrent.ExecutionContext

@Singleton
class VideoController @Inject()(service: IVideoService, cc: ControllerComponents)(implicit ec: ExecutionContext)
  extends AbstractController(cc) {

  def watch(id: Long) = Action.async { implicit request: Request[AnyContent] =>
    service.findOne(id).map { v =>
      v.map { f =>
        Ok(views.html.video(f))
      } getOrElse NotFound("No video!")
    }
  }

  def video(id: Long) = Action.async { implicit request: Request[AnyContent] =>
    service.findOne(id).map { v =>
      v.map { f =>
          val videoFile = new File("/public/video", s"$id-video.mp4")

          Ok.sendFile(videoFile).as("video/mp4").withHeaders(ACCEPT_RANGES -> "bytes")

      } getOrElse NotFound("No video!")
    }
  }

}
