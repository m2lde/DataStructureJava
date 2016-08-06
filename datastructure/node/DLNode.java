package datastructure.node;



/**
 * 
 * @author mrl00
 */
public class DLNode<E> {
    private DLNode<E> next;
    private DLNode<E> prev;
    private E element;

    public DLNode() {
        this(null, null, null);
    }

    
    public DLNode(E element, DLNode<E> prev, DLNode<E> next) {
        this.next = next;
        this.prev = prev;
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DLNode<E> getPrev() {
        return prev;
    }

    public void setPrev(DLNode<E> prev) {
        this.prev = prev;
    }

    public DLNode<E> getNext() {
        return next;
    }

    public void setNext(DLNode<E> next) {
        this.next = next;
    }
}