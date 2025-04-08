package DS;

public class LinkedList<E> {
    private Node<E> head = new Node<>(null);
    private int size = 0;

    public static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public void add(E element, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("插入位置非法");
        Node<E> prev = head;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        Node<E> node = new Node<>(element);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("删除位置非法");
        Node<E> prev = head;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        E e = prev.next.element;
        prev.next = prev.next.next;
        size--;
        return e;
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("非法的位置");
        Node<E> node = head.next;
        for (int i = 0; i < index; i++)
            node = node.next;
        return node.element;
    }

    public void printList() {
        Node<E> current = head.next;
        while (current != null) {
            System.out.println(current.element);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2, 0);
        list.add(3, 1);
        list.add(4, 2);

        System.out.println("List contents:");
        list.printList();

        int removed = list.remove(2);
        System.out.println("Removed: " + removed);

        int element = list.get(1);
        System.out.println("Element at index 1: " + element);

        System.out.println("Updated list:");
        list.printList();
    }
}