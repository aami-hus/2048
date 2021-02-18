## @file CircleT.py
#  @author Shrill Patel
#  @brief Creates a module representing circle as a shape
#  @date 03/02/21

from Shape import Shape

## @brief Implements an ADT class representing a circle as an object
#  @details Creates a circular object that will abide by the laws of physics.
# It is assumed that the arguments provided to the access programs will be of
# correct type.


class CircleT(Shape):

    ## @brief Constructor for the CircleT class
    #  @details A circle object is made up of the x and y components of its
    # center of mass, a radius, and the mass of the circular object
    #  @param xs A real number representing x-component of the center of mass
    #  @param ys A real number representing y-component of the center of mass
    #  @param rs A real number representing the radius of the circular object
    #  @param ms A real number representing the mass of the circular object
    #  @throws ValueError if the radius and/or mass are less than or equal
    # to zero
    def __init__(self, xs, ys, rs, ms):
        if (not (rs > 0 and ms > 0)):
            raise ValueError("Radius and/or mass cannot be equal to or less",
                             "than zero.")
        self.x = xs
        self.y = ys
        self.r = rs
        self.m = ms

    ## @brief Gets the x-component of the center of mass for the circular
    # object
    #  @return A real number representing the x-component of the center of mass
    def cm_x(self):
        return self.x

    ## @brief Gets the y-component of the center of mass for the circular
    # object
    #  @return A real number representing the y-component of the center of mass
    def cm_y(self):
        return self.y

    ## @brief Gets the mass of a circular object
    #  @return A real number representing the mass of the circular object
    def mass(self):
        return self.m

    ## @brief Calculates the moment of inertia of a circular object
    #  @details This function calculates the moment of inertia by multiplying
    # the mass by the radius squared and then dividing by two
    #  @return A real number representing the moment of inertia of a circular
    # object
    def m_inert(self):
        return (self.mass() * (self.r ** 2)) / 2
