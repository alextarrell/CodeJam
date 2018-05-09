# 5
# 4 2
# 5 2
# 6 2
# 1000 1000
# 1000 1
import sys, re, math

r_stalls = re.compile(r'(\d+) (\d+)')
# def solve(line):
# 	m = r_stalls.match(line)
# 	if not m: return "Invalid Input"

# 	width = int(m.group(1))
# 	people = int(m.group(2))
# 	if width == people: return '0 0'

# 	while people > 1:
# 		# print width, people
# 		width = h_ceil(width - 1)
# 		people = h_ceil(people - 1)
# 		if width == people: return '0 0'

# 	return '{} {}'.format(h_ceil(width-1), h_floor(width-1))

# def h_floor(v):
# 	return int(math.floor(v/2.0))

# def h_ceil(v):
# 	return int(math.ceil(v/2.0))

def solve2(line):
	m = r_stalls.match(line)
	if not m: return "Invalid Input"

	gaps = [int(m.group(1))]
	L, R = 0, 0
	for _ in xrange(int(m.group(2))):
		pos, gap = largest(gaps)
		gap -= 1
		L, R = int(math.floor(gap/2.0)), int(math.ceil(gap/2.0))
		print L, R
		gaps[pos] = L
		gaps.insert(pos+1, R)

	# print gaps
	return ' '.join([str(max(L, R)), str(min(L, R))])

def largest(l):
	pos = max(xrange(len(l)), key=l.__getitem__)
	return pos, l[pos]

def handle_io():
	# print solve('20 15'), ' <-> ', solve2('20 15')

	# 20 [13, 14, 15, 16] <
	# 20 -> 10 -> 5 -> 2 -> 1
	#
	# 1 V
	#
	# 3 5 6 8 9 13 14 15 16
	#3 2 1 2 1 4  1  1  1

	# 15 0....................0  <  20 15   20 15
	# 14 0.........0..........0      9  8   10  7
	# 13 0.........0....0.....0  >   9  8    5  3
	# 12 0....0....0....0.....0      4  3    5  3
	# 11 0....0....0....0..0..0      4  3    2  1
	# 10 0.0..0....0....0..0..0  <   4  3    2  1
	#  9 0.0..0.0..0....0..0..0      1  1    2  1
	#  8 0.0..0.0..0.0..0..0..0      1  1    2  1
	#  7 0.00.0.0..0.0..0..0..0      1  1    2  1
	#  6 0.00.0.00.0.0..0..0..0      1  1    2  1
	#  5 0.00.0.00.0.00.0..0..0      1  1    2  1
	#  4 0.00.0.00.0.00.00.0..0      1  1    2  1
	#  3 0.00.0.00.0.00.00.00.0      1  1    1  0
	#  2 0000.0.00.0.00.00.00.0      1  1    1  0
	#  1 000000.00.0.00.00.00.0  V   1  1    1  0
	#  0 000000000.0.00.00.00.0      0  0    1  0
	#




	# print solve('500 250'), ' <-> ', solve2('500 250')
	# print solve('500 245'), ' <-> ', solve2('500 245')
	# print solve('1000 499'), ' <-> ', solve2('1000 499')
	for idx, line in enumerate(sys.stdin):
	  if not idx: continue
	  print "Case #{}: {}".format(idx, solve2(line.strip()))

if __name__ == '__main__':
	handle_io()
