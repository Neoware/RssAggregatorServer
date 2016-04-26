name := """RssAggregatorServer"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.36",
  "jdom" % "jdom" % "1.1",
  "rome" % "rome" % "1.0",
  "com.google.code.gson" % "gson" % "2.6.2"
)

//enablePlugins(JavaAppPackaging)
//enablePlugins(DockerPlugin)