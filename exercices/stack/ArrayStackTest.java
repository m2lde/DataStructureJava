package exercices.stack;



import java.util.Arrays;
import datastructure.stack.Stack;
import datastructure.stack.ArrayStack;
/**
 * 
 * @author mrl00
 */
public class ArrayStackTest {
    public static <E> void reverse(E[] a) {
        Stack<E> S = new ArrayStack<>(a.length);
        for (E a1 : a) {
            S.push(a1);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = S.pop();
        }
    }
    public static void main(String[] args) {
        Integer[] a = {4, 8, 15, 16, 23, 42};
        {}String[] s = {"Jack", "Kate", "Hurley", "Jin", "Boone"};
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
        System.out.println("Reversing...");
        reverse(a);
        reverse(s);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
    }
}
