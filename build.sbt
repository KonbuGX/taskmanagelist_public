name := """taskmanagelist"""
organization := "taskManageList"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)


scalaVersion := "2.13.0"


libraryDependencies += guice
libraryDependencies += javaJdbc
libraryDependencies += "org.postgresql"%"postgresql"%"42.2.19"
libraryDependencies += "org.mindrot" % "jbcrypt" % "0.4"
libraryDependencies ++= Seq(
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "org.webjars" %% "webjars-play" % "2.8.8",
  "org.webjars" % "jquery" % "3.6.0",
  "org.webjars" % "bootstrap" % "5.1.1",
  "org.webjars" % "popper.js" % "2.9.3"
)