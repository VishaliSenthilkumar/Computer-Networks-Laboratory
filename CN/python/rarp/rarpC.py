import socket
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(("localhost",1234))
mac = input("Enter the mac to know to ip :")
client.send(mac.encode())
ip = client.recv(1024)
ip = ip.decode("utf-8")
print("The corresponding mac address is ",ip)

client.close()