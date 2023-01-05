import socket
c = socket.socket()
c.connect(("localhost",1234))
n=c.recv(8).decode("utf-8")
count = 0
while True:
    msg = c.recv(32).decode()
    if(msg=="#"):
        if count==int(n):
            c.send("1".encode())
            print("Acknowledgement has been sent")
            break
        else:
            c.send("0".encode())
            count = 0
    if msg!="":
        print("Received frame ",count+1," is ",msg)
        count+=1
c.close()


