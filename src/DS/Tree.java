package DS;

import java.util.NoSuchElementException;

public class Tree {
    public static class LinkedQueue<E> {
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
        public boolean isEmpty(){
            return head.next == null;
        }
        private static class Node<E> {
            E element;
            Node<E> next;
            public Node(E element) {
                this.element = element;
            }
        }
    }

    public static class TreeNode<E>{
        public E element;
        public TreeNode<E> left,right;

        public TreeNode(E element){
            this.element = element;
        }
    }

    private static <T> void preOrder(TreeNode<T> root){
        if(root == null) return;
        System.out.print(root.element);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static <T> void inOrder(TreeNode<T> root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.element);
        inOrder(root.right);
    }

    private static <T> void postOrder(TreeNode<T> root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.element);
    }

    private static <T> void levelOrder(TreeNode<T> root){
        LinkedQueue<TreeNode<T>> queue = new LinkedQueue<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.pop();
            System.out.print(node.element);
            if(node.left != null) queue.push(node.left);
            if(node.right != null) queue.push(node.right);
        }
    }

    public static void main(String[] args){
        TreeNode<Character> a = new TreeNode<>('A');
        TreeNode<Character> b = new TreeNode<>('B');
        TreeNode<Character> c = new TreeNode<>('C');
        TreeNode<Character> d = new TreeNode<>('D');
        TreeNode<Character> e = new TreeNode<>('E');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        System.out.println(a.left.left.element);
        preOrder(a);
    }
}
