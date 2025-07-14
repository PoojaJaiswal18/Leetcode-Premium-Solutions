class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

class SkipMNodesDeleteNNodes{
    public static Node skipMDeleteN(Node head, int m, int n) {
        Node first = head;

        while (first != null) {
           
            int count = 1;
            while (first != null && count < m) {
                first = first.next;
                count++;
            }
            if (first == null) {
                break;
            }

            Node second = first.next;
            count = 0;
            while (second != null && count < n) {
                second = second.next;
                count++;
            }

            first.next = second;
            first = second;
        }
        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        int m = 2, n = 3;

        Node resultHead = skipMDeleteN(head, m, n);

        printList(resultHead); 
    }
}
