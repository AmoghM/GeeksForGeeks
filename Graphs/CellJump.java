//https://www.geeksforgeeks.org/minimum-cells-traversed-reach-corner-every-cell-represents-jumps/
import java.util.*;
import javafx.util.Pair;
class CellJumps
{
	int rows,col;
	CellJumps(int rows, int col)
	{
		rows=this.rows;
		col=this.col;
	}

	public static void main(String args[])
	{	
		int grid[][] = {{2,4,2},{5,3,8},{1,1,1}};
		CellJumps cj = new CellJumps(3,3);
		int start_row = 0;
		int start_col = 0;

		System.out.println(cj.getJumps(grid,start_row,start_col));
	}

	private int getJumps(int grid[][], int r, int c)
	{
		Queue<
	}
}