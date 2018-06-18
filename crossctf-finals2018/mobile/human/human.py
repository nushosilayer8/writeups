def factorial(g):
	if g == 1:
		return 120
	else:
		return [984, 88, 16, 912][(g-2)%4]
def crank():
	flag = ''
	for level in range(1,13):
		prod=1
		for curr in range(1, (1<<level)+1):
			prod *= factorial(curr)
	while prod % 10 == 0:
		prod = prod // 10
	flag+= str(prod%1000).rjust(3,'0')
	return flag
print(crank())

