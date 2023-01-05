import socket
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(("localhost",1234))
message = input("Enter the message to send to client : ")
client.send(message.encode())
message = client.recv(1024).decode()
print("Message from server : ",message)
client.close()