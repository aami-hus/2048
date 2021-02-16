## @file TriangleT.py
#  @author
#  @brief
#  @date

from Shape import Shape

class TriangleT:

	def __init__(self, x, y, s, m):
		if not(s > 0 and m > 0):
			return ValueError
		self.x = x
		self.y = y
		self.s = s
		self.m = m

	def cm_x(self):
		return self.x

	def cm_y(self):
		return self.y

	def mass(self):
		return self.m

	def m_inert(self):
		return (self.m*(self.s**2))/12