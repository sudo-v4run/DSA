/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    sc.nextLine();
	    
	    while(t--!=0){
	        HashMap<Character,Integer> hm = new HashMap<>();
	        String S = sc.nextLine();
	        String s = S.toLowerCase();
	        for(int i = 0 ; i < s.length();i++){
	            char ch = s.charAt(i);
	            hm.put(ch,hm.getOrDefault(ch,0)+1);
	            
	            if(((hm.get(ch))&1)!=0){  //masking with 1 to check the occurence of the character is even or odd. Modding with 2 can also be done.
	                System.out.print(S.charAt(i));
	            }
	            
	        }
	        System.out.println();
	    }
	}
}