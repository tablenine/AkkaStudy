lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.11.8",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "DataSync",
    libraryDependencies ++= Seq (
    	"org.scalatest" %% "scalatest" % "3.0.1" % Test,
    	"com.typesafe.slick" %% "slick" % "3.2.0",
    	"com.h2database" % "h2" % "1.4.187",
  		"org.scalatest" %% "scalatest" % "2.2.4" % "test",
  		"mysql" % "mysql-connector-java" % "5.1.21",
  		"com.typesafe.slick" %% "slick-hikaricp" % "3.1.0",
  		"com.typesafe.akka" %% "akka-actor" % "2.4.11"
    )
  )
