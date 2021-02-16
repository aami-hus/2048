## @file BodyT.py
#  @author
#  @brief
#  @date

from Shape import Shape
from functools import reduce


class BodyT:

    def __init__(self, x, y, m):
        if not(len(x) == len(y) == len(m)):
            return ValueError
        if not(reduce(lambda x, y: x > 0 and y > 0, m, True)):
            return ValueError
        self.cmx = sum([x[i] * m[i] for i in range(len(m))]) / sum(m)
        self.cmy = sum([y[i] * m[i] for i in range(len(m))]) / sum(m)
        self.m = sum(m)
        self.moment = sum([m[i] * (x[i]**2 + y[i]**2) for i in range(len(m))])

    def cm_x(self):
        return self.cmx

    def cm_y(self):
        return self.cmy

    def mass(self):
        return self.m

    def m_inert(self):
        return self.moment
