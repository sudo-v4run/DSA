//{ Driver Code Starts
import java.util.Arrays;
import java.util.Scanner;
class FindFourElements
{
	
    public static void main(String[] args) 
    {
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while(t-->0){
			FindFourElements findfour = new FindFourElements();
			int n=sc.nextInt();
			int[] A=new int[n];
			for(int i=0;i<n;i++)
				A[i]=sc.nextInt();
			int X =sc.nextInt();
			
			Compute ob = new Compute();
		    System.out.println(ob.find4Numbers(A, n, X)?1:0);
		}
    }
}


// } Driver Code Ends


class Compute
{
    boolean find4Numbers(int arr[], int N, int target) 
    {
        if(arr==null||arr.length==0)
                return false;
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1; j < n ; j++){
                int tr = target - arr[j]-arr[i];
                int left = j+1;
                int right = n-1;
                while(left<right){
                    int sum = arr[left]+arr[right];
                    if(sum<tr){
                        left++;
                    }else if(sum>tr){
                        right--;
                    }else if(sum==tr){
                        return true;
                    }
                    
                }
                //while(j+1<n && arr[j+1]==arr[j]) ++j;
            }
            //while(i+1<n && arr[i+1]==arr[i]) ++i;
        }
        return false;
    }
}