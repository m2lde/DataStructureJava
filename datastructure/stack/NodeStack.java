package datastructure.stack;

import datastructure.exceptions.EmptyStackException;
import datastructure.exceptions.FullStackException;
import datastructure.node.Node;
import datastructure.stack.Stack;

/**
 * 
 * @author mrl00
 * @param <E>
 */
public class NodeStack<E> implements Stack<E> {
    protected Node<E> top;
    protected int size;

    public NodeStack() {
        top = null;
        size = 0;
    }
    
    @Override
    public int size() {return size;}
    
    @Override
    public boolean isEmpty() {
        return top == null;
    }
    
    @Override
    public void push(E elem) {
        Node<E> v = new Node<>(elem, top);
        top = v;
        size++;
    }
    
    @Override
    public E top() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException("Stack is empty.");
        return top.getElement();
    }
    
    @Override
    public E pop() throws FullStackException {
        if(isEmpty()) throw new FullStackException("Stack is empty.");
        E temp = top.getElement();
        top = top.getNext();
        size--;
        return temp;
    }
}
