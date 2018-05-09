#! /usr/bin/python3

def solve(arr):
	sorted_arr = sorted(arr)
	troubled_arr = troub_sorted(arr)
	return next((idx for idx in range(len(arr)) if sorted_arr[idx] != troubled_arr[idx]), 'OK')

def troub_sorted(arr):
	done = False
	while not done:
		done = True
		for idx in range(len(arr)-2):
			if arr[idx] > arr[idx+2]:
				done = False
				# print('[' + ' '.join(arr[:idx]) + '|' + ' '.join(arr[idx:idx+3]) + '|' + ' '.join(arr[idx+3:]) + ']', '-->', '[' + ' '.join(arr[:idx] + [arr[idx+2]] + [arr[idx+1]] + [arr[idx]]+ arr[idx+3:]) + ']')
				arr[idx], arr[idx+2] = arr[idx+2], arr[idx]
	return arr

def rand_list(size):
	l = list(range(size))
	import random
	random.shuffle(l)
	print(" ".join(str(s) for s in l))
	return l
	
t = int(input())
for i in range(1, t + 1):
	input()
	print("Case #{}: {}".format(i, solve([int(c) for c in input().split()])))

rand_list(100000)
