public class NStack {
    int free;
    int arr[];
    int next[];
    int top[];
    public NStack(int N, int S) {
        arr = new int[S];
        next = new int[S];
        top = new int[N];
        for(int i = 0; i < S-1; i++){
            next[i] = i+1;
        }
        next[S-1] = -1;
        for(int i = 0 ; i < top.length ; i++){
            top[i] = -1;
        }
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        if(free==-1){
            return false;
        }
        int i = free;
        free = next[i];
        next[i] = top[m-1];
        top[m-1] = i;
        arr[i] = x;
        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        if(top[m-1]==-1){
            return -1;
        }
        int i = top[m-1];
        top[m-1] = next[i];
        next[i] = free;
        free = i;
        return arr[i];
    }
}