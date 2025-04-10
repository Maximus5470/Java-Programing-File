// TODO 6.1

import java.util.*;

class LinearQueue {
    private int maxSize;
    private int front = -1;
    private int rear = -1;
    private int[] queueArray;

    LinearQueue(int size) {
        this.maxSize = size;
        this.queueArray = new int[size];
    }

    private boolean isEmpty() {
        return front == rear;
    }

    private boolean isFull() {
        return rear == maxSize - 1;
    }

    private void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            queueArray[++rear] = value;
        }
    }

    private int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queueArray[++front];
    }

    private void display() {
        System.out.println(Arrays.toString(queueArray));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the queue");
        int size = sc.nextInt();
        LinearQueue queue = new LinearQueue(size);
        while (true) {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the element to be enqueued");
                    int element = sc.nextInt();
                    queue.enqueue(element);
                }
                case 2 -> {
                    int dequeuedElement = queue.dequeue();
                    if (dequeuedElement != -1) {
                        System.out.println("The dequeued element is " + dequeuedElement);
                    }
                }
                case 3 -> queue.display();
                case 4 -> System.exit(0);
            }
        }
    }
}

// TODO 6.2
class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.remove();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top()); // Output: 2
        System.out.println(stack.pop()); // Output: 2
        System.out.println(stack.empty()); // Output: false
    }
}

// TODO 6.3
class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // Output: 1
        System.out.println(queue.pop()); // Output: 1
        System.out.println(queue.empty()); // Output: false
    }
}

// TODO 6.4
class CircularQueue {
    private int size;
    private int front, rear;
    private int[] queue;

    public CircularQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = this.rear = -1;
    }

    public void enqueue(int data) {
        if ((front == 0 && rear == size - 1) || (front == rear + 1)) {
            System.out.println("Queue is full");
        } else if (front == -1) {
            front = rear = 0;
            queue[rear] = data;
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            queue[rear] = data;
        } else {
            rear++;
            queue[rear] = data;
        }
    }

    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        int data = queue[front];
        queue[front] = -1;
        if (front == rear) {
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
        return data;
    }

    public void display() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }
        if (rear >= front) {
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
        } else {
            for (int i = front; i < size; i++) {
                System.out.print(queue[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();
        queue.dequeue();
        queue.dequeue();
        queue.display();
        queue.enqueue(60);
        queue.enqueue(70);
        queue.display();
    }
}

// TODO 6.5
class Dequeue {
    Deque<Integer> deque = new LinkedList<>();

    public void insertFront(int value) {
        deque.addFirst(value);
    }

    public void insertRear(int value) {
        deque.addLast(value);
    }

    public int deleteFront() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.removeFirst();
    }

    public int deleteRear() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.removeLast();
    }

    public int getFront() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public int getRear() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekLast();
    }

    public static void main(String[] args) {
        Dequeue dequeue = new Dequeue();
        dequeue.insertFront(10);
        dequeue.insertRear(20);
        System.out.println(dequeue.getFront()); // Output: 10
    }
}