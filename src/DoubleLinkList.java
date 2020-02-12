
import java.util.Iterator;
import java.util.NoSuchElementException;
/*
 *
 * An implementation of a double-linked list.
 */
public class DoubleLinkList<Object>  {

    private Node first;
    private Node last;

    //constructs an empty linked list.
    public DoubleLinkList () {
        first = null;
        last = null;
    }

    class Node {
        public Node next;
        public Node previous;
        Object data;
    }


    /**
     * adds an element to the front of the linked list.
     *
     * @param element the element to add
     */
    public void addFirst(Object element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.previous = null;
        newNode.next = first;
        //update the previous reference of the node following the added node
        if (first != null) {
            first.previous = newNode;
        }
        //if the list was previously empty,the new node becomes both the first and last node
        if (first == null) {
            last = newNode;
        }

        first = newNode;
    }

    /**
     * removes the first element in the linked list
     *
     * @return the removed element
     */

    public Object removeFirst() {
        if (first == null) throw new NoSuchElementException();
        Object element = first.data;
        //first.next.previous = null;
        first = first.next;
        //must make sure if the list is empty or not first, because null does not have previous variable
            /*first.previous = null;
            if(first == null){last = null;}*/
        if (first == null) { last = null; }
        else { first.previous = null; }
        return element;
    }


    /**
     * Adds an element ot the back of the linked list
     *
     * @param element the element to add
     */
    public void addLast(Object element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = null;
        newNode.previous = last;
        if (last == null)
            first = newNode;
        else
            last.next = newNode;
        last = newNode;
    }

    /**
     * remove the last element in the linked list
     *
     * @return the removed element
     */
    public Object removeLast() {
        if (last == null) throw new NoSuchElementException();
        Object element = last.data;
        last = last.previous;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        return element;
    }

    /**
     * figure out if contain an object
     * @param element one object
     * @return true if it contains element,otherwise false
     */
    public boolean contains(Object element)
    {
        if(first == null) return false;
        else if(first.data.equals(element)) return true;
        else
            {
                Node temp = first;
                while(temp.next != null)
                {
                    temp = temp.next;
                    if(temp.data.equals(element)) return true;
                }
            }
            return false;
    }


    /**
     * returns an iterator traversing in reverse sequential order.
     * @return an iterator for iterating through this list
     */
    public Iterator<Object> descendingIterator()
    {return new MyDescendingIterator();}

    class MyDescendingIterator implements Iterator<Object>
    {
        public Node position;

        /**
         * Constructs an iterator that points the end of the linked list.
         */
        public MyDescendingIterator()
        {
            position = last;

        }
        /**
         * Test if there is an element before the iterator position
         *
         * @return true if there is an element before the iterator position
         */
        public boolean hasNext() {

            return position != null;
        }
        /**
         * Moves the iterator past the previous element
         *
         * @return the traversed element
         */
        public Object next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Object element = position.data;
            position = position.previous;
            return element;
        }
    }

    /**
     * returns an iterator for iterating through this list
     * @return an iterator for iterating through this list
     */
    public Iterator<Object> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<Object>
    {
        private Node position;

        /**
         * Constructs an iterator that points the front of the linked list.
         */
        public MyIterator() {
            position = null;
        }

        /**
         * Test if there is an element after the iterator position
         *
         * @return true if there is an element after the iterator position
         */
        public boolean hasNext() {
            if (position == null) {
                return first != null;
            }
            return position.next != null;
        }

        /**
         * Moves the iterator past the next element
         *
         * @return the traversed element
         */
        public Object next() {
            if (!hasNext()) throw new NoSuchElementException();
            if (position == null) {
                position = first;
            } else {
                position = position.next;
            }
            return position.data;
        }


        /**
         * Test if there is an element before the iterator position
         *
         * @return true if there is an element before the iterator position
         *//*
        public boolean hasPrevious() {
            return position != null;
        }*/
        /**
         * Moves the iterator before the previous element
         *
         * @return the traversed element
         *//*
        public Object previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            Object element = position.data;
            position = position.previous;
            isAfterPre = true;
            isAfterNext = false;
            return element;
        }*/

        /**
         * Adds an element before the iterator position
         * and moves the iterator past the inserted element
         *
         * @param element
         *//*
        public void add(Object element) {
            if (position == null) {
                addFirst(element);
                position = first;
            } else {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                newNode.previous = position;
                if (position.next != null)
                    position.next.previous = newNode;
                position.next = newNode;
                position = newNode;

            }
            isAfterNext = false;
            isAfterPre = false;
        }*/

        /**
         * Removes the last traversed element.
         *//*
        public void remove() {
            if (!isAfterNext && !isAfterPre) {
                throw new IllegalStateException();
            }
            if (isAfterNext) {
                if (position == last)
                    removeLast();
                else if (position == first)
                    removeFirst();
                else {
                    position.previous.next = position.next;
                    position.next.previous = position.previous;
                }
                position = position.previous;
                isAfterNext = false;
                isAfterPre = false;
            } else if (isAfterPre) {
                if (position == null)
                    removeFirst();
                else if (position == last.previous)
                    removeLast();
                else {
                    position.next.next.previous = position;
                    position.next = position.next.next;
                }
                isAfterPre = false;
                isAfterNext = false;
            }
        }*/
        /**
         * Sets the last traversed element to a different value.
         *
         * @param element the element to set
         *//*
        public void set(Object element) {
            if (isAfterPre)
                if (position == null)
                    first.data = element;
                else
                    position.data = element;
            else if (isAfterNext)
                position.data = element;
            else
                throw new IllegalStateException();
        }*/


    }
}