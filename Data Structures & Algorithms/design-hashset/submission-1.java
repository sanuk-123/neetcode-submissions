class MyHashSet {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    private static int sizee=10000;
    Node[] buckets;
    public MyHashSet() {
        buckets=new Node[sizee];
    }
    private int hash(int key){
        return key%sizee;
    }
    
    public void add(int key) {
        int index=hash(key);
        if(buckets[index]==null){
            buckets[index]=new Node(key);
            return;
        }
        Node curr=buckets[index];
        while(true){
            if(curr.val==key) return;
            if(curr.next==null) break;
            curr=curr.next;
        }
        curr.next=new Node(key);
    }
    
    public void remove(int key) {
        int index=hash(key);
        if(buckets[index]==null) return;
        Node curr=buckets[index];
        Node prev=null;
        while(curr!=null){
            if(curr.val==key){
                if(prev==null){
                    buckets[index]=curr.next;
                }else{
                    prev.next=curr.next;
                }
                return;
            }
            prev=curr;
            curr=curr.next;
        }
    }
    
    public boolean contains(int key) {
        int index=hash(key);
        Node curr=buckets[index];
        while(curr!=null){
            if(curr.val==key){
                return true;
            }
            curr=curr.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */