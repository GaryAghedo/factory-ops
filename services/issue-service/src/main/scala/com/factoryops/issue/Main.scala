package com.factoryops.issue

import cats.effect.{IO, IOApp}

object Main extends IOApp.Simple {
  override def run: IO[Unit] =
    IO.println("FactoryOps Issue Service")
}
