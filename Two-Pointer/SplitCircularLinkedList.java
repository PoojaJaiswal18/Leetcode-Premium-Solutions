class SplitCircularLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node[] splitCircularLinkedList(Node head) {
        if (head == null || head.next == head) {
            return new Node[]{head, null};
        }

        Node fast = head;
        Node slow = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node head1 = head;
        Node head2;

      
        if (fast.next.next == head) {
            fast = fast.next;
        }

        head2 = slow.next;

        slow.next = head1;

        fast.next = head2;

        System.out.print("First half: ");
        printCircularList(head1);
        System.out.print("Second half: ");
        printCircularList(head2);

        return new Node[]{head1, head2};
    }

    public static void printCircularList(Node head) {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);
       

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = head;

        splitCircularLinkedList(head);
    }
}
