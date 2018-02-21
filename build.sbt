name := "SparkScala"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  val sparkVer = "2.2.1"
  Seq(
    "org.apache.spark" %% "spark-core" % sparkVer,
    "org.apache.spark" %% "spark-sql" % sparkVer,
    "org.apache.spark" %% "spark-mllib" % sparkVer,
    "org.apache.spark" %% "spark-streaming" % sparkVer,
    "org.apache.bahir" %% "spark-streaming-twitter" % "2.2.0",
    "org.apache.spark" %% "spark-streaming-kafka-0-8" % "2.2.1"
  )
}