import os
ip=input("Enter the ip to ping : ")
ping = os.popen("ping "+ip).read()
print(ping)