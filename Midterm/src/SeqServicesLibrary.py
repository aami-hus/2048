## @file SeqServicesLibrary.py
#  @author Aamina Hussain
#  @brief Library module that provides functions for working with sequences
#  @details This library assumes that all functions will be provided with arguments of the expected types
#  @date 03/04/2021

def max_val(s):
	if len(s) == 0:
		raise ValueError
	for i in range(len(s)):
		s[i] = abs(s[i])
	return max(s)

def count(t, s):
	if len(s) == 0:
		raise ValueError
	counter = 0
	for i in range(len(s)):
		if s[i] == t:
			counter+=1
	return counter

def spices(s):
	if len(s) == 0:
		raise ValueError
	spice = []
	for i in range(len(s)):
		if s[i] <= 0:
			spice.append("nutmeg")
		else:
			spice.append("ginger")
	return spice

def new_max_val(s, f):
	if len(s) == 0:
		raise ValueError
	new = []
	for i in range(len(s)):
		new.append(f(s[i]))
	return max_val(new)
