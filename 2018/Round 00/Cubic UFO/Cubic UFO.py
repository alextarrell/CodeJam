#! /usr/bin/python3

class Impossible(Exception):
	pass

def solve(shield, sequence):
	shield = int(shield)

	if len([c for c in sequence if c == 'S']) > shield:
		return 'IMPOSSIBLE'

	try:
		hacks = 0
		while calc_damage(sequence) > shield:
			sequence = apply_hacks(sequence)
			hacks += 1
		return hacks
	except Impossible:
		return 'IMPOSSIBLE'

def calc_damage(seq):
	strength = 1
	damage = 0
	for c in seq:
		if c == 'C':
			strength *= 2
		elif c == 'S':
			damage += strength
	return damage

def apply_hacks(seq):
	pos = next((idx for idx in reversed(range(len(seq)-1)) if seq[idx] == 'C' and seq[idx+1] == 'S'), None)
	if pos is None:
		raise Impossible()
	# print(seq, '-->', seq[:pos] + '|' + seq[pos] + seq[pos+1] + '|' + seq[pos+2:], '-->', seq[:pos] + seq[pos+1] + seq[pos] + seq[pos+2:], '({})'.format(calc_damage(seq)))
	return seq[:pos] + seq[pos+1] + seq[pos] + seq[pos+2:]

t = int(input())
for i in range(1, t + 1):
	print("Case #{}: {}".format(i, solve(*input().split())))
