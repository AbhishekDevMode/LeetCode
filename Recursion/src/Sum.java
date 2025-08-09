import java.util.Arrays;
public class Sum {
    static int[][] dp;
    public static void main(String[] args) {
        int n = 100;
        int k = 2;
        dp=new int[1001][1001];
        for(int[] row:dp)Arrays.fill(row,-1);
        int res=ways(n,k,1);
        System.out.println(res);
    }

    private static int ways(int n,int k,int num){
        int power=(int)Math.pow(num,k);
        if(n==0)return 1;
        if(n<0 || power>n)return 0;
        if(dp[n][num] != -1)return dp[n][num];
        int include=ways(n-power,k,num+1);
        int exclude=ways(n,k,num+1);
        return dp[n][num]=include+exclude;
    }
}
