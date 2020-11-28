package com.raphtory.core.components.Spout


trait DataSource[+T]{
  private var dataComplete = false

  def setupDataSource():Unit

  def generateData():Option[T]

  def closeDataSource():Unit

  def dataSourceComplete():Unit = dataComplete=true
  def isComplete():Boolean = dataComplete
}