//{ Driver Code Starts
//Initial Template for Java

import java.util.*;



// } Driver Code Ends
//User function Template for Java
class Solution {
    public int numTrees(int N) {
        if (N <= 1) {
            return 1;
        }
        
        int MOD = 1000000007;
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = (dp[i] + (int)((long)dp[j - 1] * dp[i - j] % MOD)) % MOD;
            }
        }
        
        return dp[N];
    }
}

//{ Driver Code Starts.

class Tree3
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking n
            int n =sc.nextInt();
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling method numTrees() of 
            //class Solution
            System.out.println(ob.numTrees(n));
            
        }
        sc.close();
    }

}

// } Driver Code Ends
