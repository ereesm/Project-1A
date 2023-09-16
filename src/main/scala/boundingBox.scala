package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(width, height) => Location(0, 0, Rectangle(width, height)) // not yet implemented

    case Location(x,y,shape) => 
      val insideBoundingBox = apply(shape)
      Location(x,y,insideBoundingBox.shape)
    
    case Ellipse(semiMajor, semiMinor) => 
      val width = semiMajor*2
      val height = semiMinor*2
      Location(-semiMajor,-semiMinor, Rectangle(width,height))

    case Group(shapes @ _*) =>
      val boundingBoxes = shapes.map(apply)
      val minX = boundingBoxes.map(_.x).min
      val minY = boundingBoxes.map(_.y).min
      val maxX = boundingBoxes.map(bb => bb.x + bb.shape.asInstanceOf[Rectangle].width).max
      val maxY = boundingBoxes.map(bb => bb.y + bb.shape.asInstanceOf[Rectangle].height).max
      Location(minX, minY, Rectangle(maxX - minX, maxY - minY))

      
      




end boundingBox
