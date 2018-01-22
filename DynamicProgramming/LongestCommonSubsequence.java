import java.util.*;
class LongestCommonSubsequence
{
	public static void main(String args[])
	{
		String a1="acbcf";
		String a2="abcdaf";
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		int[][] res = lcs.findLCS(a1.toCharArray(),a2.toCharArray());
		lcs.printArray(res);
		lcs.showLCS(res,a1.toCharArray());

	}

	private int[][] findLCS(char a[], char b[])
	{
		int dp[][]=new int[a.length+1][b.length+1];
		
		for(int i=0;i<=a.length;i++)
			dp[i][0]=0;
		
		for(int i=0;i<=b.length;i++)
			dp[0][i]=0;

		for(int i=1;i<=a.length;i++)
		{
			for(int j=1;j<=b.length;j++)
			{
				if(a[i-1]==b[j-1])
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		return dp;
	}

	private void printArray(int dp[][])
	{
		for(int i=1;i<dp.length;i++)
		{
			for(int j=1;j<dp[0].length;j++)
			{
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}

	private void showLCS(int dp[][],char str[])
	{
		System.out.println("LCS is: ");
		int i = dp.length-1;
		int j = dp[0].length-1;
		while(dp[i][j]!=0)
		{
			if(dp[i-1][j]==dp[i][j-1] && dp[i][j]==dp[i-1][j]+1){
				i=i-1;
				j=j-1;
				System.out.println(str[i]); //i-1 before printing the string may sound confusing but it isn't since the array starts from 0.
				
			}
			else if(dp[i-1][j]>dp[i][j-1])
			{
				i=i-1;
			}
			else
				j=j-1;
		}
	}
}