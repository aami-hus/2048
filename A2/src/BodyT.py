## @file BodyT.py
#  @author Aamina Hussain
#  @brief Contains the type BodyT to represent bodies,
#  or a sequence of masses in space
#  @date 02/16/2021

from Shape import Shape
from functools import reduce


## @brief BodyT represents bodies, which are a sequence
#  of masses in space

class BodyT(Shape):

    ## @brief constructor for class BodyT
    #  @param x a sequence of real numbers
    #  @param y a sequence of real numbers
    #  @param m a sequence of real numbers
    #  @throws ValueError if the length of the sequences x, y, and m are
    #  not equal
    #  @throw ValueError if all the values in sequence m are not greater
    #  than zero
    def __init__(self, x, y, m):
        if not(len(x) == len(y) == len(m)):
            raise ValueError
        if not(reduce(lambda x, y: x > 0 and y > 0, m, True)):
            raise ValueError
        self.cmx = sum([x[i] * m[i] for i in range(len(m))]) / sum(m)
        self.cmy = sum([y[i] * m[i] for i in range(len(m))]) / sum(m)
        self.m = sum(m)
        self.moment = sum([m[i] * (x[i]**2 + y[i]**2) for i in range(len(m))])

    ## @brief getter for body's centre of mass x-component
    #  @return a float representing the body's centre of
    #  mass x-component
    def cm_x(self):
        return self.cmx

    ## @brief getter for body's centre of mass y-component
    #  @return a float representing the body's centre of
    #  mass y-component
    def cm_y(self):
        return self.cmy

    ## @brief getter for body's mass
    #  @return a float representing the body's mass
    def mass(self):
        return self.m

    ## @brief getter for body's moment of inertia
    #  @return a float representing the body's moment of
    #  inertia
    def m_inert(self):
        return self.moment
