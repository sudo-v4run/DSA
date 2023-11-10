/*  min no days to eat n chocolates. You start with 1 on the first day, then on the next days, you can eat 1 chocolate more, or same, or 1 chocolate less. You should be eating 1 chocolate on the last day. Return min of days to eat n chocolates  */

// DP...

import java.util.*;
public class Main
{
    static int choco;
	public static void main(String[] args) {
	    
	    int n = 100;
	    choco = n;
	    
	    if(n == 0){
	        // 0
	        return;
	    }
	    
	    int dp[][] = new int[n+1][n+1];
	    
	    for(int row[] : dp){
	        Arrays.fill(row,-1);
	    }
	    
	    int res = f(n,0,dp);
	    
	    System.out.print(res);
	}
	public static int f(int n, int prev, int dp[][]){
	    
	    if(n == 0){
	        if(prev != 1){
	            return choco+1;
	        }
	        return 0;
	    }
	    
	    if(n < 0){
	        return choco+1;
	    }
	    
	    if(dp[n][prev] != -1){
	        return dp[n][prev];
	    }
	    
	    int a = choco+1;
	    if(prev+1 > 0){
	        a = 1 + f(n-(prev+1),prev+1,dp);
	    }
	    
	    int b = choco+1;
	    if(prev > 0)
	     b = 1 + f(n-(prev),prev,dp);
	    
	    int c = choco+1;
	    if(prev-1 > 0){
	        c = 1 + f(n-(prev-1),prev-1,dp);
	    }
	    
	    
	    return dp[n][prev] = Math.min(a,Math.min(b,c));
	}
}

// Recursion...

// public class Main
// {
//     static int choco;
// 	public static void main(String[] args) {
	    
// 	    int n = 11;
// 	    choco = n;
	    
// 	    if(n == 0){
// 	        // 0
// 	        return;
// 	    }
	    
// 	    int res = f(n,0);
	    
// 	    System.out.print(res);
// 	}
// 	public static int f(int n, int prev){
	    
// 	    if(n == 0){
// 	        if(prev != 1){
// 	            return choco+1;
// 	        }
// 	        return 0;
// 	    }
	    
// 	    if(n < 0){
// 	        return choco+1;
// 	    }
	    
// 	    int a = choco+1;
// 	    if(prev+1 > 0){
// 	        a = 1 + f(n-(prev+1),prev+1);
// 	    }
	    
// 	    int b = choco+1;
// 	    if(prev > 0)
// 	     b = 1 + f(n-(prev),prev);
	    
// 	    int c = choco+1;
// 	    if(prev-1 > 0){
// 	        c = 1 + f(n-(prev-1),prev-1);
// 	    }
	    
	    
// 	    return Math.min(a,Math.min(b,c));
// 	}
// }
