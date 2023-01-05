import socket
import webbrowser
s=socket.socket()
s.bind(('',1234))
s.listen()
c, a = s.accept()

with open("download.html", "wb") as f:
    while True:
        b_r = c.recv(1024)
        if not b_r:
            break
        f.write(b_r)
        print("Received :"+b_r.decode())

webbrowser.open("download.html")
s.close()
c.close()