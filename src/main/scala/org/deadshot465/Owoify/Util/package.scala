package org.deadshot465.Owoify

import scala.collection.mutable.ListBuffer

package object Util {
  def interleaveArrays[T](a: Iterator[T], b: Iterator[T]): ListBuffer[T] = {
    val arr = new ListBuffer[T]
    var observed = a.toBuffer
    var other = b.toBuffer
    var temp = new ListBuffer[T]
    while (observed.nonEmpty) {
      arr += observed.remove(0)
      temp = observed.to[ListBuffer]
      observed = other
      other = temp
    }
    if (observed.nonEmpty) {
      arr.appendAll(observed)
    }
    arr
  }
}
