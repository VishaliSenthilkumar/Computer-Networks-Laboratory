import math

l=[]
s=input("Enter the base class ip address : ")
n=int(input("Enter the no. of usbnets required : "))
for i  in range(n):
    mess = "Enter the number of hosts in subnet - "+str(i+1)+" : "
    l.append(int(input(mess)))
total = 0
for i in l:
    total+=i

if(total>252):
    print("Total hosts must be less than or equal to 252")
else:
    prev=0
    for i in range(n):
        minHost = 2**math.ceil(math.log(l[i]+2)/math.log(2))
        print("Range for subnet - ",i+1," is ",s,".",prev,"-",(prev+minHost-1))
        prev+=minHost





