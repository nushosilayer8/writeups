# CrossCTF Finals 2018 : Rochefort 8 (re)

> Why have a Rochefort 6 when you can have a Rochefort 8?
>
> nc ctf.pwn.sg 16667
>
> Creator - waituck (@wongwaituck)
>
> [towerofbeer](./towerofbeer)

## Analysis
Like [rochefort6](../rochefort6), it asks for a number, we choose 8, then it presents us with the challenge.

Being noob and using IDA gives us

```
unsigned __int64 sub_401209()
{
  __int64 v1; // [rsp+8h] [rbp-158h]
  char v2; // [rsp+10h] [rbp-150h]
  __int64 v3; // [rsp+30h] [rbp-130h]
  __int64 v4; // [rsp+38h] [rbp-128h]
  __int64 v5; // [rsp+58h] [rbp-108h]
  int v6; // [rsp+60h] [rbp-100h]
  int *v7; // [rsp+68h] [rbp-F8h]
  int *v8; // [rsp+70h] [rbp-F0h]
  __int64 v9; // [rsp+78h] [rbp-E8h]
  int *v10; // [rsp+80h] [rbp-E0h]
  int v11; // [rsp+88h] [rbp-D8h]
  __int64 v12; // [rsp+90h] [rbp-D0h]
  int *v13; // [rsp+98h] [rbp-C8h]
  int *v14; // [rsp+A0h] [rbp-C0h]
  __int64 *v15; // [rsp+A8h] [rbp-B8h]
  int v16; // [rsp+B0h] [rbp-B0h]
  __int64 v17; // [rsp+B8h] [rbp-A8h]
  int *v18; // [rsp+C0h] [rbp-A0h]
  int *v19; // [rsp+C8h] [rbp-98h]
  __int64 v20; // [rsp+D0h] [rbp-90h]
  int v21; // [rsp+D8h] [rbp-88h]
  __int64 *v22; // [rsp+E0h] [rbp-80h]
  __int64 v23; // [rsp+E8h] [rbp-78h]
  __int64 v24; // [rsp+F0h] [rbp-70h]
  __int64 v25; // [rsp+F8h] [rbp-68h]
  int v26; // [rsp+100h] [rbp-60h]
  __int64 *v27; // [rsp+108h] [rbp-58h]
  __int64 v28; // [rsp+110h] [rbp-50h]
  __int64 v29; // [rsp+118h] [rbp-48h]
  __int64 v30; // [rsp+120h] [rbp-40h]
  int v31; // [rsp+128h] [rbp-38h]
  __int64 v32; // [rsp+130h] [rbp-30h]
  __int64 v33; // [rsp+138h] [rbp-28h]
  int *v34; // [rsp+140h] [rbp-20h]
  __int64 v35; // [rsp+148h] [rbp-18h]
  unsigned __int64 v36; // [rsp+158h] [rbp-8h]

  v36 = __readfsqword(0x28u);
  if ( ptrace(0, 0LL, 1LL, 0LL) == -1 )
  {
    puts("Something bad happened!");
    exit(1);
  }
  printf("This address may be interesting...\n0x%lx\n", &v6);
  v6 = 3;
  v11 = 5;
  v16 = 1;
  v21 = 6;
  v26 = 2;
  v31 = 4;
  v7 = &v11;
  v8 = &v16;
  v9 = 0LL;
  v10 = &v11;
  v12 = -3LL;
  v13 = &v21;
  v14 = &v26;
  v15 = &v4;
  v17 = 0x7FFFFFFFFFFFFFFFLL;
  v18 = &v26;
  v19 = &v31;
  v20 = 0LL;
  v22 = &v3;
  v23 = 0LL;
  v24 = 0LL;
  v25 = -3405691582LL;
  v27 = &v5;
  v28 = 0LL;
  v29 = 0LL;
  v30 = -1LL;
  v32 = 0LL;
  v33 = 1LL;
  v34 = &v21;
  v35 = 0LL;
  puts("Now let's see if you can read my mind. Give me 10 numbers!");
  sub_4009D6((__int64)&v2);
  v1 = 0LL;
  some_func((__int64)&v6, (__int64)&v2, &v1);
  if ( v1 != 5 )
  {
    puts("FAIL");
    exit(1);
  }
  sub_400CAC();
  return __readfsqword(0x28u) ^ v36;
}

__int64 __fastcall sub_4009D6(__int64 a1)
{
  __int64 result; // rax

  result = (signed int)__isoc99_scanf(
                         "%ld %ld %ld %ld %ld %ld %ld %ld %ld %ld",
                         a1,
                         a1 + 8,
                         a1 + 16,
                         a1 + 24,
                         a1 + 32,
                         a1 + 40,
                         a1 + 48,
                         a1 + 56,
                         a1 + 64,
                         a1 + 72);
  if ( (unsigned __int64)(signed int)result <= 9 )
  {
    puts("FAIL");
    exit(1);
  }
  return result;
}

__int64 __fastcall some_func(__int64 a1, __int64 a2, _QWORD *a3)
{
  __int64 result; // rax
  _QWORD *v4; // [rsp+8h] [rbp-38h]
  __int64 v5; // [rsp+30h] [rbp-10h]
  __int64 v6; // [rsp+38h] [rbp-8h]

  v4 = a3;
  v5 = sub_400D4E(a1);
  result = sub_400DC3(a1);
  v6 = result;
  if ( v5 )
  {
    if ( (unsigned __int8)sub_400F22(a1, v5, *(_QWORD *)(8LL * *v4 + a2), *(_QWORD *)(8 * (*v4 + 5LL) + a2), 1) )
      ++*v4;
    result = some_func(v5, a2, v4);
  }
  if ( v6 )
  {
    if ( (unsigned __int8)sub_400F22(a1, v6, *(_QWORD *)(8LL * *v4 + a2), *(_QWORD *)(8 * (*v4 + 5LL) + a2), 0) )
      ++*v4;
    result = some_func(v6, a2, v4);
  }
  return result;
}

_BOOL8 __fastcall sub_400F22(__int64 a1, __int64 a2, __int64 a3, __int64 a4, char a5)
{
  char v6; // [rsp+4h] [rbp-74h]
  __int64 v7; // [rsp+8h] [rbp-70h]
  __int64 v8; // [rsp+10h] [rbp-68h]
  __int64 v9; // [rsp+28h] [rbp-50h]
  __int64 v10; // [rsp+30h] [rbp-48h]
  __int64 v11; // [rsp+38h] [rbp-40h]
  __int64 v12; // [rsp+40h] [rbp-38h]
  __int64 v13; // [rsp+58h] [rbp-20h]
  __int64 v14; // [rsp+60h] [rbp-18h]

  v8 = a3;
  v7 = a4;
  v6 = a5;
  v9 = sub_400E38(a1);
  v10 = sub_400E38(a2);
  if ( v6 )
  {
    if ( v9 <= v8 )
      return 0LL;
  }
  else if ( v9 >= v8 )
  {
    return 0LL;
  }
  if ( v8 == v10 )
    return 0LL;
  v11 = sub_400D4E(a2);
  v12 = sub_400DC3(a2);
  if ( v11 && sub_400E38(v11) >= v8 )
    return 0LL;
  if ( v12 && sub_400E38(v12) <= v8 )
    return 0LL;
  v13 = sub_400EAD(a1);
  v14 = sub_400EAD(a2);
  if ( v6 )
  {
    if ( v13 <= v7 )
      return 0LL;
  }
  else if ( v13 >= v7 )
  {
    return 0LL;
  }
  if ( v7 == v14 )
    return 0LL;
  if ( v11 && sub_400EAD(v11) >= v7 )
    return 0LL;
  return !v12 || sub_400EAD(v12) > v7;
}
```

