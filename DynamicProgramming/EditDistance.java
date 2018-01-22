import java.util.*;
class EditDistance
{
	public static void main(String args[])
	{
		String s1="abcdef";
		String s2="azced";
		EditDistance ed = new EditDistance();
		int edit_res[][] = ed.findDistance(s1.toCharArray(),s2.toCharArray());
		ed.printResult(edit_res);
	}

	private int[][] findDistance(char s1[], char s2[])
	{
		int edit[][] = new int[s1.length+1][s2.length+1];
		for(int i=0;i<=s1.length;i++)
			edit[i][0]=i;

		for(int i=0;i<=s2.length;i++)
			edit[0][i]=i;

		for(int i=1;i<=s1.length;i++)
		{
			for(int j=1;j<=s2.length;j++)
			{
				if(s1[i-1]==s2[j-1])
				{
					edit[i][j]=edit[i-1][j-1];
				}
				else
				{
					int min = Math.min(edit[i-1][j],edit[i][j-1]);
					min = Math.min(min, edit[i-1][j-1]);
					edit[i][j]=min+1;
				}
			}
		}
	System.out.println("Cost of edit distance required is: " + edit[s1.length][s2.length]);
	return edit;
	}

	private void printResult(int edit[][])
	{
		System.out.println("Edit distance array: ");
		for(int i=0;i<edit.length;i++)
		{
			for(int j=0;j<edit[0].length;j++)
			{
				System.out.print(edit[i][j]+" ");
			}
			System.out.println();
		}
	}
}