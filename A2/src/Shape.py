## @file Shape.py
#  @author Aamina Hussain
#  @brief An interface for modules that implement shapes
#  @date 02/16/2021
from abc import ABC, abstractmethod


## @brief Shape provides an interface for shapes
## @details The abstract methods in this interface
#  are overridden by the modules that inherit it

class Shape(ABC):

    @abstractmethod
    ## @brief a generic method for getting the x-component of the
    #  centre of mass of a shape
    #  @return a float representing the x-component of the centre
    #  of mass of a shape
    def cm_x(self):
        pass

    @abstractmethod
    ## @brief a generic method for getting the y-component of the
    #  centre of mass of a shape
    #  @return a float representing the y-component of the centre
    #  of mass of a shape
    def cm_y(self):
        pass

    @abstractmethod
    ## @brief a generic method for getting the mass of a shape
    #  @return a float representing the mass of a shape
    def mass(self):
        pass

    @abstractmethod
    ## @brief a generic method for getting the moment of inertia of a shape
    #  @return a float representing the moment of inertia of a shape
    def m_inert(self):
        pass
