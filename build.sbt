organization := "io.hydrosphere"
name := "envoy-data-plane-api"
version := "v1.6.0_1"

scalaVersion := "2.12.4"
crossScalaVersions := Seq("2.12.4", "2.11.11")

publishMavenStyle := true

libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime" % com.trueaccord.scalapb.compiler.Version.scalapbVersion % "protobuf"
libraryDependencies ++= Seq(
  /*"com.trueaccord.scalapb" %% "compilerplugin" % com.trueaccord.scalapb.compiler.Version.scalapbVersion,*/
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % com.trueaccord.scalapb.compiler.Version.scalapbVersion,
  "com.google.api.grpc" % "googleapis-common-protos" % "0.0.3" % "protobuf"
)

PB.protoSources in Compile := Seq(
  baseDirectory.value / "src",
  baseDirectory.value / "ext"
  //target.value / "protobuf_external"
)

PB.includePaths in Compile := Seq(
  baseDirectory.value / "src",
  baseDirectory.value / "ext",
  target.value / "protobuf_external"
)

PB.targets in Compile := Seq(
  //PB.gens.java -> (sourceManaged in Compile).value,
  scalapb.gen(
    grpc = true,
    //javaConversions=true,
    flatPackage = true
  ) -> (sourceManaged in Compile).value
)


publishArtifact in Test := false
pomIncludeRepository := { _ => false }
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots/")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2/")
}
pomExtra := <url>https://github.com/Hydrospheredata/hydro-serving-sidecar</url>
  <licenses>
    <license>
      <name>Apache 2.0 License</name>
      <url>https://github.com/Hydrospheredata/hydro-serving-sidecar/blob/master/LICENSE</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/Hydrospheredata/hydro-serving-sidecar.git</url>
    <connection>https://github.com/Hydrospheredata/hydro-serving-sidecar.git</connection>
  </scm>
  <developers>
    <developer>
      <id>Zajs</id>
      <name>Eduard Dautov</name>
      <url>https://github.com/Zajs</url>
      <organization>Hydrosphere</organization>
      <organizationUrl>http://hydrosphere.io/</organizationUrl>
    </developer>
  </developers>