## @file triangle_adt.py
#  @author Shrill Patel
#  @brief Creates a class that works with triangles
#  @date 01/14/21

import math
from enum import Enum, auto

## @brief Implements a enumerated class for classifying triangles
#  @details A triangle is equilateral if it has 3 equal sides,
#			isosceles if it has 2 equal sides, scalene if no sides
#			are equal, and right if it has a right angle.
class TriType(Enum):
	equilat = auto()
	isosceles = auto()
	scalene = auto()
	right = auto()

## @brief Implements an ADT class for dealing with triangles
#  @details A triangle is made up of three non-negative side lengths
class TriangleT:

	## @brief Constructor for the TriangleT class
	#  @details Creates a TriangleT object which creates a triangle
	#			that has non-negative side lengths 
	#  @param a Integer representing the first side length of the triangle
	#  @param b Integer representing the second side length of the triangle
	#  @param c Integer representing the third side length of the triangle
	#  @throws Exception if any side length is less than or equal to 0
	def __init__(self, a, b, c):
		if (a <= 0 or b <= 0 or c <= 0):
			raise Exception("Side length cannot be less than or equal to 0!")
		else:
			self.__a = a
			self.__b = b
			self.__c = c

	## @brief Fetches all the side length values of given triangle
	#  @return The side lengths of the triangle 
	def get_sides(self):
		return self.__a, self.__b, self.__c

	## @brief Checks if all the side lengths of both triangles are equal
	#  @param triangle A triangle of type TriangleT 
	#  @return True if all side lengths are equal, otherwise False 
	def equal(self, triangle):
		return sorted(triangle.get_sides()) == sorted(self.get_sides())

	## @brief Calculates the perimeter of the given triangle
	#  @details This function calculates the perimeter of the given
	#			triangle assuming that the triangle is a valid one.
	#  @return The sum of all the sides lengths of the triangle
	def perim(self):
		sides = self.get_sides()
		return sides[0] + sides[1] + sides[2]

	## @brief Calculates the area of the given triangle
	#  @details Given a triangle, this function calculates the area of 
	#		   the given triangle using the Heron's formula (as stated
	#		   by https://www.mathsisfun.com/geometry/herons-formula.html).
	#		   This function assumes that the input triangle will be a 
	#		   mathematically valid one.
	#  @return The area of the given triangle
	def area(self):
		sides = self.get_sides()
		s = self.perim() / 2
		return math.sqrt(s * (s - sides[0]) * (s - sides[1]) * (s - sides[2]))

	## @brief Determines if the given side lengths forms a valid triangle
	#  @detials Determines if a valid triangle is formed with the given 
	#			side lengths. Does so by comparing the sum of two sides
	#			with the third side, if any one of the possible 
	#			combinations is less than or equal to the third side, it
	#			is not a valid triangle (as stated by
	#			https://tinyurl.com/y4w465sl).
	#  @return True if all sides form valid triangle, false otherwise
	def is_valid(self):
		sides = self.get_sides()
		if ((sides[0] + sides[1] <= sides[2]) or
			(sides[0] + sides[2] <= sides[1]) or
			(sides[1] + sides[2] <= sides[0])):
			return False
		else:
			return True

	## @brief Determines the type of a triangle
	#  @detials Using the enumerated class TriType, this function 
	#			classifies triangles into either equilateral,
	#			isosceles, scalene, and/or right. An isosceles
	#			or scalene triangle can also be classified as a
	#			right-angled triangle. In this case, assume 
	#			function returns that the triangle is right.
	#  @return The TriType corresponding to the correct classification
	#		   of a triangle
	#  @throws Exception if a valid triangle in not inputed
	def tri_type(self):
		if (self.is_valid()):
			s = sorted(self.get_sides())
			if s[0] == s[1] == s[2]:
				return TriType.equilat
			else:
				if math.pow(s[0], 2) + math.pow(s[1], 2) == math.pow(s[2], 2):
					return TriType.right
				elif s[0] == s[1] or s[1] == s[2] or s[2] == s[0]:
					return TriType.isosceles
				else:
					return TriType.scalene
		else:
			raise Exception("Invalid triangle given!")
