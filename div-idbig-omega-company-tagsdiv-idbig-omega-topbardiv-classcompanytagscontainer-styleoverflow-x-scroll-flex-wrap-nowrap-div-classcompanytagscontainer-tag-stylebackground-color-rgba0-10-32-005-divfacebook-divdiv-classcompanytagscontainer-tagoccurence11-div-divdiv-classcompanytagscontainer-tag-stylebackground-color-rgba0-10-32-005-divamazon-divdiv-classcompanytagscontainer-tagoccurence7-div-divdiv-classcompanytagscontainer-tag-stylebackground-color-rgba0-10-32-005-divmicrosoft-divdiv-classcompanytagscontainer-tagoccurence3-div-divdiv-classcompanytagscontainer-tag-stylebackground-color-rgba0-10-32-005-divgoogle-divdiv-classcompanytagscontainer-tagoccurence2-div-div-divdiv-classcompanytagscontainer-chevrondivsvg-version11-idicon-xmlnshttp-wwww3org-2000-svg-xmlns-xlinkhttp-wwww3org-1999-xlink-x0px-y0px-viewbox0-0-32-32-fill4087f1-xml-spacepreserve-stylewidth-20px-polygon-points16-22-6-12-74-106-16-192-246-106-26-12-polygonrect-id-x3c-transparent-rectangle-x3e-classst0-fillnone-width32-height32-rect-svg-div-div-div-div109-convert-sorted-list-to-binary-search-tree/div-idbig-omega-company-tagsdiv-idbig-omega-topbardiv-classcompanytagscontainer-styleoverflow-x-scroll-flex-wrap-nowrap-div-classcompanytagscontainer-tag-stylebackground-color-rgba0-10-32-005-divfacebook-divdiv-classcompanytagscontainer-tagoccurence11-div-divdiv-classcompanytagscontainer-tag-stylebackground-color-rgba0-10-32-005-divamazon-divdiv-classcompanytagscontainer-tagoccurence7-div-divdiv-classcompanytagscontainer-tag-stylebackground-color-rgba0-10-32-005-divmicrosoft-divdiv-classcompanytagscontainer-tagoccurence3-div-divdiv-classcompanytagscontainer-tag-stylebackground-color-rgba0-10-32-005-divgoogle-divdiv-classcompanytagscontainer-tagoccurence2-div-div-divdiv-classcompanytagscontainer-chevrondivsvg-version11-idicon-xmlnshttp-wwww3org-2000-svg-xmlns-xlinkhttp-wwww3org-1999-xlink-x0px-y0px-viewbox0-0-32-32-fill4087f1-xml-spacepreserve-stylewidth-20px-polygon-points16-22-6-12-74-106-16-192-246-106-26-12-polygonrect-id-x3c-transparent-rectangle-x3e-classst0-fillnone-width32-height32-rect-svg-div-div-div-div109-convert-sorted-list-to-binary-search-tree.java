
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        ListNode node = head;
        while(node != null){
            arr.add(node.val);
            node = node.next;
        }
        int n = arr.size();
        
        return f(0,n-1,arr);
    }
    public TreeNode f(int l, int h, ArrayList<Integer> arr){
        
        if(l > h){
            return null;
        }
        
        int mid = (l+h)/2;
        TreeNode curHead = new TreeNode(arr.get(mid));
        
        curHead.left = f(l,mid-1,arr);
        curHead.right = f(mid+1,h,arr);
        
        return curHead;
    }
}