package datastructure.listanditerator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author mrl00
 * @param <E>
 */
public class ElementIterator<E> implements Iterator<E>{
    protected PositionList<E> list;
    protected Position<E> cursor;

    public ElementIterator(PositionList<E> L) {
        this.list = L;
        cursor = (list.isEmpty()) ? null : list.first();
    }
    
    @Override
    public boolean hasNext() {return cursor != null;}

    @Override
    public E next() throws NoSuchElementException {
        if(this.cursor == null)
            throw new NoSuchElementException("No next element.");
        E toReturn = this.cursor.getElement();
        this.cursor = (this.cursor == this.list.last()) ? null : this.list.after(this.cursor);
        return toReturn;
    }
}
