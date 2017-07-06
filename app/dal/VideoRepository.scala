package dal

import java.sql.{Blob, Date}
import java.util.Calendar
import javax.inject._

import models.Video
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class VideoRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private class VideoTable(tag: Tag) extends Table[Video](tag, "video") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def title = column[String]("title")

    def description = column[String]("description")

    def thumbnail = column[Option[Blob]]("thumbnail")

    def likes = column[Long]("likes")

    def dislikes = column[Long]("dislikes")

    def views = column[Long]("views")

    def createdDate = column[Date]("created_date")

    def modifiedDate = column[Date]("modified_date")

    def * = (id, title, description, thumbnail, likes, dislikes, views, createdDate, modifiedDate) <> ((Video.apply _).tupled, Video.unapply)

  }

  private lazy val videos = TableQuery[VideoTable]

  def list(): Future[Seq[Video]] = db.run {
    videos.result
  }

  def find(id: Long): Future[Option[Video]] = db.run(videos.filter(_.id === id).result.headOption)

  def insert(title: String,
             description: String,
             thumbnail: Blob) = {
    val now = new Date(Calendar.getInstance().getTimeInMillis)
    val action = (videos returning videos.map(_.id)) += Video(1L, title, description, Some(thumbnail), 0, 0, 0, now, now)
    db.run(action)
  }

}

