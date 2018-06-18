import angr
import claripy
import sys

def main(argv):
	path_to_binary = argv[1]
	leak = int(argv[2], 16)
	project = angr.Project(path_to_binary)

	initial_state = project.factory.blank_state(addr=0x401274)
	initial_state.regs.rsp = leak - 0x60
	initial_state.regs.rbp = leak + 0x100

	initial_state.globals['solutions'] = []

	class ReplacementScanf(angr.SimProcedure):
	    def run(self, format_string, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10):
			scanf1 = claripy.BVS('scanf1', 64)
			scanf2 = claripy.BVS('scanf2', 64)
			scanf3 = claripy.BVS('scanf3', 64)
			scanf4 = claripy.BVS('scanf4', 64)
			scanf5 = claripy.BVS('scanf5', 64)
			scanf6 = claripy.BVS('scanf6', 64)
			scanf7 = claripy.BVS('scanf7', 64)
			scanf8 = claripy.BVS('scanf8', 64)
			scanf9 = claripy.BVS('scanf9', 64)
			scanf10 = claripy.BVS('scanf10', 64)

			# The scanf function writes user input to the buffers to which the 
			# parameters point.
			self.state.memory.store(s1, scanf1, endness=project.arch.memory_endness)
			self.state.memory.store(s2, scanf2, endness=project.arch.memory_endness)
			self.state.memory.store(s3, scanf3, endness=project.arch.memory_endness)
			self.state.memory.store(s4, scanf4, endness=project.arch.memory_endness)
			self.state.memory.store(s5, scanf5, endness=project.arch.memory_endness)
			self.state.memory.store(s6, scanf6, endness=project.arch.memory_endness)
			self.state.memory.store(s7, scanf7, endness=project.arch.memory_endness)
			self.state.memory.store(s8, scanf8, endness=project.arch.memory_endness)
			self.state.memory.store(s9, scanf9, endness=project.arch.memory_endness)
			self.state.memory.store(s10, scanf10, endness=project.arch.memory_endness)

			self.state.globals['solutions'].append(scanf1)
			self.state.globals['solutions'].append(scanf2)
			self.state.globals['solutions'].append(scanf3)
			self.state.globals['solutions'].append(scanf4)
			self.state.globals['solutions'].append(scanf5)
			self.state.globals['solutions'].append(scanf6)
			self.state.globals['solutions'].append(scanf7)
			self.state.globals['solutions'].append(scanf8)
			self.state.globals['solutions'].append(scanf9)
			self.state.globals['solutions'].append(scanf10)

			self.state.regs.rax = 10

	scanf_symbol = '__isoc99_scanf'
	project.hook_symbol(scanf_symbol, ReplacementScanf())

	instruction_to_skip_length = 5
	@project.hook(0x40126f, length=instruction_to_skip_length)
	def skip_printf(state):
		pass

	simgr = project.factory.simgr(initial_state)

	simgr.explore(find=0x401441, avoid=0x40145d)

	if simgr.found:
		print 'found'
		solution_state = simgr.found[0]

		# Grab whatever you set aside in the globals dict.
		stored_solutions = solution_state.globals['solutions']

		for i in range(len(stored_solutions)):
		    sol = solution_state.se.eval(stored_solutions[i])
		    sol = -(0x10000000000000000 - sol) if sol >= 0x8000000000000000 else sol
		    sys.stdout.write(str(sol))
		    sys.stdout.write(' ')

		print ''
	else:
		raise Exception('Could not find the solution')

if __name__ == '__main__':
  main(sys.argv)