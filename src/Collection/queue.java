package Collection;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class queue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("AAA");
        queue.offer("BBB");
        System.out.println(queue.poll());
        System.out.println(queue.element());
        System.out.println(queue.poll());

        Deque<String> deque = new LinkedList<>();
        deque.addFirst("AAA");
        deque.addLast("BBB");
        deque.addLast("CCC");
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque.pollFirst());
        deque.push("DDD");
        deque.pop();

        Queue<Integer> P_Queue = new PriorityQueue<>((a,b)->b-a);
        P_Queue.offer(10);
        P_Queue.offer(4);
        P_Queue.offer(5);
        System.out.println(P_Queue.poll());
        System.out.println(P_Queue.poll());
        System.out.println(P_Queue.poll());
    }
}
