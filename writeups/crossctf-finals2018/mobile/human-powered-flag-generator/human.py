def run(level):
	prod = 1
	for i in range(1, (1<<level)+1):
		prod *= factor(i)
	while prod % 10 == 0:
		prod = prod // 10
	return str(prod%1000).rjust(3,'0')
def factor(g):
	if g == 1:
		return 120
	else:
		return [984, 88, 16, 912][(g-2)%4]
''.join(run(i) for i in range(1,13))