import java.util.Arrays;

public class Main {
    private int p = 0;
    private int findPaths(int m, int n, int N) {
        int[][][] memo=new int[m][n][N+1];
        for(int[][] l:memo)
            for(int[] sl:l)
                Arrays.fill(sl,-1);
        int i = 0;
        int j = 0;
        return findPaths(m,n,N,i,j,memo);
    }
    private int findPaths(int m, int n, int N, int i, int j, int[][][] memo) {
        if(i==m && j==n) {
            p++;
            System.out.println("Number of correct paths:" + p);
            return 1;
        }
        if(N==0 || i<0 || j<0)
            return 0;
        if(memo[i][j][N]>=0)
            return memo[i][j][N];
        int m1 = 1000000007;
        memo[i][j][N]=((findPaths(m,n,N-1,i-1,j,memo)+findPaths(m,n,N-1,i+1,j,memo))% m1 +(findPaths(m,n,N-1,i,j-1,memo)+findPaths(m,n,N-1,i,j+1,memo))% m1)% m1;
        return memo[i][j][N];
    }
    public static void main(String []args) {
        Main mySolution = new Main();
        mySolution.findPaths(4,4,5);
    }
}
