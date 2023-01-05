import java.util.*;

class subnetting {
    public static void main(String args[])
    {
        List<Integer> hosts = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base class IP Address : ");
        String s = sc.next();
        System.out.println("Enter the Number of Subnets Required:");
        int a=sc.nextInt();
        for(int i=0;i<a;i++)
        {
            System.out.println("Enter Number of Hosts in Subnet-"+(i+1)+":");
            hosts.add(sc.nextInt());
        }
        int t = 0;
        for(int k : hosts)
        {
            t+=k;
        }
        if(t>252)
        {
            System.out.println("Total Host must be less than or equal to 252");
        }
        else
        {
            int prev = 0;
            for(int k = 0; k<hosts.size(); k++)
            {
                int minHost = (int) Math.pow(2, Math.ceil(Math.log(hosts.get(k)+2) / Math.log(2)));
                System.out.println("Range for Subnet-"+k+" is "+s+"."+prev+"-"+(prev+minHost-1));
                prev+=minHost;
            }
        }
    }
}
