import socket
s = socket.socket()
s.bind(('',1234))
s.listen()
data = input("Enter the message to send : ")
while True :
    c, a = s.accept()
    print("Connected to ",a)
    for i in data:
        c.send(i.encode())
        ack=c.recv(2).decode()
        if ack=='1':
            print("Acknowledgement Received for ",i)
        else:
            c.send(i.encode())
    c.send("#".encode())
    c.close()
s.close()
