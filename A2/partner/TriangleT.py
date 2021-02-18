## @file TriangleT.py
#  @author Shrill Patel
#  @brief Creates a module representing a triangle as a shape
#  @date 03/02/21

from Shape import Shape

## @brief Implements an ADT class representing a triangle as an object
#  @details Creates a triangular object that will abide by the laws of
# physics. It is assumed that the arguments provided to the access programs
# will be of the correct type.


class TriangleT(Shape):

    ## @brief Constructor for the TriangleT class
    #  @details A triangle object is made up of the x and y components of its
    # center of mass, its side length, and the mass of the triangle
    #  @param xs A real number representing x-component of the center of mass
    #  @param ys A real number representing y-component of the center of mass
    #  @param ss A real number representing the side lengths of the triangle
    #  @param ms A real number representing the mass of the triangle
    #  @throws ValueError if side length and/or mass are less than or equal
    # to zero
    def __init__(self, xs, ys, ss, ms):
        if (not (ss > 0 and ms > 0)):
            raise ValueError("Side length and/or mass cannot be equal to or",
                             "less than zero.")
        self.x = xs
        self.y = ys
        self.s = ss
        self.m = ms

    ## @brief Gets the x-component of the center of mass for the triangle
    #  @return A real number representing the x-component of the center of mass
    def cm_x(self):
        return self.x

    ## @brief Gets the y-component of the center of mass for the triangle
    #  @return A real number representing the y-component of the center of mass
    def cm_y(self):
        return self.y

    ## @brief Gets the mass of the triangle
    #  @return A real number representing the mass of the triangle
    def mass(self):
        return self.m

    ## @brief Calculates the moment of inertia of a triangle
    #  @details This functions calculates the moment of inertia by multiplying
    # the mass by the side length squared then dividing that by twelve
    #  @return A real number representing the moment of inertia of a triangle
    def m_inert(self):
        return (self.mass() * (self.s ** 2)) / 12
