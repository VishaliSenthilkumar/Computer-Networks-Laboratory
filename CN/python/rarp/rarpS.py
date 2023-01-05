import socket
table = {
		"192.168.1.1" : "1E.4A.4A.11",
		"192.168.1.2" : "1E.4A.4A.12",
		"196.168.1.3" : "1E.4A.4A.13"
	}
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind(('',1234))
server.listen()
client, addr = server.accept()
mac=client.recv(1024).decode()
ip = "NO ENTRY FOUND FOR GIVEN ADDRESS"
for ipt, mact in table.items() :
	if mact == mac :
		ip = ipt
		break
ip=ip.encode()
client.send(ip)
server.closes()
client.close()