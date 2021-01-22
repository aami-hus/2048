## @file complex_adt.py
#  @author 
#  @brief 
#  @date 

from math import sqrt, atan, pi

class ComplexT:

	def __init__(self, x, y):
		self.__x = x
		self.__y = y

	def real(self):
		return self.__x

	def imag(self):
		return self.__y

	def get_r(self):
		return sqrt(self.__x**2 + self.__y**2)

	def get_phi(self):
		if x > 0 or y != 0:
			return 2*atan(y/(self.get_r+x))
		elif x < 0 and y == 0:
			return pi
		else:
			return "The phase is undefined."

	def equal(self, complexnum):
		if self.__x == complexnum.real and self.__y == complexnum.imag:
			return True
		else:
			return False

