import os
ip=input("Enter the ip address : ")
message = os.popen("tracert "+ip).read()
print(message)