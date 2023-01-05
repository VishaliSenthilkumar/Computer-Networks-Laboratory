import java.util.*;
public class lsr
{
	public static void main(String args[])
	{
		Scanner sc =  new Scanner(System.in);
		System.out.print("Enter no. of nodes : ");
		int nodes = sc.nextInt();
		
		int[] preD = new int[nodes];
		int min = 999, n = 0;
		
		int[] d = new int[nodes];
		int[][] mat = new int[nodes][nodes];
		int[] visited = new int[nodes];
		
		System.out.println("Enter the cost matrix : ");
		
		for(int i=0;i<nodes;i++)
		{
			visited[i] = 0;
			preD[i] = 0; 
			
			for(int j=0;j<nodes;j++)
			{
				mat[i][j]=sc.nextInt();
				if(mat[i][j]==0)
				{
					mat[i][j]=999;
				}
			}
		} 
		
		d = mat[0];
		visited[0] = 1;
		d[0] = 0;

		for(int i=0;i<nodes;i++)
			{
				System.out.println(d[i]);
			}
			System.out.println();
		
		for(int c=0; c<nodes; c++)
		{
			min=999;
			for(int i=0; i<nodes;i++)
			{
				if(min>d[i] && visited[i]!=1)
				{
					min=d[i];
					n=i;
				}
			}
			visited[n]=1; 
			for(int i=0;i<nodes;i++)
			{
				if(visited[i]!=1)
				{
					if(min+mat[n][i]<d[i])
					{
						d[i]=min+mat[n][i];
						preD[i]=n;
					}
				}
			}
			for(int i=0;i<nodes;i++)
			{
				System.out.println(d[i]);
			}
			System.out.println();

		}
		
		int j;
		for(int i=0;i<nodes;i++)
		{
			if(i!=0)
			{
				System.out.print("Path = " + i);
				j=i;
				do 
				{
					j=preD[j];
					System.out.print(" <- " + j);
				}
				while(j!=0);
				System.out.println();
				System.out.print("Cost = " + d[i]);
			}
			System.out.println("\n");
		}
	}
}
