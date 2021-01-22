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
		return int(self.__a + self.__b + self.__c)

	def area(self):
		s = (self.__a + self.__b + self.__c)/2
		A = sqrt(s*(s-self.__a)*(s-self.__b)*(s-self.__c))
		return float(A)

	def is_valid(self):
		if self.__a + self.__b <= self.__c or self.__a + self.__c <= self.__b or self.__b + self.__c <= self.__a:
			return False
		else:
			return True