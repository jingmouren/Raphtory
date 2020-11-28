package com.raphtory.examples.lotr

import com.raphtory.core.components.Spout.DataSource

import scala.collection.mutable


class LOTRDataSource extends DataSource[String] {

  val fileQueue = mutable.Queue[String]()

  override def setupDataSource(): Unit = {
    fileQueue++=
      scala.io.Source.fromFile("cluster/src/main/scala/com/raphtory/examples/lotr/lotr.csv")
        .getLines
  }//no setup

  override def generateData(): Option[String] = {
    if(fileQueue isEmpty){
      dataSourceComplete()
      None
    }
    else
      Some(fileQueue.dequeue())
  }
  override def closeDataSource(): Unit = {}//no file closure already done
}