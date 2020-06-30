import java.util.HashMap;

public class LRUAll {
    private MyList linkedList = new MyList();
    private HashMap <Integer,Node> cache = new HashMap<>();
    private int capacity ;

    public LRUAll(int capacity){
        this.capacity = capacity;
    }
    public static class Node {
        public Node(int d,Node next, Node prev){
            this.data = d;
            this.next = next;
            this.prev = prev;
        }
        public int data;
        Node next;
        Node prev;
    }

    public static class MyList {
        public Node head;
        public Node tail;

        public Node addToHead(int data) {
            if(head == null) {
                head = tail = new Node(data,null,null);
                return head;
            }
            Node first = new Node(data,head,null);
            head.prev = first;
            head = first;
            return head;
        }
        
        public void remove(Node n) {
            if (n == head) {
                head = n.next;
                head.prev = null;
            } else {
                n.prev.next = n.next;
            }
            if (n == tail) {
                tail = n.prev;
                tail.next = null;
            }else {
                n.next.prev = n.prev;
            }
        }
        public void removeLast(){
            remove(tail);
        }

        public void print() {
            Node cur = head;
            while(cur != null ) {
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LRUAll cache = new LRUAll(4);
        cache.put(1);
        cache.put(2);
        cache.put(3);
        cache.put(1);
        cache.put(4);
        cache.put(5);

        cache.display();
    }

    public void display(){
        linkedList.print();
    }


    public int get(Integer val) {
        if(!cache.containsKey(val))
            return -1;

        Node n = cache.get(val);
        linkedList.remove(n);
        linkedList.addToHead(val);
            return val;
    }

    public void put(Integer val) {
        if (cache.containsKey(val)){
            linkedList.remove(cache.get(val));
        }

        if(cache.size() == capacity) {
            //remove the last element
            int oldest = linkedList.tail.data;
            cache.remove(oldest);
            linkedList.removeLast();
        }

        Node n = linkedList.addToHead(val);
        cache.put(val,n);
    }
}
