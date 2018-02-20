addSbtPlugin("com.thesamet" % "sbt-protoc" % "0.99.12")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.0")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.0")

libraryDependencies += "com.trueaccord.scalapb" %% "compilerplugin" % "0.6.6"