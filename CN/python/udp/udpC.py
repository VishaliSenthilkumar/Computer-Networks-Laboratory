import socket
client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
client.sendto("Hello UDP server".encode(),('127.0.0.1',1234))
mess, addr = client.recvfrom(1024)
print(mess.decode())