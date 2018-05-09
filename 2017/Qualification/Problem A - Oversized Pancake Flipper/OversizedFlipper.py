# 3
# ---+-++- 3
# +++++ 4
# -+-+- 4
import sys, re

r_line = re.compile(r'([-+]+) (\d+)')
def solve(line):
	m = r_line.match(line)
	if not m: return "Invalid  Input"

	pancakes = [True if c == '+' else False for c in m.group(1)]
	flipper = int(m.group(2))

	flips = 0
	for idx in xrange(len(pancakes) - flipper + 1):
		if not pancakes[idx]:
			pancakes = pancakes[:idx] + [not p for p in pancakes[idx:idx+flipper]] + pancakes[idx+flipper:]
			flips += 1
	return flips if all(p for p in pancakes) else "IMPOSSIBLE"

def handle_io():
	for idx, line in enumerate(sys.stdin):
	  if not idx: continue
	  print "Case #{}: {}".format(idx, solve(line.strip()))

if __name__ == '__main__':
	handle_io()
