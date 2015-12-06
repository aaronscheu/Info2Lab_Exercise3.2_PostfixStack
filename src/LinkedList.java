import java.util.EmptyStackException;

/**
 * Created by amaridev on 27/11/15.
 * Package: PACKAGE_NAME for Exercise3.2_.
 */

public class LinkedList<Item> {

    private static int counter;
    private Node first;
    private Node last;

    // default constructor
    public LinkedList() {
        this.first = null;
        this.last = null;
        counter = 0;
    }

    private static int getCounter() {
        return counter;
    }

    private static void incCounter() {
        counter++;
    }

    private void decCounter() {
        counter--;
    }

    public int getSize() {
        return getCounter();
    }

    public boolean isEmpty() {
        return counter < 1;
    }

    public void add(Item data) {

        // Initialize Node if 1st element
        if (first == null) {
            first = new Node(data);
            last = first;
        } else {

            Node temp = new Node(data);
            Node current = first;

            if (current != null) {
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                temp.setPrevious(current);
                current.setNext(temp);
                last = temp;
            }
        }
        incCounter();
    }

    public Item remove() {

        Node temp = last;
        if (last == null) {
            throw new EmptyStackException();
        } else {
            last = last.getPrevious();
            last.setNext(null);
        }

        decCounter();
        return temp.getData();
    }

    public Item getLast() {
        return last.getData();
    }

    @Override
    public String toString() {
        String output = "";

        if (first != null) {
            Node current = first;
            while (current != null) {
                output += "[" + current.getData().toString() + "]";
                current = current.getNext();
            }
        }
        return output;
    }


    /**
     * Inner Class for Nodes
     */
    private class Node {

        Item data;
        Node next;
        Node previous;

        public Node(Item object) {
            this(object, null, null);
        }

        public Node(Item object, Node previousNode, Node nextNode) {
            this.data = object;
            this.next = nextNode;
            this.previous = previousNode;
        }

        public Item getData() {
            return data;
        }

        public void setData(Item nodeData) {
            data = nodeData;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextNode) {
            next = nextNode;
        }

        public Node getPrevious(){
            return previous;
        }

        public void setPrevious(Node previousNode) {
            previous = previousNode;
        }
    }
}
