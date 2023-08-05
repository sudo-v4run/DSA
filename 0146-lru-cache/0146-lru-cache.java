class LRUCache {
    
    class Node{
        int key, val;
        Node next, prev;
        
        Node(int key, int val){
            
            this.key = key;
            this.val = val;
        }
    }
    
    HashMap<Integer,Node> hm;
    int cap;
    
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        
        hm = new HashMap<>();
        cap = capacity;
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if(hm.containsKey(key)){
            Node resultNode = hm.get(key);
            
            removeNode(resultNode);
            addNode(resultNode);
            
            return resultNode.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node = new Node(key,value);
        
        if(!hm.containsKey(node.key)){
            if(hm.size() >= cap){
                removeNode(tail.prev);
            }
            addNode(node);
        }else{
            removeNode(hm.get(key));
            addNode(node);
        }
    }
    
    public void addNode(Node node){
        
        hm.put(node.key,node);
        
        Node temp = head.next;
        
        temp.prev = node;node.next = temp;
        head.next = node;
        node.prev = head;
    }
    
    public void removeNode(Node node){
        
        hm.remove(node.key);
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}