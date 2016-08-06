package datastructure.listanditerator6;

import datastructure.deque.Deque;
import datastructure.exceptions.BoundaryViolationException;
import datastructure.exceptions.InvalidPositionException;

/**
 * Interface para uma sequencia, uma estrutura de dados que suporta
 * todas as operacoes de um deque, lista indexada e lista de posicoes.
 * @author mrl00
 * @param <E>
 */
public interface Sequence<E> 
        extends Deque<E>, IndexList<E>, PositionList<E>{
    /**
     * 
     * @param r
     * @return Retorna a posicao contendo o elemento em um dado indice.
     * @throws BoundaryViolationException 
     */
    public Position<E> atIndex(int r) throws BoundaryViolationException;
    
    /**
     * 
     * @param p
     * @return o indice de um elemento armazenado em uma determinada posicao.
     * @throws InvalidPositionException 
     */
    public int indexOf(Position<E> p) throws InvalidPositionException;
}
