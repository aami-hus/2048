## @file CircleT.py
#  @author
#  @brief
#  @date
from Shape import Shape


class CircleT(Shape):

    def __init__(self, x, y, r, m):
        if not(r > 0 and m > 0):
            raise ValueError
        self.x = x
        self.y = y
        self.r = r
        self.m = m

    def cm_x(self):
        return self.x

    def cm_y(self):
        return self.y

    def mass(self):
        return self.m

    def m_inert(self):
        return (self.m * (self.r**2)) / 2
