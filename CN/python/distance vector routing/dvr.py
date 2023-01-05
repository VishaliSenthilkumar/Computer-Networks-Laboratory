v=int(input("VERTICES : "))
e=int(input("EDGES : "))
g = [[0 for i in range(v)] for j in range(v)]
via = [[0 for i in range(v)] for j in range(v)]
rt = [[0 for i in range(v)] for j in range(v)]

def init_table():
    for i in range(v):
        for j in range(v):
            if i != j:
                rt[i][j] = 999
                via[i][j] = 100
            else:
                rt[i][j] = 0
                via[i][j] = i

def print_table():
    for i in range(v):
        for j in range(v):
            print(rt[i][j],end=" ")
        print()

def update_table(s):
    for i in range(v):
        if g[s][i]!=999 :
            dis = g[s][i]
            for j in range(v):
                in_dis = rt[i][j]
                if via[i][j]==s:
                    in_dis=999
                if dis+in_dis<rt[s][j]:
                    rt[s][j]=dis+in_dis
                    via[s][j]=i

def update_tables():
    k=0
    for i in range(v*v):
        update_table(k)
        if k==v-1:
            k=0
        k+=1

def cal_dvr(s):
    init_table()
    update_tables()
    print(s)
    print_table()
    print()

if __name__ == "__main__":
    for i in range(v):
        for j in range(v):
            if i==j:
                g[i][j]=0
            else:
                g[i][j]=999
    for i in range(e):
        print("Edge ",(i+1))
        s=int(input("Source : "))-1
        d = int(input("Destination : ")) - 1
        c = int(input("Cost : "))
        g[s][d]=c
        g[d][s]=c

    cal_dvr("The routing table is : ")

    print("Enter the changed edge details : ")
    s = int(input("Source : ")) - 1
    d = int(input("Destination : ")) - 1
    c = int(input("Cost : "))
    g[s][d] = c
    g[d][s] = c

    cal_dvr("The routing table after update is : ")