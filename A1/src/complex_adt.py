## @file complex_adt.py
#  @author Aamina Hussain
#  @brief contains class that has methods for working with complex numbers
#  @date 21/01/2021

from math import sqrt, atan, pi

class ComplexT:

	def __init__(self, x, y):
		self.__x = float(x)
		self.__y = float(y)

	def real(self):
		return self.__x

	def imag(self):
		return self.__y

	def get_r(self):
		return sqrt(self.__x**2 + self.__y**2)

	def get_phi(self):
		if self.__x > 0 or self.__y != 0:
			return 2*atan(self.__y/(self.get_r()+self.__x))
		elif self.__x < 0 and self.__y == 0:
			return pi
		else:
			return "The phase is undefined."

	def equal(self, num):
		if self.__x == num.real() and self.__y == num.imag():
			return True
		else:
			return False

	def conj(self):
		return ComplexT(self.__x, -self.__y)

	def add(self, num):
		return ComplexT(self.__x + num.real(), self.__y + num.imag())

	def sub(self, num):
		return ComplexT(self.__x - num.real(), self.__y - num.imag())

	def mult(self, num):
		r = self.__x*num.real() - self.__y*num.imag()
		im = self.__x*num.imag() + self.__y*num.real()
		return ComplexT(r, im)

	def recip(self):
		r = self.__x/(self.__x**2+self.__y**2)
		im = -self.__y/(self.__x**2+self.__y**2)
		return ComplexT(r, im)

	def div(self, num):
		return self.mult(num.recip())

	def sqrt(self):
		r = sqrt((self.__x + self.get_r())/2)
		if self.__y > 0:
			im = sqrt((-self.__x + self.get_r())/2)
		else:
			im = -sqrt((-self.__x + self.get_r())/2)
		return ComplexT(r, im)

	#The functions div and sqrt were done assuming that the complex numbers were not of the form z = 0 + 0i.