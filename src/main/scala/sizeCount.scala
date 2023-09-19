package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object sizeCount {
  def size(shape: Shape): Int = {
    var count = 0
    //Traverse shapes
    def countLeaf(s:Shape): Unit = s match {
        case Ellipse(_,_) | Rectangle(_,_) =>
            count +=1
        case Location(_,_, insideShape) =>
            countLeaf(insideShape)
        case Group(shapes @ _*) =>
            shapes.foreach(countLeaf)
    }
    countLeaf(shape)

    //return the size
    count
  }
  
}
