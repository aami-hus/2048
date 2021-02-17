## @file Scene.py
#  @author Aamina Hussain
#  @brief contains the class Scene which integrates
#  to find the motion of the body about the centre of mass
#  @date 02/16/2021

from scipy.integrate import odeint


## @brief Scene provides the forces and initial velocities
#  of a shape, and integrate in order to find the modtion of
#  the body.

class Scene:

    ## @brief constructor for class BodyT
    #  @param s is a Shape
    #  @param fx is a real number representing the unbalanced
    #  force function in the x-direction
    #  @param fy is a real number representing the unbalanced
    #  force function in the y-direction
    #  @param vx is a real number representing the initial
    #  velocity in the x-direction
    #  @param vy is a real number representing the initial
    #  velocity in the y-direction
    def __init__(self, s, fx, fy, vx, vy):
        self.s = s
        self.Fx = fx
        self.Fy = fy
        self.vx = vx
        self.vy = vy

    ## @brief getter for the Shape
    #  @return the Shape
    def get_shape(self):
        return self.s

    ## @brief getter for unbalanced forces
    #  @return floats representing the values of the x-
    #  and y-components of the unbalanced forces
    def get_unbal_forces(self):
        return self.Fx, self.Fy

    ## @brief getter for initial velocities
    #  @return floats representing the values of the x-
    #  and y-components of the initial velocities
    def get_init_velo(self):
        return self.vx, self.vy

    ## @brief setter for the Shape
    #  @param new is a Shape that the original Shape will be
    #  replaced with
    def set_shape(self, new):
        self.s = new

    ## @brief setter for the unbalanced forces
    #  @param new_x is a float that the original x-component
    #  of the unbalanced force will be replaced with
    #  @param new_y is a float that the original y-component
    #  of the unbalanced force will be replaced with
    def set_unbal_forces(self, new_x, new_y):
        self.Fx = new_x
        self.Fy = new_y

    ## @brief setter for the initial velocities
    #  @param new_x is a float that the original x-component
    #  of the initial velocity will be replaced with
    #  @param new_y is a float that the original y-component
    #  of the initial velocity will be replaced with
    def set_init_velo(self, new_x, new_y):
        self.vx = new_x
        self.vy = new_y

    ## @brief method that performs integration
    #  @param t_final is a real number
    #  @param nsteps is a natural number
    #  @return a sequence of real numbers and a 2-dimensional
    #  sequence of real numbers
    def sim(self, t_final, nsteps):
        t = [i * t_final / (nsteps - 1) for i in range(nsteps)]

        def __ode(w, t):
            return [w[2], w[3], self.Fx(t) / self.s.mass(), self.Fy(t) / self.s.mass()]
        return t, odeint(__ode, [self.s.cm_x(), self.s.cm_y(), self.vx, self.vy], t)
