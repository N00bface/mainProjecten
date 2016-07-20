import sys

alphabet_alg = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z', '@', '|', '.', '-', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '\\',
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


def decrypt(key_char, letter):
    index_decrypt_dict = alphabet_alg.index(key_char)
    word_index = alphabet_array[index_decrypt_dict]
    return alphabet_alg[word_index.index(letter)]


whole_text = sys.argv[1]
keyword = sys.argv[2]
alphabet_array = makedict()
out = ""
i = 0
element = list(keyword)
for char in list(whole_text):
    out += decrypt(element[i], char)
    i += 1
    if i >= len(element):
        i = 0

print out
