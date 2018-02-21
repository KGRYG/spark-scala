package com.karen.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object CustomerCount {

  def parseLine(line: String) = {
    val fields = line.split(",")
    val custId = fields(0).toInt
    val price = fields(2).toFloat
    (custId, price)
  }

  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "CustomerCount")

    val input = sc.textFile("/home/karen/Downloads/SparkScalaMaterials/customer-orders.csv")

    val customers = input.map(parseLine)

    val totalsById = customers.reduceByKey((x,y) => x + y)

    val flipped = totalsById.map( x => (x._2, x._1) )

    val results = flipped.sortByKey().collect()

    results.foreach(println)


  }


}
