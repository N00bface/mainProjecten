import databaseRelated


def start():
    print ("this is the start application for the script bundle")
    print ("choose a number to start using any script")
    print ("1 = getDB       [show the contents of a specific database]")
    print ("2 = quit")
    return


start()
process = raw_input("type number")
try:
    process = int(process)
except ValueError:
    print ("quit")
    quit()

print process
if process == 1:
    print "a"
    databaseRelated.run(process)
elif process == 2:
    quit()
else:
    print "else"
