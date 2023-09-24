package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite


import TestFixtures.*
import Shape.*
import edu.luc.cs.laufer.cs371.shapes.heightCount.height

import edu.luc.cs.laufer.cs371.shapes.{Node, heightCount}

class testScale extends AnyFunSuite {
  test("correctly scale a leaf node"){
    val leafNode: Tree = Node(5,Empty,Empty)
    val sLeafNode = heightCount.scale(leafNode, 2.0)
    assert(sLeafNode === sNode(10.0, Empty,Empty) )
  }
  
  test("scale a non-leaf node"){
    val parent: Tree = Node(10, Node(5,Empty,Empty), Node(15, Empty,Empty))
    val sParent = heightCount.scale(parent, 1.5)
    assert(sParent === sNode(15.0, sNode(7.5,Empty,Empty), sNode(22.5, Empty, Empty)))
  }
  test("leave an empty node as is"){
    val empty : Tree = Empty
    val sEmpty = heightCount.scale(empty, 2.0)
    assert(sEmpty === Empty)
  }
  test("Tree should be unchanged when scaled by 1"){
    val origin: Tree = Node(10, Node(5,Empty,Empty), Node(15, Empty,Empty))
    val scaled = heightCount.scale(origin, 1.0)
    assert(scaled === origin)
  }
  test("scale a complete tree"){
    val tree: Tree = Node(
        10,
        Node(5,Node(3,Empty,Empty), Node(7,Empty,Empty)),
        Node(15, Node(12, Empty, Empty), Node(18,Empty,Empty))
    )
    val scaledTree = heightCount.scale(tree, 1.5)
    //use sNode when writing code for expected values
    val expectedTree: Tree =sNode(
      15.0,
      sNode(7.5,sNode(4.5, Empty, Empty), sNode(10.5, Empty, Empty)),
      sNode(22.5, sNode(18.0, Empty, Empty), sNode(27.0, Empty, Empty))
    )
    assert(scaledTree === expectedTree)
  }
  test("Scale with mixed nodes"){
    val nestedTree: Tree = Node(10,Node(5, Empty, Node(15, Empty, Empty)), Node(20, Empty, Empty))
    val sNestedTree = heightCount.scale(nestedTree, 0.5)
    val expectedNTree: Tree = sNode(
      5.0,
      sNode(2.5, Empty, sNode(7.5, Empty, Empty)),
      sNode(10.0, Empty, Empty)
    )
    assert(sNestedTree === expectedNTree)
  }
}
