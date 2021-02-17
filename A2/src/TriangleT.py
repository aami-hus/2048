## @file TriangleT.py
#  @author Aamina Hussain
#  @brief Contains the type TriangleT to represent triangles
#  @date 02/16/2021

from Shape import Shape


## @brief TriangleT represents equilateral triangles

class TriangleT(Shape):

    ## @brief constructor for class TriangleT
    #  @param x a real number that represents the x-component
    #  centre of mass of the triangle
    #  @param y a real number that represents the y-component
    #  centre of mass of the triangle
    #  @param s a real number that represents the side length of
    #  the triangle
    #  @param m a real number that represents the mass of the circle
    #  @throws ValueError if the side length or mass are not greater
    #  than zero
    def __init__(self, x, y, s, m):
        if not(s > 0 and m > 0):
            raise ValueError
        self.x = x
        self.y = y
        self.s = s
        self.m = m

    ## @brief getter for triangles's centre of mass x-component
    #  @return a float representing the triangle's centre of
    #  mass x-component
    def cm_x(self):
        return self.x

    ## @brief getter for triangle's centre of mass y-component
    #  @return a float representing the triangle's centre of
    #  mass y-component
    def cm_y(self):
        return self.y

    ## @brief getter for triangle's mass
    #  @return a float representing the triangle's mass
    def mass(self):
        return self.m

    ## @brief getter for triangle's moment of inertia
    #  @return a float representing the triangle's moment of
    #  inertia
    def m_inert(self):
        return (self.m * (self.s**2)) / 12
