//https://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
class CoinChange
{
    public static void main(String args[]){
        int coin[] = {0,2,3,5,6};
        int N = 10;
        CoinChange cc = new CoinChange();
        int dp[][] = cc.totalCents(coin,N);
        cc.printResult(dp);
        System.out.println(" Max ways to change are: "+ dp[dp.length-1][dp[0].length-1]);
    }
    private void printResult(int change[][])
    {
        System.out.println("Coin Change array is: ");
        for(int i=0;i<change.length;i++)
        {
            for(int j=0;j<change[0].length;j++)
            {
                System.out.print(change[i][j]+" ");
            }
            System.out.println();
        }
    }

    private int[][] totalCents(int coins[], int N)
    {   int rows = coins.length;
        int cols = N+1;
        int dp[][] = new int[rows][cols];

        for (int i=0; i<rows; i+=1){
            dp[i][0] = 1;
        }
        for (int i=0; i<cols; i+=1){
            dp[0][i]=0;
        }
        for (int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if (j < coins[i]){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i][j-coins[i]] + dp[i-1][j];
                }
            }
        }

        return dp;
    }
}