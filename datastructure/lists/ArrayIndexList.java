package datastructure.listanditerator;

/**
 * 
 * @author mrl00
 * @param <E>
 */
public class ArrayIndexList<E> implements IndexList<E>{
    private E[] A;
    private int capacity;
    private int size = 0;

    public ArrayIndexList() {
        this.capacity = 16;
        this.A = (E[]) new Object[this.capacity];
    }
    
    public ArrayIndexList(int capacity) {
        this.capacity = capacity;
        this.A = (E[]) new Object[capacity];
    }
    /**
     * Verifica se um indice r e valido;
     * @param r
     * @return 
     */
    public boolean checkIndex(int r) {
        return r >= 0 && r <= this.A.length - 1;
    }
    /**
     * @return this.size
     */
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void add(int r, E e) throws IndexOutOfBoundsException {
        if(!checkIndex(r))
            throw new IndexOutOfBoundsException("Indice fora do intervalo");
        if(this.size == this.capacity) {
            this.capacity *= 2;
            E[] B = (E[]) new Object[this.capacity];
            for (int i = 0; i < this.size; i++) 
                B[i] = this.A[i];
            this.A = B;
        }
        for (int i = this.size - 1; i > r; i--) 
            this.A[i + 1] = this.A[i];
        this.A[r] = e;
        this.size++;
    }
    /**
     * 
     * @param r
     * @return the element on index r
     */
    @Override
    public E get(int r) {
        if(!checkIndex(r))
            throw new IndexOutOfBoundsException("Indice fora do intervalo");
        return this.A[r];
    }
    
    @Override
    public E remove(int r) {
        if(!checkIndex(r))
            throw new IndexOutOfBoundsException("Indice fora do intervalo");
        E temp = A[r];
        for (int i = r; i < this.size - 1; i++) {
            this.A[i] = this.A[i + 1];
        }
        this.size--;
        return temp;
    }

    @Override
    public E set(int r, E e)  {
        if(!checkIndex(r))
            throw new IndexOutOfBoundsException("Indice fora do intervalo");
        E temp = this.A[r];
        this.A[r] = e;
        return temp;
    }

}
