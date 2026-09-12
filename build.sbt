ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.8"

ThisBuild / organization := "com.factoryops"

lazy val root =
  project
    .in(file("."))
    .settings(
      name := "factory-ops",
      publish / skip := true
    )

lazy val common =
  project
    .in(file("modules/common"))
    .settings(
      name := "factory-ops-common",
      libraryDependencies ++= Dependencies.common
    )


lazy val issueService =
  project
    .in(file("services/issue-service"))
    .dependsOn(common)
    .settings(
      name := "issue-service",
      libraryDependencies ++= Dependencies.backend
    )
