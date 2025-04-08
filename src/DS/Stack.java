package DS;

public class Stack<E> {
    private final Node<E> head = new Node<>(null);

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    

    public static void main(String[] args){

    }
}