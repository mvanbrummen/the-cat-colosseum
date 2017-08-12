name := """the-cat-colosseum"""
organization := "io.github.mvanbrummen"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "io.github.mvanbrummen.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "io.github.mvanbrummen.binders._"

libraryDependencies ++= Seq(
  guice,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0" % Test,
  "com.typesafe.play" %% "play-slick" % "3.0.0",
  "com.h2database" % "h2" % "1.4.194",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
  "com.typesafe.play" %% "play-slick-evolutions" % "3.0.0",
  "commons-io" % "commons-io" % "2.4"
)
