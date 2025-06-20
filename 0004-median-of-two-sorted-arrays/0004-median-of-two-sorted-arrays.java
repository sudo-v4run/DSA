class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {

        int n1 = arr1.length;
        int n2 = arr2.length;

        if(n1 == 0 && n2 == 0){
            return 0.0;
        }

        if(n2 < n1){
            return findMedianSortedArrays(arr2, arr1);
        }

        if(n1 == 0){
            if(n2%2 == 0){
                return (arr2[(n2/2)-1]+arr2[n2/2])/2.0;
            }
            return arr2[n2/2];
        }

        int l1 = 0;
        int h1 = n1-1;

        while(true){
            int m1 = (l1+h1)/2;
            if(h1 < 0){
                m1 = -1;
            }
            int m2 = (((n1+n2+1)/2)-(m1+1))-1;
            if(h1 < 0){
                m2 = ((n1+n2+1)/2)-1;
            }

            //System.out.println(m2);

            int m1Ele = Integer.MIN_VALUE;
            if(m1 >= 0){
                m1Ele = arr1[m1];
            }
            int m2Ele = Integer.MIN_VALUE;
            if(m2 >= 0){
                m2Ele = arr2[m2];
            }

            int m1next = Integer.MAX_VALUE;
            if(m1+1 < n1){
                m1next = arr1[m1+1];
            }

            int m2next = Integer.MAX_VALUE;
            if(m2+1 < n2){
                m2next = arr2[m2+1];
            }

            if(m1Ele <= m2next && m2Ele <= m1next){
                if((n1+n2)%2 == 0){
                    return (Math.max(m1Ele,m2Ele)+Math.min(m1next,m2next))/2.0;

                }else{
                    return Math.max(m1Ele,m2Ele);
                }
            }else if(m1Ele > m2next){
                h1 = m1-1;
            }else if(m2Ele > m1next){
                l1 = m1+1;
            }
        }

        
    }
}