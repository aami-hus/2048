## @file complex_adt.py
#  @author Shrill Patel
#  @brief Creates a class that works with complex numbers
#  @date 01/12/21

import math

## @brief Implements an ADT for complex numbers 
#  @details A complex number is made up of real and imaginary parts
class ComplexT:

	## @brief Constructor for the ComplexT class
	#  @details Creates a ComplexT object which creates a complex number
	#			that has a real and an imaginary part. Assumed the user will
	#			enter the correct type of input (floats). 
	#  @param x Float representing real part of the complex number
	#  @param y Float representing imaginary part of the complex number 
	def __init__(self, x, y):
		self.__x = x
		self.__y = y

	## @brief Gets the real part of the complex number 
	#  @return The float representing real portion of the complex number 
	def real(self):
		return self.__x

	## @brief Gets the imaginary part of the complex number 
	#  @return The float representing imaginary portion of the complex number 
	def imag(self):
		return self.__y

	## @brief Calculates the magnitude of the complex number 
	#  @return The magnitude of the complex number
	def get_r(self):
		return math.sqrt(math.pow(self.real(), 2) + math.pow(self.imag(), 2))

	## @brief Calculates the argument of the complex number 
	#  @details Checks real and imaginary parts of given complex number 
	#			and returns the appropriate angle from positive x-axis in
	#			radians. This function assumes domain is (-pi, pi).
	#  @return The argument of the complex number 
	#  @throws Exception if both real and imaginary parts are 0
	def get_phi(self):
		if self.real() == 0 and self.imag() == 0:
			raise Exception("Both real and imaginary parts cannot be 0!")
		elif self.real() < 0 and self.imag() == 0:
			return math.pi
		else:
			return 2 * math.atan(self.imag() / (self.get_r() + self.real()))

	## @brief Checks if 2 complex numbers are the same 
	#  @details Checks if the real and imaginary parts of 2 complex numbers
	#			are equal
	#  @param num A complex number of type ComplexT
	#  @return True if both complex numbers are equal, otherwise False 
	def equal(self, num):
		return num.real() == self.real() and num.imag() == self.imag()
	
	## @brief Calculates the conjugate of a given complex number
	#  @return The complex conjugate of the original complex number	
	def conj(self):
		conjugate = self.imag() * -1
		return ComplexT(self.real(), conjugate)

	## @brief Adds two complex numbers togther
	#  @param complexNum A complex number of type ComplexT
	#  @return The complex number that results from the addition 
	def add(self, complexNum):
		return ComplexT(self.real() + complexNum.real(), 
						self.imag() + complexNum.imag())

	## @brief Subtracts two complex numbers from each other
	#  @param complexNum A complex number of type ComplexT
	#  @return The complex number that results from the subtraction 
	def sub(self, complexNum):
		return ComplexT(self.real() - complexNum.real(), 
						self.imag() - complexNum.imag())

	## @brief Multiplication of two complex numbers 
	#  @param num A complex number of type ComplexT
	#  @return The product of two complex numbers
	def mult(self, num):
		return ComplexT(self.real() * num.real() - self.imag() * num.imag(),
						self.real() * num.imag() + self.imag() * num.real())

	## @brief Calculates the reciprocal of a given complex number 
	#  @return The reciprocated complex number 
	#  @throws Exception if the denominator is 0
	def recip(self):
		denom = math.pow(self.real(), 2) + math.pow(self.imag(), 2)
		if denom == 0:
			raise Exception("Dividing by 0 is not possible!")
		realPart = self.real() / denom
		imagPart = -1 * (self.imag() / denom)
		return ComplexT(realPart, imagPart)

	## @brief Divides two complex numbers by each other 
	#  @param complexNum A complex number of type ComplexT
	#  @return The quotient of the two complex numbers
	def div(self, complexNum):
		return self.mult(complexNum.recip())

	## @brief Computes the square root of a complex number 
	#  @return The complex number that is produced after applying a
	#		   square root to it
	#  @throws Exception if the imaginary part of the complex number is 0
	def sqrt(self):
		if (self.imag() == 0):
			raise Exception("Imaginary part of complex number cannot be 0!")
		real = math.sqrt((self.real() + self.get_r()) / 2)
		signum = self.imag() / abs(self.imag())
		imaginary = signum * math.sqrt(((-1 * self.real()) + self.get_r()) / 2)
		return ComplexT(real, imaginary)
