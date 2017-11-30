import sbt.NothingFilter
import sbt.internal.io.Source

// general
organization  := "com.earldouglas"

name          := "xsbt-web-plugin"

sbtPlugin     := true

scalacOptions ++= Seq("-feature", "-deprecation")

//crossSbtVersions := Seq("0.13.6", "1.0.0")

scalaVersion := "2.12.4"

// bintray-sbt
publishMavenStyle := true

licenses          += ("BSD New", url("http://opensource.org/licenses/BSD-3-Clause"))

// scripted-plugin
ScriptedPlugin.projectSettings

scriptedBufferLog  := false

scriptedLaunchOpts += { "-Dplugin.version=" + version.value }

def fileSeq2SourceSec(files: Seq[File]): Seq[Source] = files.map(file ⇒ new Source(file, NothingFilter, NothingFilter))

watchSources       ++= fileSeq2SourceSec((sourceDirectory.value ** "*").get)

libraryDependencies += "com.amazonaws" % "aws-java-sdk-elasticbeanstalk" % "1.11.105"

libraryDependencies += "com.amazonaws" % "aws-java-sdk-s3"               % "1.11.105"
