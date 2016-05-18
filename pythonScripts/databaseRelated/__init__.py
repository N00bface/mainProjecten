import getDB


def run(process):
    print "process: "+str(process)
    if process == 1:
        return getDB.start()
    return 0
