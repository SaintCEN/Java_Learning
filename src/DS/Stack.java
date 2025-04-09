package DS;

import java.util.NoSuchElementException;

public class Stack<E> {
    private final Node<E> head = new Node<>(null);

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public void push(E element){
        Node<E> node = new Node<>(element);
        node.next = head.next;
        head.next = node;
    }

    public E pop(){
        if(head.next == null){
            throw new NoSuchElementException("Empty.");
        }
        E e = head.next.element;
        head.next = head.next.next;
        return e;
    }
    public static void main(String[] args){
        Stack<String> stack = new Stack<>();
        stack.push("AAA");
        stack.push("BBB");
        stack.push("CCC");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}