package controllers

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
      } getOrElse InternalServerError("No video!")
    }
  }

}
