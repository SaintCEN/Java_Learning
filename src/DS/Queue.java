package DS;

import java.util.NoSuchElementException;

public class Queue<E> {
    private final Node<E> head = new Node<>(null);

    public void push(E element){
        Node<E> last = head;
        while (last.next != null)
            last = last.next;
        last.next = new Node<>(element);
    }

    public E pop(){
        if(head.next == null)
            throw new NoSuchElementException("队列为空");
        E e = head.next.element;
        head.next = head.next.next;
        return e;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public static void main(String[] args){
        Queue<String> stack = new Queue<>();
        stack.push("AAA");
        stack.push("BBB");
        stack.push("CCC");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
