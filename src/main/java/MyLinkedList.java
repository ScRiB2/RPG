import java.util.*;
import java.util.function.UnaryOperator;

public class MyLinkedList<E> implements List<E>{
    private class Node<E>{
        E data;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.data = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> first;

    private Node<E> last;

    private int size = 0;

    public MyLinkedList(){}

    public MyLinkedList(Collection<? extends E> c){
        this();
        addAll(c);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(0) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if( first == null){
            first = new Node<>(null, e,null);
            last = first;
            size++;
            return true;
        }
        Node<E> newNode = new Node<>(last,e,null);
        last.next = newNode;
        last = newNode;
        size++;
        return true;
    }

    public E getFirst() {
        if (first == null)
            throw new NoSuchElementException();
        return first.data;
    }

    public E getLast() {
        if (last == null)
            throw new NoSuchElementException();
        return last.data;
    }

    private void delete(Node<E> curr){
        if (curr.prev == null){

        }
    }

    public E removeFirst(){
        if (first == null)
            throw new NoSuchElementException();
        E el = first.data;
        Node<E> next = first.next;
        first.next = null;
        first.data = null;
        first = next;
        if(next != null)
            next.prev = null;
        size--;
    }

    @Override
    public boolean remove(Object o) {
        if(o == null){
            for (Node<E> curr = first; curr != null; curr = curr.next) {
                if (curr.data == null) {
                    delete(curr);
                    return true;
                }
            }
        }
        else{
            for (Node<E> curr = first; curr != null; curr = curr.next) {
                if (o.equals(curr.data)){
                    delete(curr);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;

        for (Object o : a){
            E e = (E) o;
            add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    private Node<E> node(int index){
        if (index < size/2-1){
            Node<E> curr = first;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr;
        }
        else{
            Node<E> curr = last;
            for (int i = size-1; i > index; --i) {
                curr = curr.prev;
            }
            return curr;
        }

    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).data;
    }

    private void checkElementIndex(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if(o == null){
            for (Node<E> curr = first; curr != null; curr = curr.next) {
                if (curr.data == null)
                    return index;
                index++;
            }
        }
        else{
            for (Node<E> curr = first; curr != null; curr = curr.next) {
                if (o.equals(curr.data))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

}
