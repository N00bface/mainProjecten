import mysql.connector


def start():
    cnx = mysql.connector.connect(user="jarivanm", password="Tanzania1", host="db4free.net", database="jarivanm_progdb")
    cmd = cnx.cmd_query("SELECT * FROM projectMngr_companies")
