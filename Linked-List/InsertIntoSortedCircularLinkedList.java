public class InsertIntoSortedCircularLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) { 
            this.data = data;
            this.next = null;
        }
    }

    public static Node insert(Node head, int data) {

        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        if (head.next == head) {
            head.next = newNode;
            newNode.next = head;
            return head;
        }

        Node prev = head;
        Node nxt = prev.next;

        do {
            if (prev.data <= newNode.data && newNode.data <= nxt.data) {
                prev.next = newNode;
                newNode.next = nxt;
                return head;
            }

            if (prev.data > nxt.data) {
                if (data <= prev.data || data <= nxt.data) {
                    prev.next = newNode;
                    newNode.next = nxt;
                    return head;
                }
            }

            prev = prev.next;
            nxt = nxt.next;

        } while (prev != head);

        prev.next = newNode;
        newNode.next = nxt;
        return head;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static Node createCircularList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        curr.next = head;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,7,9};
        Node head = createCircularList(arr);

        System.out.println("Original list:");
        printList(head);

        head = insert(head, 5);

        System.out.println("List after insertion:");
        printList(head);
    }
}
