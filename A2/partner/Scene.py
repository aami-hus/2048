## @file Scene.py
#  @author Shrill Patel
#  @brief Creates a module to calculate all of the needed information to plot
# the simulation of a Shape.
#  @date 07/02/21

from scipy import integrate

## @brief This template module will help calculate all necessary data to create
# a simulation of an object in 2D space.
#  @details This module will be in charge of determining the information/data
# needed to plot position vs. time, velocity vs. time, and acceleration vs.
# time graphs which are used to simulate how an object will react to forces in
# 2D space. These simulations are based off of the equation for Newton's
# second law of motion.


class Scene():

    ## @brief Constructor for the Scene module
    #  @details The simulation of a shape in 2D space is created with the data
    # of the shape, unbalanced force function in the x direction, the
    # unbalanced force function in the y direction, the initial velocity in the
    # x direction, and the initial velocity in the y direction.
    #  @param shape A Shape object that the simulation will be based on
    #  @param Fx_prime An unbalanced force function in the x direction
    #  @param Fy_prime An unbalanced force function in the y direction
    #  @param vx_prime The initial velocity of the object in the x direction
    #  @param vy_prime The initial velocity of the object in the y direction
    def __init__(self, shape, Fx_prime, Fy_prime, vx_prime, vy_prime):
        self.s = shape
        self.Fx = Fx_prime
        self.Fy = Fy_prime
        self.vx = vx_prime
        self.vy = vy_prime

    ## @brief Gets the type of shape that is being simulated
    #  @return A shape object depending on the type of shape
    def get_shape(self):
        return self.s

    ## @brief Gets the x and y direction forces acting on the shape
    #  @return A tuple of the x and y components of the forces
    def get_unbal_forces(self):
        return self.Fx, self.Fy

    ## @brief Gets the x and y components of the initial velocity of the object
    #  @return A tuple of the x and y components of the initial velocity
    def get_init_velo(self):
        return self.vx, self.vy

    ## @brief Mutates the current shape into another kind of shape
    #  @param s_prime A new type of Shape
    def set_shape(self, s_prime):
        self.s = s_prime

    ## @brief Mutates the unbalanced force functions in both the x and y
    # directions
    #  @param Fx_prime A new function for the forces acting on the object in
    # the x direction
    #  @param Fy_prime A new function for the forces acting on the object in
    # the y direction
    def set_unbal_forces(self, Fx_prime, Fy_prime):
        self.Fx, self.Fy = Fx_prime, Fy_prime

    ## @brief Mutates the x and y components of the initial velocity of the
    # object
    #  @param A new x component of the initial velocity
    #  @param A new y component of the initial velocity
    def set_init_velo(self, vx_prime, vy_prime):
        self.vx, self.vy = vx_prime, vy_prime

    ## @brief Computes all of the ODE's requires to plot the simulations
    #  @details Using th scipy library provided by Python, this function
    # will calculate the ODE equations through the process of integration.
    #  @param t_final A real number representing the end time of the simulation
    #  @param nsteps A natural number presenting the number of time intervals
    # to calculate
    #  @return A tuple of sequences that will be used to graph its positions in
    # 2D space
    def sim(self, t_final, nsteps):
        t = [(i * t_final) / (nsteps - 1) for i in range(nsteps)]
        return t, integrate.odeint(self.__ode, [self.s.cm_x(), self.s.cm_y(),
                                   self.vx, self.vy], t)

    ## @brief This is a used to help calculate the ODE's that represent the
    # simulation of the object
    #  @param w A sequence of real numbers containing the center of mass and
    # initial velocity components
    #  @param t A real number representing a moment in time
    #  @return A sequence of real numbers used to compute ODE's required for
    # the simulation
    def __ode(self, w, t):
        return [w[2], w[3], self.Fx(t) / self.s.mass(),
                self.Fy(t) / self.s.mass()]
