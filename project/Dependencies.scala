import sbt._

object  Dependencies {

  object Versions {
    val catEffects = "3.7.1"
    val http4s     = "0.23.36"
    val tapir      = "1.13.31"
    val doobie     = "1.0.0-RC13"
    val chimney    = "1.10.0"
    val specs2     = "4.22.0"
    val scalaMock  = "7.3.2"
  }


  val common = Seq(
    "org.typelevel" %% "cats-effect" % Versions.catEffects,
    "io.scalaland"  %% "chimney"      % Versions.chimney
  )

  val backend = Seq(
    "org.typelevel" %% "cats-effect" % Versions.catEffects,

    "org.http4s"  %% "http4s-ember-server" % Versions.http4s,
    "org.http4s"  %% "http4s-ember-client" % Versions.http4s,
    "org.http4s"   %% "http4s-dsl"         % Versions.http4s,

    "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % Versions.http4s,
    "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % Versions.tapir,

    "org.typelevel"  %% "doobie-core" % Versions.doobie,
    "org.typelevel" %% "doobie-hikari" % Versions.doobie,
    "org.typelevel" %% "doobie-postgres" % Versions.doobie,

    "io.scalaland" %% "chimney" % Versions.chimney,

    "org.specs2"  %% "specs2-core" % Versions.specs2 % Test,
    "org.scalamock" %% "scalamock" % Versions.scalaMock % Test


  )

}
