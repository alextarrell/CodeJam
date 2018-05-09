# 4
# 132
# 1000
# 7
# 111111111111111110
import sys

def solve(line):
	upper = int(line)
	line = '9' * len(line)
	while int(line) > upper or not is_tidy(line):
		pos = max(xrange(len(line)), key=line.__getitem__)
		line = line[:pos] + str(int(line[pos])-1) + '9'*(len(line)-pos-1)
		if line[0] == '0':
			line = '9' * (len(line) - 1)
	return line

def is_tidy(val):
	return all(int(val[i-1]) <= int(val[i]) for i in xrange(1, len(val)))

def handle_io():
	for idx, line in enumerate(sys.stdin):
	  if not idx: continue
	  print "Case #{}: {}".format(idx, solve(line.strip()))

if __name__ == '__main__':
	handle_io()
