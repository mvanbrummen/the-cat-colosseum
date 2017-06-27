package models

import java.sql.{Blob, Date}

import play.api.libs.json.Json

case class Video(id: Long,
                 title: String,
                 description: String,
                 image: Option[Blob],
                 createdDate: Date,
                 modifiedDate: Date)

object Video {

//  implicit val videoFormat = Json.format[Video]
}