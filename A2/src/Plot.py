## @file
#  @author
#  @brief
#  @date
#  @details

import matplotlib.pyplot as plt

def plot(w, t):
	if not(len(w)==len(t)):
		return ValueError
	x = [w[i][0] for i in range(len(w))]
	y = [w[i][1] for i in range(len(w))]
	fig, axs = plt.subplots(3)
	fig.suptitle('Motion Simulation')
	axs[0].plot(t, x)
	axs[1].plot(t, y)
	axs[2].plot(x, y)
	plt.show()