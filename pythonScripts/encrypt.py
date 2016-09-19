# coding=utf-8
import sys

alphabet_alg = ['a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k',
                'K', 'l', 'L', 'm', 'M',
                'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R',
                's', 'S', 't', 'T', 'u', 'U',
                'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z', '@', '|', '.', '-', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', '0', '\\',
                '/', '_', ' ']


def makedict():
    alphabets = [alphabet_alg]
    for item in alphabet_alg:
        alphabets.append(make_alphabet(item, list(alphabet_alg)))
    return alphabets


def make_alphabet(item, alphabet):
    ret = []
    element = item
    ind = alphabet_alg.index(item[0])
    while len(alphabet) >= 1:
        try:
            element = alphabet.pop(ind)
        except IndexError:
            ind = 0
        ret.append(element)
    return ret


def encrypt(key_char, letter, dictionary):
    return (dictionary[alphabet_alg.index(key_char)])[alphabet_alg.index(letter)]


whole_text = str(sys.argv[1])
key = sys.argv[2]
alphabet_array = makedict()
index = 0
out = ""
for char in list(whole_text):
    if index >= len(key):
        index = 0
    out += encrypt(list(key)[index], char, alphabet_array)
    index += 1

print (out)
