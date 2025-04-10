import java.util.*;

// TODO 5.1
class Stack1 {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public Stack1(int size) {
        // write code here
        this.stackArray = new int[size];
        this.top = -1;
        this.maxSize = size;
    }

    public void push(int value) {
        // write code here
        if(isEmpty()) {
            stackArray[++top] = value;
        }else {
            System.out.println("Too many elements");
        }
    }

    public int pop() {
        // write code here
        if (top >= 0) {
            int value = stackArray[top];
            stackArray[top] = 0;
            top--;
            return value;
        }
        System.out.println("No elements in stack");
        return -1;
    }

    public int peek() {
        // write code here
        return stackArray[top];
    }

    public boolean isEmpty() {
        // write code here
        return stackArray.length == 0;
    }

    public boolean isFull() {
        // write code here
        return stackArray.length != 0;
    }

    public void display() {
        System.out.println(Arrays.toString(stackArray));
    }
}

class StackExample {
    public static void main(String[] args) {
        Stack1 stack = new Stack1(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        stack.pop();
        stack.display();
        System.out.println(stack.peek());
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.display();
    }
}

// TODO 5.2
class BalancedParenthesisChecker {
    public static boolean isBalanced(String expression) {
        //write code here
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '[' || c == '{' || stack.isEmpty()) stack.push(c);
            if ((stack.peek() == '(' && c == ')') || (stack.peek() == '[' && c == ']') || (stack.peek() == '{' && c == '}'))
                stack.pop();
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expression1 = "{(a+b)*(c-d)}";
        String expression2 = "{(a+b)*[c-d)}";
        //write code here
        System.out.println(isBalanced(expression1));
        System.out.println(isBalanced(expression2));
    }
}

// TODO 5.3
class PostfixEvaluator {
    public static int evaluatePostfix(String expression) {
        //write code here
        Stack<Integer> stack = new Stack<>();
        String[] raw = expression.split(" ");
        for (String s : raw) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
                stack.push(performOperation(s.charAt(0), stack.pop(), stack.pop()));
            else stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }

    public static int performOperation(char operator, int operand1, int operand2) {
        //write code here
        return switch (operator) {
            case '+' -> operand2 + operand1;
            case '-' -> operand2 - operand1;
            case '*' -> operand2 * operand1;
            case '/' -> operand2 / operand1;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        //write code here
        String expression1 = "2 3 1 * + 9 -";
        String expression2 = "100 200 + 2 / 5 * 7 +";
        System.out.println(evaluatePostfix(expression1));
        System.out.println(evaluatePostfix(expression2));
    }
}

// TODO 5.4
class Conversion {
    public static void main(String[] args) {
        // infix to postfix
        Stack<Character> stack = new Stack<>();
//        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        String infix = "a+b*c-d^e^f";
        StringBuilder postfix = new StringBuilder();
        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) postfix.append(c);
            else if (c == '(') stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') postfix.append(stack.pop());
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) postfix.append(stack.pop());
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) postfix.append(stack.pop());
        System.out.println(postfix);
    }
    private static int getPrecedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> 0;
        };
    }
}

// TODO 5.5
class ReverseStack {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> rev_stack = new Stack<>();
        for (int n : arr) {
            stack.push(n);
        }
        while (!stack.isEmpty()) {
            rev_stack.push(stack.pop());
        }
        System.out.println();
        while (!rev_stack.isEmpty()) {
            System.out.print(rev_stack.pop() + " ");
        }
    }
}