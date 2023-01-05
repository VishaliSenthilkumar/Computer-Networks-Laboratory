import socket
server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
server.bind(('',1234))
print("UDP server up and listening")
while(True):
    mess, addr = server.recvfrom(1024)
    print("Message from client is : ",mess.decode())
    print("Address of the client is ",addr)
    server.sendto("Hello UDP client".encode(), addr)
server.close()