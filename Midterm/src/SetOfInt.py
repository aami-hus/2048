## @file SetOfInt.py
#  @author Aamina Hussain
#  @brief Set of integers
#  @date 03/04/2021

class SetOfInt:

	def __init__(self, x_s):
		self.s = set(x_s)
		print(self.s)

	def is_member(self, x):
		if x in self.s:
			return True
		return False

	def to_seq(self):
		return list(self.s)

	def union(self, t):
		new = self.to_seq() + t.to_seq()
		return SetOfInt(new)

	def diff(self, t):
		t_seq = t.to_seq()
		s_seq = self.to_seq()
		new = []
		for i in range(len(s_seq)):
			if s_seq[i] not in t_seq:
				new.append(s_seq[i])
		return SetOfInt(new)

	def size(self):
		return len(self.s)

	def empty(self):
		return len(self.s) == 0

	def equals(self, t):
		return self.s == t.s
