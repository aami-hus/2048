## @file CircleT.py
#  @author Aamina Hussain
#  @brief Contains the type CircleT to represent circles
#  @date 02/16/2021

from Shape import Shape


## @brief CircleT represents circles

class CircleT(Shape):

    ## @brief constructor for class CircleT
    #  @param x a real number that represents the x-component
    #  centre of mass of the circle
    #  @param y a real number that represents the y-component
    #  centre of mass of the circle
    #  @param r a real number that represents the position of
    #  the circle
    #  @param m a real number that represents the mass of the circle
    #  @throws ValueError if the position or mass are not greater
    #  than zero
    def __init__(self, x, y, r, m):
        if not(r > 0 and m > 0):
            raise ValueError
        self.x = x
        self.y = y
        self.r = r
        self.m = m

    ## @brief getter for circle's centre of mass x-component
    #  @return the value of circle's centre of mass x-component
    def cm_x(self):
        return self.x

    ## @brief getter for circle's centre of mass y-component
    #  @return the value of circle's centre of mass y-component
    def cm_y(self):
        return self.y

    ## @brief getter for circle's mass
    #  @return the value of circle's mass
    def mass(self):
        return self.m

    ## @brief getter for circle's moment of inertia
    #  @return the value of circle's moment of inertia
    def m_inert(self):
        return (self.m * (self.r**2)) / 2
