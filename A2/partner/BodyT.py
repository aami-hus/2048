## @file BodyT.py
#  @author Shrill Patel
#  @brief Creates a module representing an irregular object
#  @date 03/02/21

from Shape import Shape

## @brief Implements an ADT class representing an irregular shape
#  @details Creates an irregular shape that follows the laws of physics. It is
# assumed that the arguments provided to the access programs will be of the
# correct type.


class BodyT(Shape):

    ## @brief Constructor for the BodyT class
    #  @details A body is made up of point masses and the x and y coordinates
    # of its center of mass
    #  @param xs A sequence of real numbers representing the x-coordinates of
    # the center of mass
    #  @param ys A sequence of real numbers representing the y-coordinates of
    # the center of mass
    #  @param ms A sequence of real numbers representing the point masses of
    # the body
    #  @throws ValueError if length of xs, ys, and ms are not equal
    #  @throws ValueError if any one of the point masses are less than or equal
    # to zero
    def __init__(self, xs, ys, ms):
        if (not (len(xs) == len(ys) == len(ms))):
            raise ValueError("Sequences of x and y components of the center of",
                             "mass and the mass must be of equal length.")

        for mass in ms:
            if mass <= 0.0:
                raise ValueError("No point masses can have a value of zero.")

        moment = self.__mmom(xs, ys, ms) - self.__sum(ms) * \
            (self.__cm(xs, ms) ** 2 + self.__cm(ys, ms) ** 2)

        if moment < 0:
            raise ValueError("Moment of inertia cannot be less than zero.")
        else:
            self.cmx = self.__cm(xs, ms)
            self.cmy = self.__cm(ys, ms)
            self.m = self.__sum(ms)
            self.moment = moment

    ## @brief Gets the x-component of the center of mass of the irregular
    # object
    #  @return A real number representing the x-component of the center of mass
    def cm_x(self):
        return self.cmx

    ## @brief Gets the y-component of the center of mass of the irregular
    # object
    #  @return A real number representing the y-component of the center of mass
    def cm_y(self):
        return self.cmy

    ## @brief Gets the mass of an irregular object
    #  @return A real number representing the mass of the object
    def mass(self):
        return self.m

    ## @brief Gets the moment of inertia of the irregular object
    #  @return A real number representing the moment of inertia for the object
    def m_inert(self):
        return self.moment

    ## @brief Calculates the total mass of an irregular object
    #  @details This function calculates the mass of an irregular object by
    # summing all of the object's point masses
    #  @param ms A sequence of real numbers
    #  @return A real number representing the total mass of the object
    def __sum(self, ms):
        total_mass = 0.0
        for mass in ms:
            total_mass += mass
        return total_mass

    ## @brief Calculates the center of mass of an irregular object
    #  @param z A sequence of real numbers
    #  @param m A sequence of real numbers representing point masses
    #  @return A real number representing the center of mass of the object
    def __cm(self, z, m):
        total = 0.0
        for i in range(len(m)):
            total += z[i] * m[i]
        return total / self.__sum(m)

    ## @brief Calculates the irregular object's mass moment
    #  @param x A sequence of real numbers
    #  @param y A sequence of real numbers
    #  @param m A sequence of real numbers representing point masses
    #  @return A real number representing the mass moment of an object
    def __mmom(self, x, y, m):
        total = 0.0
        for i in range(len(m)):
            total += m[i] * ((x[i] ** 2) + (y[i] ** 2))
        return total
