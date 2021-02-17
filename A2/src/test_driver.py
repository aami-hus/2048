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


class TestTriangleT:

	def setup_method(self, method):
		self.t1 = TriangleT(1.0, 10.0, 2.0, 3.0)

	def teardown_method(self, method):
		self.t1 = None

	def test_triangle_cm_x(self):
		assert self.t1.cm_x() == 1.0

	def test_triangle_cm_y(self):
		assert self.t1.cm_y() == 10.0

	def test_triangle_mass(self):
		assert self.t1.mass() == 3.0

	def test_triangle_m_inert(self):
		assert self.t1.m_inert() == 1.0

	def test_triangle_value_error(self):
		with raises(ValueError):
			CircleT(1, 10, 0, 3)

	def test_triangle_value_error_2(self):
		with raises(ValueError):
			CircleT(1, 10, 2, -1)

	def test_triangle_value_error_3(self):
		with raises(ValueError):
			CircleT(1, 10, -1, 0)


class TestBodyT:

	def setup_method(self, method):
		self.b1 = BodyT([1, -1, -1, 1], [1, 1, -1, -1], [10, 10, 10, 10])

	def teardown_method(self, method):
		self.b1 = None

	def test_body_cmx(self):
		assert self.b1.cmx == 0

	def test_body_cmy(self):
		assert self.b1.cmy == 0

	def test_body_mass(self):
		assert self.b1.mass() == 40

	def test_body_m_inert(self):
		assert self.b1.m_inert() == 80

	def test_body_value_error(self):
		with raises(ValueError):
			BodyT([1, -1, -1, 1], [1, 1, -1, -1], [10, 10])

	def test_body_value_error_2(self):
		with raises(ValueError):
			BodyT([1, -1, -1, 1], [1, 1, -1, -1], [10, 10, 0, -4])
