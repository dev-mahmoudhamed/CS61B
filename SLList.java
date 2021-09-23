public class SLList<T> {

    private class Node {
        T item;
        Node next;

        public Node(T i, Node node) {
            this.item = i;
            next = node;
        }
    }

    int size;
    Node sentinel;

    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList(T x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size++;
    }

    public void addFirst(T x) {
        sentinel.next = new Node(x, sentinel.next);
        size++;
    }

    public void addLast(T x) {
        Node p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(x, null);
        size++;
    }

    private T getFirst() {
        return sentinel.next.item;
    }

    public int getSize() {
        return size;
    }
}