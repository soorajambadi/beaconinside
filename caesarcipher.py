
# Used python 2.7
# Ceasar cipher

import sys

if len(sys.argv) != 3:
	print('input parameter count mismatch')
	sys.exit(1)

if sys.argv[1] != 'encrypt' and sys.argv[1] != 'decrypt':
	print('first arguiment should be either \'encrypt\' or \'decrypt\'')
        sys.exit(2)

domain = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
if (set(list(sys.argv[2])) - set(domain)):
	print('Please provide a valid input string')
	sys.exit(3)


def encrypt(c):
	return ''.join(map(lambda x: chr(((ord(x)-ord('A')-3)%26)+ord('A')), c))

def decrypt(c):
	return ''.join(map(lambda x: chr(((ord(x)-ord('A')+3)%26)+ord('A')), c))

if sys.argv[1] == 'encrypt':
	encrypted = encrypt(sys.argv[2])
	print(encrypted)
else:
	decrypted = decrypt(sys.argv[2])
	print(decrypted)
