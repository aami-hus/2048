## @file triangle_adt.py
#  @author 
#  @brief 
#  @date 

from math import sqrt, atan, pi

class TriangleT:

	def __init__(self, a, b, c):
		self.__a = int(a)
		self.__b = int(b)
		self.__c = int(c)

	def get_sides(self):
		return (self.__a, self.__b, self.__c)

	def equal(self, triangle):
		lstself = [self.__a, self.__b, self.__c]
		lsttri = list(triangle.get_sides())
		lstself.sort()
		lsttri.sort()
		return lstself == lsttri

	def perim(self):
		return self.__a + self.__b + self.__c

