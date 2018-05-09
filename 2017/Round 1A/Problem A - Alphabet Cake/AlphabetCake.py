# 3
# 3 3
# G??
# ?C?
# ??J
# 3 4
# CODE
# ????
# ?JAM
# 2 2
# CA
# KE
import sys, re, copy

def solve(grid):
	height = len(grid)
	width = len(grid[0])

	o_grid = copy.deepcopy(grid)

	for x in xrange(width):
		for y in xrange(height):
			o_letter = o_grid[y][x]
			if o_letter == '?':
				continue

			letter = grid[y][x]

			done = False
			for rr in rects(x, y, width, height):
				if not all(grid[ry][rx] in ('?', letter) for rx, ry in rr):
					continue
				for gx, gy in rr:
					grid[gy][gx] = letter
				break

	return grid

def rects(x, y, width, height):
	def _rects(width, height):
		return [(w, h) for w in xrange(width) for h in xrange(height)]

	def _offsets(x, y, w, h, rect):
		offsets = []
		for xx in xrange(-w+1, w):
			for yy in xrange(-h+1, h):
				rr = [(rx+xx+x, ry+yy+y) for rx, ry in rect]
				if all(rx>=0 and ry>=0 and rx<width and ry<height for rx, ry in rr) and (x, y) in rr:
					offsets.append(rr)
		return offsets

	rrr = [_offsets(x, y, w, h, _rects(w, h)) for w in xrange(width, 0, -1) for h in xrange(height, 0, -1)]
	return sorted([r for rr in rrr for r in rr], key=len, reverse=True)

r_group_head = re.compile(r'(\d+) (\d+)')
def handle_io():
	lines = list(sys.stdin)
	case = idx = 1
	while idx < len(lines):
		m = r_group_head.match(lines[idx])
		if not m:
			print 'error', lines[idx]
			break

		rows, _ = m.groups()
		idx += 1
		print "Case #{}: \n{}".format(case, '\n'.join(''.join(r) for r in solve([list(l.strip()) for l in lines[idx:idx+int(rows)]])))
		idx += int(rows)
		case += 1

if __name__ == '__main__':
	handle_io()
