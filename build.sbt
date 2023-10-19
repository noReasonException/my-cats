lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.nre",
      scalaVersion := "2.13.6"
    )),
    name := "my-cats"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
