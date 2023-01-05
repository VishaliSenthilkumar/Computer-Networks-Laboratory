import socket
c = socket.socket()
c.connect(("localhost",1234))
while True:
    msg = c.recv(1024).decode("utf-8")
    if (msg == "#"):
        break
    elif(msg!=''):
        c.send('1'.encode())
        print(msg, " has been received")
        print("Acknowlegment for ", msg, " has been sent")
    else:
        c.send('0'.encode())
c.close()
