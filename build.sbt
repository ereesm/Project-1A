name := "shapes-oo-scala"

version := "0.4"

scalaVersion := "3.3.0"

scalacOptions += "@.scalacOptions.txt"

libraryDependencies ++= Seq(
  "org.creativescala" %% "doodle"     % "0.20.0",
  "org.scalatest"     %% "scalatest"  % "3.2.16"  % Test,
  "org.scalacheck"    %% "scalacheck" % "1.17.0"  % Test
)
