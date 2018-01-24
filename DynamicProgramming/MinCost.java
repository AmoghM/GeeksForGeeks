//https://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
import java.util.*;
class MinCost
{
	public static void main(String args[])
	{
		int m[][]={{1,3,5,8},{4,2,1,7},{4,3,2,3}};
		MinCost mc = new MinCost();
		System.out.println("Mininum cost is: " + mc.findLeastCost(m));		
	}

	private int findLeastCost(int arr[][])
	{
		int dp[][]=new int[arr.length][arr[0].length];
		dp[0][0] = arr[0][0];
		for(int i=1;i<arr.length;i++)
			dp[i][0]=arr[i][0]+dp[i-1][0];

		for(int i=1;i<arr[0].length;i++)
			dp[0][i]=arr[0][i]+dp[0][i-1];

		for(int i=1;i<arr.length;i++)
		{
			for(int j=1;j<arr[0].length;j++)
			{	
				dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+arr[i][j];
			}
		}
		return dp[arr.length-1][arr[0].length-1];
	}

	private int min(int x, int y, int z)
	{
		int xyz = Math.min(x,y);
		xyz = Math.min(xyz,z);
		System.out.println(xyz);
		return xyz;
	}

	private int printResult(int cost[][])
	{
		System.out.println("MinCost array");
		for(int i=0;i<cost.length;i++)
		{
			for(int j=0;j<cost[0].length;j++)
			{
				System.out.print(cost[i][j]+" ");
			}
			System.out.println();
		}
	return 1;
	}
}