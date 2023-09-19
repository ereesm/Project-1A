package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

import edu.luc.cs.laufer.cs371.shapes.sizeCount._


class TestSize extends AnyFunSuite {
    test("simple ellipse"){
        assert(size(simpleEllipse) == 1)
    }
    test("simpleRectangle"){
        assert(size(simpleRectangle) == 1)
    }
    test("simple location"){
        assert(size(simpleLocation) == 1)
    }
    test("basic group with shapes"){
        assert(size(basicGroup) == 2)
    }
    test("complex group"){
        assert(size(complexGroup) == 5)
    }
    test("0 Case, empty location"){
        assert(size(Group()) == 0)
    }
    
}