Very long code, to summarize, it

1. Prints out an address on the stack
2. Does a ton of initialization on the variables
3. Calls scanf to read in 10 signed integers
4. Calls `some_func` (it was a stripped binary, I named it this) with some paremeters, that seemed to be stack addresses casted to integer.
5. If the result is equal to 5, print flag

In `some_func` and `sub_400F22`, we see 3 more different functions.

```
__int64 __fastcall sub_400D4E(__int64 a1)
{
  __int64 result; // rax

  if ( !a1 )
    return 0LL;
  switch ( *(_DWORD *)a1 )
  {
    case 1:
      result = *(_QWORD *)(a1 + 24);
      break;
    case 2:
      result = *(_QWORD *)(a1 + 16);
      break;
    case 3:
      result = *(_QWORD *)(a1 + 8);
      break;
    case 4:
      result = *(_QWORD *)(a1 + 32);
      break;
    case 5:
      result = *(_QWORD *)(a1 + 16);
      break;
    case 6:
      result = *(_QWORD *)(a1 + 24);
      break;
    default:
      result = 0LL;
      break;
  }
  return result;
}
```

The other 2 were pretty much the same, just that the offset values were different.

### Reversing them
Lots of functions, lots of adding and subtracting, lots of casting from integer to pointer, and seems like there's even recursion. It's gonna be a pain to reverse them.

