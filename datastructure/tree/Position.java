
package datastructure.tree;

/**
 * 
 * @author mrl00
 * @param <T>
 */
@FunctionalInterface
public interface Position<T> {
    /**
     * 
     * @return elemento nesta posicao. 
     */
    T element();
}