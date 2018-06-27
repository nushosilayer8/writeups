import frida, sys, os, subprocess, time

i = 0
q = []
# q = [8, -23, 89, 121, -102, 27, -6, 26, -106, 27, 116, 39, -122, -9, -88, -75, 116, -34, 14, -36, 118, -9, -58, 63, -105, 22, -110, -40, -80, 79, -8, 22]
changed = True

def on_message(message, data):
	global i, q, changed
	if message['type'] == 'send':
	    print("[*] {0}".format(message['payload']))
	    i = message['payload'][0]
	    q = message['payload'][1]
	    changed = True
	else:
	    print(message)

while True:
	if i > 1000000:
		exit(0)

	while not changed:
		pass

	changed = False

	jscode = """
Java.perform(function() {
    var GameActivity = Java.use('com.google.ctf.shallweplayagame.GameActivity');
    o = %d

    GameActivity.onCreate.overload('android.os.Bundle').implementation = function (v) {
    	this.onCreate(v)
    	%s
    	if (o < 1000000) {
	        for (var i = o; i < o + 20000; i++) {
	        	this.n();
	        }
			send([i, this.q.value]);
		}
		else {
			this.m();
		}
    };

    GameActivity.k.implementation = function () {
    };
})
""" % (i, "this.q.value = Java.array('byte', %s)" % q if i > 0 else '')

	print('Spawning app')
	device = frida.get_usb_device()
	pid = device.spawn('com.google.ctf.shallweplayagame')
	session = device.attach(pid)
	script = session.create_script(jscode)
	script.on('message', on_message)
	print('[*] Running script')
	script.load()
	device.resume(pid)

# CTF{ThLssOfInncncIsThPrcOfAppls}