/**
 * Pilha generica usando uma lista encadeada generica. Assim, e necessario usar
 * um tipo generico de nodo para implementar essa lista encadeada.
 */

package datastructure.node;

/**
 * 
 * @author mrl00
 * @param <E>
 */
public class Node<E> {
    //Variaveis de instancia
    private E element;
    private Node<E> next;
    
    /**
     * Cria um nodo com referencias nulas
     * para os seus elementos e o proximo nodo
     */
    public Node() {
        this(null, null);
    }
    
    /**
     * Cria um nodo com um dado elemento
     * e o proximo nodo.
     * @param element
     * @param next 
     */
    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }

    //Metodos de acesso:
    public E getElement() {
        return element;
    }
    
    public Node<E> getNext() {
        return next;
    }
    
    //Metodos modificadores:
    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(Node<E> newNext) {
        this.next = newNext;
    }
}
