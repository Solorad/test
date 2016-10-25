package concurrent;


import java.util.concurrent.atomic.AtomicReference;

/**
 * @author emorenkov. Algorithm by Michael & Scott.
 */
public class LinkedQueue<T> {

    private final Node<T> dummy = new Node<>(null, null);
    private final AtomicReference<Node<T>> head = new AtomicReference<>(dummy);
    private final AtomicReference<Node<T>> tail = new AtomicReference<>(dummy);

    public boolean put(T item) {
        Node<T> newNode = new Node<>(item, null);
        while (true) {
            Node<T> curTail = tail.get();
            Node<T> tailNext = curTail.getNext().get();
            if (curTail == tail.get()) {
                if (tailNext != null) {
                    // Queue in intermediate state, advance tail
                    tail.compareAndSet(curTail, tailNext);
                } else {
                    if (curTail.next.compareAndSet(null, newNode)) {
                        // Insertion succeeded, try advancing tail
                        tail.compareAndSet(curTail, newNode);
                    }
                }
            }
        }
    }


    private static class Node<T> {
        private final T value;
        private AtomicReference<Node<T>> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = new AtomicReference<>(next);
        }

        public T getValue() {
            return value;
        }

        public AtomicReference<Node<T>> getNext() {
            return next;
        }

        public void setNext(AtomicReference<Node<T>> next) {
            this.next = next;
        }
    }
}
