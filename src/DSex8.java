import java.util.ArrayList;

// TODO 8.1

class Main {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class CircularLinkedList {
        static Node head;

        CircularLinkedList() {
            head = null;
        }

        static Node addAfter(int data, int item) {
            Node temp_ = head;
            if (head == null) {
                return null;
            }
            if (temp_.data == item) {
                Node node = new Node(data);
                node.next = temp_.next;
                temp_.next = node;
            }

            while (temp_.next != head) {
                if (temp_.data == item) {
                    Node node = new Node(data);
                    node.next = temp_.next;
                    temp_.next = node;
                    return head;
                }
                temp_ = temp_.next;
            }
            return head;
        }

        static void deleteNode(Node head, int key) {
            if (head == null) {
                return;
            }
            Node curr = head;
            Node prev = null;
            while (curr.next != head) {
                if (curr.data == key) {
                    // if in next of head
                    if (prev == null) {
                        while (curr.next != head) {
                            curr = curr.next;
                        }
                        head = head.next;
                        curr.next = head;
                    } else {
                        prev.next = curr.next;
                    }
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
            // if last node
            if (curr.data == key) {
                if (prev == null) {
                    head = null;
                } else {
                    prev.next = curr.next;
                }
            }
        }

        public static void main(String[] args) {
            head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(4);
            head.next.next.next.next = head;

            deleteNode(head, 2);

            Node temp= head;
            while (temp.next != head) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }
}

// TODO 8.2
class Node_ {
    int data;
    Node_ next;
    Node_ prev;

    Node_(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DLinkedList {
    Node_ head;
    int ctr;

    DLinkedList() {
        this.head = null;
        this.ctr = 0;
    }

    void insertBeg(int data) {
        if (head == null) {
            head = new Node_(data);
            head.next = head;
            head.prev = head;
        } else {
            Node_ temp = new Node_(data);
            temp.next = head;
            temp.prev = head.prev;
            head.prev.next = temp;
            head.prev = temp;
            head = temp;
        }
    }

    void insertEnd(int data) {
        if (head == null) {
            head = new Node_(data);
            head.next = head;
            head.prev = head;
        } else {
            Node_ temp = new Node_(data);
            temp.next = head;
            temp.prev = head.prev;
            head.prev.next = temp;
            head.prev = temp;
        }
    }

    void deleteBeg() {
        if (head == null) {
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            head.next.prev = head.prev;
            head.prev.next = head.next;
            head = head.next;
        }
    }

    void deleteEnd() {
        if (head == null) {
            return;
        }
        if (head.next == head) {
            head = null;
        } else {
            head.prev.prev.next = head;
            head.prev = head.prev.prev;
        }
    }

    void insertPos(int pos, int data) {
        Node_ temp2 = new Node_(data);
        for (int i = 0; i < pos - 1; i++) {
            head = head.next;
        }
        temp2.next = head.next;
        temp2.prev = head;
        head.next.prev = temp2;
        head.next = temp2;
    }

    void deletePos(int pos) {
        Node_ temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
    }

    void traverseF() {
        Node_ temp = head;
        while (temp.next != head) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    void traverseR() {
        Node_ temp = head.prev;
        while (temp.prev != head.prev) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        DLinkedList dll = new DLinkedList();
        dll.insertBeg(10);
        dll.insertBeg(20);
        dll.insertBeg(30);
        dll.insertBeg(40);
        dll.insertBeg(50);
        dll.insertEnd(60);
        dll.insertEnd(70);
        dll.insertEnd(80);
        dll.insertEnd(90);
        dll.insertEnd(100);
        dll.insertPos(3, 25);
        dll.insertPos(7, 65);
        dll.deleteBeg();
        dll.deleteEnd();
        dll.deletePos(3);
        dll.traverseF();
        dll.traverseR();
    }
}

// TODO 8.3
class SortedMergeDoublyCircularLinkedList {
    static Node_ mergeUtil(Node_ first, Node_ second) {
        if (first == null)
            return second;

        // If second list is empty
        if (second == null)
            return first;

        // Pick the smaller value
        Node_ head = null;
        if (first.data <= second.data) {
            head = first;
            first = first.next;
        } else {
            head = second;
            second = second.next;
        }

        Node_ curr = head;
        curr.prev = null;

        // Merge remaining nodes
        while (first != null && second != null) {
            if (first.data <= second.data) {
                curr.next = first;
                first.prev = curr;
                curr = first;
                first = first.next;
            } else {
                curr.next = second;
                second.prev = curr;
                curr = second;
                second = second.next;
            }
        }

        if (first != null) {
            curr.next = first;
            first.prev = curr;
            // Find the last node
            while (curr.next != null) {
                curr = curr.next;
            }
        }

        if (second != null) {
            curr.next = second;
            second.prev = curr;
            // Find the last node
            while (curr.next != null) {
                curr = curr.next;
            }
        }
        // Make it circular
        curr.next = head;
        head.prev = curr;

        return head;
    }

    static void printList(Node_ head) {
        Node_ temp = head;
        while (temp.next != head) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        Node_ head1 = new Node_(1);
        Node_ second1 = new Node_(3);
        Node_ third1 = new Node_(5);

        head1.next = second1;
        second1.prev = head1;
        second1.next = third1;
        third1.prev = second1;

        Node_ head2 = new Node_(2);
        Node_ second2 = new Node_(4);
        Node_ third2 = new Node_(6);

        head2.next = second2;
        second2.prev = head2;
        second2.next = third2;
        third2.prev = second2;

        System.out.print("First List: ");
        Node_ curr = head1;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();

        System.out.print("Second List: ");
        curr = head2;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();

        // Merge lists
        Node_ mergedHead = mergeUtil(head1, head2);

        System.out.print("Merged List: ");
        printList(mergedHead);
    }
}

// TODO 8.4
class DeleteOccurrenceInDoublyLinkedList {
    static Node_ deleteAllOccurOfX(Node_ head, int x) {
        return null;
    }

    static void printList(Node_ head) {
    }

    public static void main(String[] args) {
    }
}

// TODO 8.5
class DeleteNodeAtGivenPosition {
    static Node_ deleteNode(Node_ head, Node_ del) {
        return null;
    }

    static void deleteNodeAtGivenPos(Node_ head, int x) {
    }

    static void printList(Node_ head) {
    }

    public static void main(String[] args) {
    }
}