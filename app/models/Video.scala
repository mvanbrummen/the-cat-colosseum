package models

import java.sql.{Blob, Date}

import controllers.VideoGallery

case class Video(id: Long,
                 title: String,
                 description: String,
                 image: Option[Blob],
                 likes: Long,
                 dislikes: Long,
                 views: Long,
                 createdDate: Date,
                 modifiedDate: Date)

object Video {

  def toVideoGallery(video: Video) = VideoGallery(video.id, video.title, video.likes, video.dislikes, video.views, video.createdDate.toString)

  //  implicit val videoFormat = Json.format[Video]
}