## @file Plot.py
#  @author Aamina Hussain
#  @brief contains a method that plots graphs
#  @date 02/16/2021

import matplotlib.pyplot as plt


## @brief plots three graphs that describe the motion
#  of a body
#  @param w is a 2-dimensional sequence of real numbers
#  @param t is a sequence of real numbers
def plot(w, t):
    if not(len(w) == len(t)):
        return ValueError
    x = [w[i][0] for i in range(len(w))]
    y = [w[i][1] for i in range(len(w))]
    fig, axs = plt.subplots(3)
    fig.suptitle('Motion Simulation')
    axs[0].plot(t, x)
    axs[0].set(ylabel='x (m)')
    axs[1].plot(t, y)
    axs[1].set(ylabel='y (m)')
    axs[2].plot(x, y)
    axs[2].set(xlabel='x (m)', ylabel='y (m)')
    plt.show()
