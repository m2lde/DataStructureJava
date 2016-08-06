package exercices.stack;

import datastructure.stack.Stack;
import static datastructure.stack.ArrayStack.CAPACITY;
import datastructure.stack.NodeStack;
import java.io.*;
import java.util.Scanner;


/**
 * Verificacao simplificada de tags
 * em um arquivo HTML.
 * 
 * @author mrl00
 */
public class HTML {
    
    /** Retira o primeiro e o ultimo caracter de uma <tag> string
     * @param t
     * @return  
     */
    public static String stripEnds(String t) {
        if(t.length() <= 2) return null;
        return t.substring(1, t.length() - 1);
    }
    
    /** Testa se uma tag string retirada e vazia ou e uma tag de abertura verdadeir
     * @param tag
     * @return 
     */
    public static boolean isOpeningTag(String tag) {
        return(tag.length() == 0) || (tag.charAt(0) !='/');
    }
    
    /**Testa se a tag1 casa com a tag2 de fechamento (o primeiro caractere e um '/')*/
    public static boolean areMatchingTags(String tag1, String tag2) {
        return tag1.equals(tag2.substring(1));
    }
    
    //** Testa se toda a tag de abertura tem uma tag de fechamento */
    public static boolean isHTMLMatched(String[] tag) {
        Stack<String> S = new NodeStack<>();
        for (int i = 0; (i < tag.length) && (tag[i] != null); i++) {
            if(isOpeningTag(tag[i]))
                S.push(tag[i]);
            else {
                if(S.isEmpty())
                    return false;
                if(!areMatchingTags(S.pop(), tag[i]))
                    return false;
            }
        }
        return S.isEmpty();
    }
    public static String[] parseHTML(Scanner s) {
        /* Transforma um documento HTML em um arranjo de tags HTML */
        String[] tag = new String[CAPACITY];
        int count = 0;
        String token;
        while(s.hasNextLine()) {
            while((token = s.findInLine("<[^>]*>")) != null)
                tag[count++] = stripEnds(token);
            s.nextLine();
        }
        return tag;
    }
    public static void main(String[] args) throws IOException {
        if(isHTMLMatched(parseHTML(new Scanner(System.in))))
            System.out.println("The input file is a matched HTML document.");
        else
            System.out.println("The input file is not a matched HTML document.");
    }
}