So nah man I didn't want to reverse this. I just used angr to do the work. Yes, I really didn't bother reversing it at all.

## Solution
I wrote a [script](./solve.py) with angr to make things easier. (The following is more of my thought process, if not interested, looking at the script should be enough)

First things first, create a project in angr, and initialize a state that starts at `sub_401209`, which is the function called after we enter "8" into the program (because everything before that is useless). 

```
binary_name = sys.argv[1]
project = angr.Project(binary_name)
initial_state = project.factory.blank_state(addr=0x401209)
```

Also, I have to "define" `scanf` myself because angr does not work well with format string related stuff. Inside my own `scanf`, I created 10 symbolic values to represent our input, and store them in memory.

That being said, I also have to "skip" the instruction at 0x40126f which calls `printf`. 
(If you reversed the binary, you may feel that something's wrong, because the output of `printf` is important. Yes, I made a mistake, which I'll mention later.)

```
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
```

Then, I created a `simulation_manager` to explore the binary, with the target address at 0x401441, which is the first instruction after we passed the check, and to avoid 0x40145d, which is the first instruction after we failed the check.

```
simgr = project.factory.simgr(initial_state)

simgr.explore(find=0x401441, avoid=0x40145d)
```

If the simulation managed to reach the target address, print out the values in our input.

```
if simgr.found:
	print 'found'
	solution_state = simgr.found[0]

	# Grab whatever you set aside in the globals dict.
	stored_solutions = solution_state.globals['solutions']

	for i in range(len(stored_solutions)):
	    sol = solution_state.se.eval(stored_solutions[i])
	    # 2's complement
	    sol = -(0x10000000000000000 - sol) if sol >= 0x8000000000000000 else sol
	    sys.stdout.write(str(sol))
	    sys.stdout.write(' ')

	print ''
else:
	raise Exception('Could not find the solution')
```

Notice that since the program called `scanf` to read in `signed` integers, and claripy (angr's solver engine) gives us the unsigned value, I needed to find the 2's complement myself.

Anyways, running the script, and waiting for around 4 minutes gave me 10 numbers. But the program tells me **FAIL**...

But I felt confident that using angr should work, I must be missing something then. And, I realized the `printf` is used to print an address in the stack, and it says "this address may be interesting". So I asked my teammate why is this useful, then big realization oh right there were some parts where pointers were casted into integers.

### Some re-addressing
Fixing this was pretty easy, just initialize the stack frame of our state. And choose our state to start at the first instruction after `printf` was called, since everything before that was just lame stuff like function prologue, saving stack canary, calling `ptrace` so that we couldn't run gdb, etc.

```
leak = sys.argv[2]
initial_state = project.factory.blank_state(addr=0x401274)
initial_state.regs.rsp = leak - 0x60
initial_state.regs.rbp = leak + 0x100
```

Instead of just running the script, this time we need to get the address from the service first, after that waiting for another painful 4 minutes, we get the flag.

CrossCTF{@n_Un1iK3Ly_Un10n}