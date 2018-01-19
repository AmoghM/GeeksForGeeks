//https://www.geeksforgeeks.org/print-all-jumping-numbers-smaller-than-or-equal-to-a-given-value/
import java.util.*;
class JumpingNumbers
{
	public static void main(String args[])
	{
		int x= 10;
		JumpingNumbers jn = new JumpingNumbers();
		jn.findJumpNum(x);
	}

	private void findJumpNum(int range)
	{
		int num=1;
		Queue<Integer> list = new LinkedList<Integer>();
		while(num<=9 && num<=range)
		{
			list.add(num);
			num+=1;
		}

		while(list.size()!=0)
		{
			int n = list.remove();
			if(n<range)
			{
				System.out.println(" " + n);
				int lastDigit = n%10;
				int new_num;
				if(lastDigit==0)
				{
					list.add((n*10)+(lastDigit+1));
				}

				if(lastDigit==9)
				{
					list.add((n*10)+(lastDigit-1));
				}

				else{
					list.add((n*10)+ (lastDigit+1));
					list.add((n*10)+ (lastDigit-1));
				}
			}
			else{
					System.out.println(n);
				}
			}

		}
}