class Solution {
    public int[] maxNumber(int[] arr1, int[] arr2, int k) {
        
        int n1 = arr1.length;
        int n2 = arr2.length;

        int ans[] = new int[k];

        for(int x = 0; x <= k && x <= n1; x++){

            if(k-x > n2){
                continue;
            }

            Stack<Integer> st1 = new Stack<>();
            Stack<Integer> st2 = new Stack<>();

            getMaxFromArr(x, st1, arr1);
            getMaxFromArr(k-x, st2, arr2);

            int t1[] = new int[st1.size()];
            int i = st1.size()-1;
            while(!st1.isEmpty()){
                t1[i--] = st1.pop();
            }

            int t2[] = new int[st2.size()];
            i = st2.size()-1;
            while(!st2.isEmpty()){
                t2[i--] = st2.pop();
            }

            int t[] = merge(t1,t2);

            ans = max(ans,t);
        }

        return ans;
    }
    public static void getMaxFromArr(int k, Stack<Integer> st, int arr[]){

        int n = arr.length;
        
        for(int i = 0; i < n; i++){
            int ele = arr[i];
            while(!st.isEmpty() && st.peek() < ele && st.size()-1+n-i >= k){
                st.pop();
            }
            st.push(ele);
        }
        while(st.size() > k){
            st.pop();
        }
    }
    public int[] merge(int t1[], int t2[]){

        int n1 = t1.length;
        int n2 = t2.length;

        int res[] = new int[n1+n2];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n1 && j < n2){
            if(t1[i] > t2[j]){
                res[k++] = t1[i++];
            }else if(t1[i] < t2[j]){
                res[k++] = t2[j++];
            }else if(t1[i] == t2[j]){

                int tempI = i;
                int tempJ = j;
                while(tempI < n1 && tempJ < n2 && t1[tempI] == t2[tempJ]){
                    tempI++;
                    tempJ++;
                }
                if(tempI == n1){
                    res[k++] = t2[j];
                    j++;
                }else if(tempJ == n2){
                    res[k++] = t1[i];
                    i++;
                }else if(t1[tempI] > t2[tempJ]){
                    res[k++] = t1[i];
                    i++;
                }else{
                    res[k++] = t2[j];
                    j++;
                }
            }
        }

        while(i < n1){
            res[k++] = t1[i++];
        }

        while(j < n2){
            res[k++] = t2[j++];
        }

        return res;
    }
    public static int[] max(int arr1[], int arr2[]){

        int n = arr1.length;
        int[] res = arr1.clone();

        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                res = (arr1[i] > arr2[i]) ? arr1 : arr2;
                break;
            }
        }

        return res;
    }
}