class LFUCache {
    
    class Node{
        int freq,key,val;
        Node prev,next;
        Node(int key, int val){
            this.freq = 1;
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }

    class DList{
        Node head,tail;
        int sz;
        DList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            sz = 0;
        }
        void addNode(Node node){
            
            Node temp = head.next;
            temp.prev = node;
            node.next = temp;
            head.next = node;
            node.prev = head;
            sz++;
        }
        void removeNode(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            sz--;
        }
    }

    HashMap<Integer,DList> freqMap;
    HashMap<Integer,Node> keyNodeMap;
    int capacity;
    int curCap; 
    int minFreq;
    
    public LFUCache(int capacity) {
    
        freqMap = new HashMap<>();
        keyNodeMap = new HashMap<>();
        this.capacity = capacity;
        minFreq = 0;
        curCap = 0;
    }
    
    public int get(int key) {
        
        if(!keyNodeMap.containsKey(key)){
            return -1;
        }
        Node node = keyNodeMap.get(key);
        updateFreqMap(node);
        // keyNodeMap.put(key,node); // this is node required coz we are 
                                     // updating the node itself in updateFreqMap()
        return node.val;
    }
    
    public void put(int key, int value) {
        
        if(!keyNodeMap.containsKey(key)){
            if(curCap == capacity){
                DList l = freqMap.get(minFreq);
                keyNodeMap.remove(l.tail.prev.key);
                l.removeNode(l.tail.prev);
                curCap--;
            }
            minFreq = 1;
            Node node = new Node(key,value);
            keyNodeMap.put(key,node);
            curCap++;
            if(!freqMap.containsKey(1)){
                freqMap.put(1,new DList());
            }
            freqMap.get(1).addNode(node);
            
        }else{
            Node node = keyNodeMap.get(key);
            node.val = value;
            updateFreqMap(node);
            // keyNodeMap.put(key,node); // this is node required coz we are 
                                     // updating the node itself in updateFreqMap()
        }
    }
    public void updateFreqMap(Node node){
        
        freqMap.get(node.freq).removeNode(node);
        
        if(node.freq == minFreq && freqMap.get(minFreq).sz == 0){
            minFreq++;
        }
        
        if(!freqMap.containsKey(node.freq+1)){
            freqMap.put(node.freq+1,new DList());
        }
        
        node.freq++;
        freqMap.get(node.freq).addNode(node);
    }
}
