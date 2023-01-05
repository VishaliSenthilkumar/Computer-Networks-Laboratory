import socket
c=socket.socket()
c.connect(("localhost",1234))
with open("upload.html","rb") as f:
    while True:
        b_r = f.read(1024)
        if not b_r:
            break
        c.sendall(b_r)
c.close()
