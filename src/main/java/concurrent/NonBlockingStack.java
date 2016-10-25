package concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author emorenkov
 */
public class NonBlockingStack <T> {

    private AtomicReference<Node<T>> top = new AtomicReference<>();

    public void put(T value) {
        Node<T> node = new Node<>(value);
        Node<T> head;
        do {
            head = top.get();
            node.setNext(node);
        } while(!top.compareAndSet(head, node));
    }


    public T pop() {
        Node<T> oldHead;
        Node<T> newHead;
        do {
            oldHead = top.get();
            if (oldHead == null) {
                return null;
            }
            newHead = oldHead.getNext();
        } while(!top.compareAndSet(oldHead, newHead));
        return oldHead.getValue();
    }



    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
