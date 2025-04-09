package DS.practice;

public class Match {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if (!( (c == ')' && top == '(') ||
                            (c == '}' && top == '{') ||
                            (c == ']' && top == '[') )) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        static class Stack<T> {
            private Node<T> head = new Node<>(null);

            private static class Node<T> {
                T element;
                Node<T> next;
                Node(T element) {
                    this.element = element;
                }
            }

            public void push(T element) {
                Node<T> newNode = new Node<>(element);
                newNode.next = head.next;
                head.next = newNode;
            }

            public T pop() {
                T element = head.next.element;
                head.next = head.next.next;
                return element;
            }

            public boolean isEmpty() {
                return head.next == null;
            }
        }
    }
}
