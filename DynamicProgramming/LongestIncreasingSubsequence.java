//https://www.geeksforgeeks.org/longest-increasing-subsequence/
import java.util.*;
class LongestIncreasingSubsequence
{
	public static void main(String args[])
	{
		int arr[]={3,4,-1,0,6,2,3};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println("Longest LIS is: "+ lis.findList(arr));
	}

	private int findList(int arr[])
	{
		
		int l[] = new int[arr.length];
		//base-condition
		for(int i=0;i<l.length;i++)
		{
			l[i]=1;
		}

		for(int i=1;i<l.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j]<arr[i])
				{
					l[i]=Math.max(l[j]+1,l[i]);
				}

				// if(j+1==i && i+1 < l.length)
				// 	i+=1;
			}
		}

		System.out.println("Longest Increasing Subsequence Array: "+ Arrays.toString(l));

		int max=Integer.MIN_VALUE;
		for(int i=0;i<l.length;i++)
		{	
			if(l[i]>max)
				max=l[i];
		}
		return max;

	}
}