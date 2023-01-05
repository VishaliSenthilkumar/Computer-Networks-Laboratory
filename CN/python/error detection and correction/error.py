def red(m):
    for i in range(m):
        if (2 ** i >= m + i + 1):
            return i

def pos(arr,r):
    j = 0
    k = 1
    m = len(data)
    res = ''
    for i in range(1, m + r + 1):
        if (i == 2 ** j):
            res = res + '0'
            j += 1
        else:
            res = res + data[-1 * k]
            k += 1
    return res[::-1]

def parity(arr,r):
    n=len(arr)
    for i in range(r):
        val=0
        for j in range(1,n+1):
            if (j&2**i==2**i):
                val^=int(arr[-1*j])
        arr=arr[:n-2**i]+str(val)+arr[n-2**i+1:]
    return arr

def detect(arr,r):
    n = len(arr)
    res=0
    for i in range(r):
        val = 0
        for j in range(1, n + 1):
            if (j & 2 ** i == 2 ** i):
                val ^= int(arr[-1 * j])
        res+=val*(10**i)
    return int(str(res), 2)

def correct(arr,p):
    res=""
    for i in range(len(arr)):
        if i==p:
            res+="0" if arr[i]=="1" else "1"
        else:
            res+=arr[i]
    return res

data = input("Enter the data : ")

m = len(data)
r = red(m)
arr = pos(data, r)
arr = parity(arr, r)
print("Transferred Data is " + arr)

arr = input("Enter the received data to detect the error : ")
correction = detect(arr, r)

if (correction == 0):
    print("There is no error in the received message.")
else:
    print("The position of error is ", len(arr) - correction + 1, "from the left")
    arr=correct(arr,len(arr) - correction)
    print("Corrected Data is " + arr)



