#!/usr/bin/python3
import os
import random
import base64

def encrypt(data, key, func):
    length = len(key)
    output = []
    for i in range(len(data)):
        output.append(func(data[i],key[i%length]))
    return bytes(output)

if __name__ == "__main__":
    file_path = '/home/lossyoracleuser/flag'    
    with open(file_path, 'rb') as file:
        data = file.read()

    key = []
    for i in range(random.randrange(64,128)):
        key.append(random.randrange(0,255))
    key = bytes(key)

    function = [lambda x,y:x&y, lambda x,y:x|y]

    print (base64.b64encode(encrypt(data, key, function[1])).decode("utf-8"))
