package dal

import java.sql.{Blob, Date}
import javax.inject._

import models.Video
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class VideoRepository @Inject()(
                                 protected val dbConfigProvider: DatabaseConfigProvider
                               )(implicit ec: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private class VideoTable(tag: Tag) extends Table[Video](tag, "video") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def title = column[String]("title")

    def description = column[String]("description")

    def thumbnail = column[Option[Blob]]("thumbnail")

    def createdDate = column[Date]("created_date")

    def modifiedDate = column[Date]("modified_date")

    def * = (id, title, description, thumbnail, createdDate, modifiedDate) <> ((Video.apply _).tupled, Video.unapply)

  }

  private val videos = TableQuery[VideoTable]

  def list(): Future[Seq[Video]] = db.run {
    videos.result
  }

}

