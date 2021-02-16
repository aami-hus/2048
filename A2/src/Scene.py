## @file
#  @author
#  @brief
#  @date
#  @details

from scipy.integrate import odeint
from Shape import Shape


class Scene:

    def __init__(self, s, fx, fy, vx, vy):
        self.s = s
        self.Fx = fx
        self.Fy = fy
        self.vx = vx
        self.vy = vy

    def get_shape(self):
        return self.s

    def get_unbal_forces(self):
        return self.Fx, self.Fy

    def get_init_velo(self):
        return self.vx, self.vy

    def set_shape(self, new):
        self.s = new

    def set_unbal_forces(self, new_x, new_y):
        self.Fx = new_x
        self.Fy = new_y

    def set_init_velo(self, new_x, new_y):
        self.vx = new_x
        self.vy = new_y

    def sim(self, t_final, nsteps):
        t = [i * t_final / (nsteps - 1) for i in range(nsteps)]

        def __ode(w, t):
            return [w[2], w[3], self.Fx(t) / self.s.mass(), self.Fy(t) / self.s.mass()]
        return t, odeint(__ode, [self.s.cm_x(), self.s.cm_y(), self.vx, self.vy], t)
