package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*
import edu.luc.cs.laufer.cs371.shapes.heightCount.height

sealed trait Tree
case class Node(value: Int, Left: Tree, right: Tree) extends Tree

import edu.luc.cs.laufer.cs371.shapes.{Node, heightCount}


class testHeight extends AnyFunSuite {

    test("Find height of empty tree"){
        val tree = Empty
        assert(heightCount.getHeight(tree) == 0)
    }
    
    test("Find the height of a tree with one node"){
        val tree = Node(50, Empty , Empty)
        assert(heightCount.getHeight(tree) == 1)

    }

    test("Find the height of a tree with multiple nodes"){
        val tree = Node(42, Node(1, Empty, Node(2, Empty, Node(4, Empty, Empty))), Node(3, Empty, Node(6, Empty, Empty)))
        assert(heightCount.getHeight(tree) == 1 )
    }

    test("Find height of right heavy tree"){
        val rightSubtree = Node(1, Empty, Node(2, Empty, Node(3, Empty, Empty)))
        val tree = Node(42, Empty, rightSubtree)
        assert(heightCount.getHeight(tree) == 4)
    }

    test("Find the height of a left heavy tree"){
        val leftSubtree = Node(1, Node(2, Empty, Node(3, Empty, Empty)), Empty)
        val tree = Node(50, leftSubtree, Empty)
        assert(heightCount.getHeight(tree) == 4)
    }

    test("Find the height of a nested tree"){
      val nestedTree = Node(1,
        Node(2,
            Node(3,
            Node(4, Empty, Empty),
            Node(5, Empty, Empty)
            ),
            Node(6, Empty, Empty)
        ),
        Node(7, Empty, Empty)
        )
      assert(heightCount.getHeight(nestedTree) == 4)
    }
}

