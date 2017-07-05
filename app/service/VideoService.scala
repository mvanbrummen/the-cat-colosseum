package service

import java.sql.Blob
import javax.inject._

import controllers.VideoGallery
import dal.VideoRepository
import models.Video

import scala.concurrent.{ExecutionContext, Future}

trait IVideoService {

  def findAllVideos(): Future[Seq[VideoGallery]]

  def findOne(id: Long): Future[Option[Video]]

}

@Singleton
class VideoService @Inject()(repo: VideoRepository)(implicit ec: ExecutionContext) extends IVideoService {

  override def findAllVideos(): Future[Seq[VideoGallery]] = {
    repo.list().map { video =>
      video.map(Video.toVideoGallery)
    }
  }

  override def findOne(id: Long): Future[Option[Video]] = {
    repo.find(id)
  }
}
