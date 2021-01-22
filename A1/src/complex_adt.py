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

	def equal(self, num):
		if self.__x == num.real and self.__y == num.imag:
			return True
		else:
			return False

	def conj(self):
		return ComplexT(self.__x, -self.__y)

	def add(self, num):
		return ComplexT(self.__x + num.real, self.__y + num.imag)

	def sub(self, num):
		return ComplexT(self.__x - num.real, self.__y - num.imag)

	def mult(self, num):
		r = self.__x*num.real - self.__y*num.imag
		im = self.__x*num.imag + self.__y*num.real
		return ComplexT(r, im)

	def div(self, num):
		r = (self.__x*num.real + self.__y*num.imag)*(1/(num.real**2+num.imag**2))
		im = (self.__y*num.real + self.__x*num.imag)*(1/(num.real**2+num.imag**2))
		return ComplexT(r, im)

