package edu.luc.cs.laufer.cs371.shapes

import Shape.*

sealed trait Tree
case class Node(value: Int, Left: Tree, right: Tree) extends Tree

case object Empty extends Tree

object heightCount {
  //helps traverse the shape tree, then calculates the maximum height between left and right subtree heights.
  def height(tree: Tree, count: Int): Int = tree match {
     case Node(_, left, right) =>
        val leftH = height(left, count +1)
        val rightH = height(right, count+ 1)
        Math.max(leftH, rightH)
    //For in case count is empty
     case _ => count
 
  }
  //starts computation of height with a function that calls the helper function
  def getHeight(tree: Tree): Int = height(tree, 0)
}
