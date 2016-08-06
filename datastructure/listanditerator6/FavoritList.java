package datastructure.listanditerator6;

/**
 *
 * @author mrl00
 * @param <E>
 */
public class FavoritList<E> {
    protected PositionList<Entry<E>> fList;

    public FavoritList() {this.fList = new NodePositionList<>();}
    
    public int size() {return fList.size();}
    
    public boolean isEmpty() {return fList.isEmpty();}
    
    public void remove(E obj) {
        Position<Entry<E>> p = find(obj);
        if(p != null)
            fList.remove(p);
    }
    
    public void access(E obj) {
        Position<Entry<E>> p = find(obj);
        if(p != null)
            p.element().incrementCount();
        else {
            fList.addLast(new Entry<>(obj));
            p = fList.last();
        }
        moveUp(p);
    }
    
    protected Position<Entry<E>> find(E obj) {
        for (Position<Entry<E>> p: fList.positions()) 
            if(value(p).equals(obj))
                return p;
        return null;
    }
    
    protected void moveUp(Position<Entry<E>> cur) {
        Entry<E> e = cur.element();
        int c = count(cur);
        while(cur != fList.first()) {
            Position<Entry<E>> prev = fList.prev(cur);
            if(c <= count(prev)) break;
            fList.set(cur, prev.element());
            cur = prev;
        }
        fList.set(cur, e);
    }
    
    public Iterable<E> top(int k) {
        if(k < 0 || k > size())
            throw new IllegalArgumentException("Invalid argument");
        PositionList<E> T = new NodePositionList<>();
        int i = 0;
        for (Entry<E> e : fList) {
            if(++i >= k) break;
            T.addLast(e.value());
        }
        return T;
    }
    
    @Override
    public String toString() {return fList.toString();}
    
    protected E value(Position<Entry<E>> p) {return (p.element()).value();}
    
    protected int count(Position<Entry<E>> p) {return (p.element()).count();}
    
    protected static class Entry<E> {
        private final E value;    //Elemento
        private int count;  //contador de acessos

        public Entry(E v) {this.value = v; count = 1;}

        public E value() {return value;}
        
        public int count() {return count;}

        public void incrementCount() {this.count++;}
        
        @Override
        public String toString(){return "[" + count + "," + value + "]";}
    }
}
