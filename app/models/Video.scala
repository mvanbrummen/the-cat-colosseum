package models

import java.sql.{Blob, Date}

import controllers.VideoGallery

case class Video(id: Long,
                 title: String,
                 description: String,
                 image: Option[Blob],
                 createdDate: Date,
                 modifiedDate: Date)

object Video {

  def toVideoGallery(video: Video) = VideoGallery(video.id, video.title, 0, 0, 0, video.createdDate.toString)

//  implicit val videoFormat = Json.format[Video]
}