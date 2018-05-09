#! /usr/bin/python3

import sys

def send(*s):
	print(*s)
	sys.stdout.flush()

def recv():
	v = tuple(int(c) for c in input().split())
	if len(v) == 1:
		return v[0]
	else:
		return v

class Orchard(object):
	def __init__(self, size):
		self.size = size
		# self.grid = [[False for _ in range(1000)] for _ in range(1000)]
		self.grid = [[]]

	def add(self, x, y):
		# self.grid[x][y] = True
		self.grid[[]]

	def __bool__(self):
		return True

def solve(size):
	orchard = Orchard(size)

	send(10, 10)
	x, y = recv()
	if y == x == 0:
		return
	elif y == x == -1:
		raise Exception("Failed")
	else:
		pass

t = int(input())
for _ in range(t):
	solve(recv())
