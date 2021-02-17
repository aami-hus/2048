## @file test_All.py
#  @author Aamina Hussain
#  @brief tests implementation of python files for graphing
#  the motion of a body
#  @date 02/16/2021

from pytest import *
from CircleT import CircleT
from TriangleT import TriangleT
from BodyT import BodyT
from Scene import Scene
from Plot import plot


class TestCircleT:

	def setup_method(self, method):
		self.c1 = CircleT(1.0, 10.0, 2.0, 1.0)

	def teardown_method(self, method):
		self.c1 = None

	def test_circle_cm_x(self):
		assert self.c1.cm_x() == 1.0

	def test_circle_cm_y(self):
		assert self.c1.cm_y() == 10.0

	def test_circle_mass(self):
		assert self.c1.mass() == 1.0

	def test_circle_m_inert(self):
		assert self.c1.m_inert() == 2.0

	def test_circle_value_error(self):
		with raises(ValueError):
			CircleT(1, 10, 0, 1)

	def test_circle_value_error_2(self):
		with raises(ValueError):
			CircleT(1, 10, 0.5, -1)

	def test_circle_value_error_3(self):
		with raises(ValueError):
			CircleT(1, 10, -1, 0)


