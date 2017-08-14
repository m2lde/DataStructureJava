package datastructure.graph;

/**
 *
 * @author mrl00
 * @param <E>
 */
@FunctionalInterface
public interface Position<E> {
	
    /**
     * 
     * @return elemento armazenado nesta posicao
     */
    E element();
}
