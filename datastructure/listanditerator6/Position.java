package datastructure.listanditerator6;

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
