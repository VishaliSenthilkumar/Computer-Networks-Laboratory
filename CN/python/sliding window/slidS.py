import socket
import time
s = socket.socket()
s.bind(('',1234))
s.listen()
while True:
    c, a = s.accept()
    n=input("Enter the no. of frames to be sent : ")
    c.send(n.encode())
    msg=[]
    print(f"Enter the {n} messages to send")
    for i in range(int(n)):
        msg.append(input())
    k=0
    while k<int(n):
        time.sleep(1)
        c.send(msg[k].encode())
        k += 1
        if k==int(n):
            c.send("#".encode())
            ack=c.recv(2).decode()
            if(ack=="1"):
                print("Acknowledgement Received")
                break
            else:
                k=0
    c.close()
s.close()
