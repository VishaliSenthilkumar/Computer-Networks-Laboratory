v = int(input("Enter the no. of vertices : "))
mat = []
pre = [0 for i in range(v)]
visited = [0 for i in range(v)]
d = [0 for i in range(v)]
min=999
n=0
for i in range(v):
    l=list(map(int,input().split()))
    for j in range(v):
        if l[j]==0:
            l[j]=999
    mat.append(l)
d=mat[0]
visited[0]=1
d[0]=0

for c in range(v):
    min=999
    for i in range(v):
        if min>d[i] and visited[i]!=1:
            min=d[i]
            n=i
    visited[n]=1
    for i in range(v):
        if(visited[i]!=1):
            if(min+mat[n][i]<d[i]):
                d[i]=min+mat[n][i]
                pre[i]=n
for i in range(v):
    if i!=0:
        print("Path =",i,end=" ")
        j=i
        while(j!=0):
            j=pre[j]
            print(" <- ",j,end=" ")
        print("\nCost = ",d[i])



