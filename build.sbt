// Your sbt build file. Guides on how to write one can be found at
// http://www.scala-sbt.org/0.13/docs/index.html

spName := "yu-iskw/spark-ranking-algorithms"

version := "0.0.5"

licenses := Seq("Apache-2.0" -> url("http://opensource.org/licenses/Apache-2.0"))

scalaVersion := "2.11.8"

//crossScalaVersions := Seq("2.10.5", "2.11.8")
crossScalaVersions := Seq("2.11.8")

sparkVersion := "2.2.0"

licenses := Seq("Apache-2.0" -> url("http://opensource.org/licenses/Apache-2.0"))

sparkComponents ++= Seq("mllib", "sql")

spAppendScalaVersion := true

spIncludeMaven := true

spIgnoreProvided := true

test in assembly := {}

val testSparkVersion = settingKey[String]("The version of Spark to test against.")

testSparkVersion := sys.props.getOrElse("spark.testVersion", sparkVersion.value)

// Can't parallelly execute in test
parallelExecution in Test := false

fork in Test := true

javaOptions ++= Seq("-Xmx2G", "-XX:MaxPermSize=256m")

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.12",  
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",  
  "org.scalanlp" %% "breeze" % "0.13.2",  
  "org.scalanlp" %% "breeze-natives" % "0.13.2",  
  "org.scalanlp" %% "breeze-viz" % "0.13.2"
)

resolvers ++= Seq(
  "Atilika Open Source repository" at "http://www.atilika.org/nexus/content/repositories/atilika",
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
)


