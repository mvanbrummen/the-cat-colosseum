package controllers

import javax.inject._

import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.ExecutionContext

@Singleton
class VideoController @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext)
  extends AbstractController(cc) {

  def watch(id: Long) = Action {
    Ok(s"Your video $id")
  }

}
