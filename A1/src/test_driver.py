## @file test_driver.py
#  @author Aamina Hussain
#  @brief contains tests for TriangleT (triangle_adt.py) and ComplexT (complex_adt.py) classes
#  @date 21/01/2021

from complex_adt import ComplexT
from triangle_adt import TriangleT



# ***tests for complex_adt.py:

c1 = ComplexT(3,4)
c2 = ComplexT(3,4)
c3 = ComplexT(5,6)
c4 = c1.conj()
c5 = c1.add(c3)
c6 = c1.sub(c3)
c7 = c1.mult(c3)
c9 = c1.div(c3)
c10 = c1.recip()
c11 = c1.sqrt()

# real and imag
if c1.real() == 3 and c2.imag() == 4:
	print("real and imag methods working")
else:
	print("real and imag methods failed")

# get_r
if c1.get_r() == 5:
	print("get_r method working")
else:
	print("get_r method failed")

# equal
if c1.equal(c2) == True and c1.equal(c3) == False:
	print("equal method working")
else:
	print("equal method failed")

# conj
if c4.real() == 3 and c4.imag() == -4:
	print("conj method working")
else:
	print("conj method failed")

# add
if c5.equal(ComplexT(8, 10)):
	print("add method working")
else:
	print("add method failed")

# sub
if c6.real() == -2 and c6.imag() == -2:
	print("sub method working")
else:
	print("sub method failed")

# mult
if c7.real() == -9 and c7.imag() == 38:
	print("mult method working")
else:
	print("mult method failed")

# div
if c9.real() == 0.639344262295082 and c9.imag() == 0.03278688524590162:
	print("div method working")
else:
	print("div method failed")

# recip
if c10.real() == 0.12 and c10.imag() == -0.16:
	print("recip method working")
else:
	print("recip method failed")

#sqrt
print(c1.sqrt())

############################################################################

# ***tests for triangle_adt.py:

tri1 = TriangleT(3,4,5)
tri2 = TriangleT(3,4,5)
tri3 = TriangleT(7,8,9)
tri4 = TriangleT(4,3,5)
tri5 = TriangleT(1,2,100)

# get_sides
a = tri1.get_sides()
b = tri3.get_sides()
if a == (3,4,5) and b == (7,8,9):
	print("get_sides method working")
else:
	print("get_sides method failed")

# equal
if tri1.equal(tri2) == True and tri1.equal(tri3) == False and tri1.equal(tri4) == True:
	print("equal method working")
else:
	print("equal method failed")

# perim
if tri1.perim() == 12:
	print("perim method working")
else:
	print("perim method failed")

# area
if tri1.area() == 6:
	print("area method working")
else:
	print("area method failed")

# is_valid
if tri1.is_valid() == True and tri3.is_valid() == True and tri5.is_valid() == False:
	print("is_valid method working")
else:
	print("is_valid method failed")