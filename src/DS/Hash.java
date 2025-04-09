package DS;

public class Hash<E> {
    private final int TABLE_SIZE = 10;
    private final Node<E>[] TABLE = new Node[TABLE_SIZE];

    public Hash(){ //初始化
        for (int i = 0; i < TABLE_SIZE; i++)
            TABLE[i] = new Node<>(null);
    }

    private int hash(Object object){ //获取哈希编码
        int hashCode = object.hashCode();
        return hashCode % TABLE_SIZE;
    }

    public void insert(E element){
        int index = hash(element);
        Node<E> prev = TABLE[index];
        while (prev.next != null)
            prev = prev.next;
        prev.next = new Node<>(element);
    }

    public boolean contains(E element){
        int index = hash(element);
        Node<E> node = TABLE[index].next;
        while (node != null) {
            if(node.element == element)
                return true;
            node = node.next;
        }
        return false;
    }

    private static class Node<E> {
        private final E element;
        private Node<E> next;

        private Node(E element){
            this.element = element;
        }
    }
}