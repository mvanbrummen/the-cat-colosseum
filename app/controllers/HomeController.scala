package controllers

import javax.inject._

import dal.VideoRepository
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.ExecutionContext


@Singleton
class HomeController @Inject()(cc: ControllerComponents, repo: VideoRepository)(implicit ec: ExecutionContext)
  extends AbstractController(cc) {

  def index() = Action.async { implicit request: Request[AnyContent] =>
    repo.list().map { videos =>
      Ok(views.html.index(videos))
    }
  }
}
