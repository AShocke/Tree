/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author a.efemwonkieke
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public  static void testTree() {
         Tree t = new Tree();
        for (int i = 0; i < 1000; i++) {
            t.add((int)(Math.random() * 1000));
        }
        t.inOrder();
        t.add(24);
        System.out.println();
        t.inOrder();
        System.out.println();
        t.remove(53);
        t.inOrder();
    }
    
    public static void testHeap() {
        int size = 10;
        Comparable[] c = new Comparable[size];
        for (int i = 0; i < size; i++) {
            c[i] = (int) (Math.random() * 100);
            System.out.print(c[i] + " ");
        }
        System.out.println();
        Heap h = new Heap(c);
        System.out.println(h.size() + " " + h.capacity());
        h.print();
        
        h.add(0);
        System.out.println(h.size() + " " + h.capacity());
        h.print();
        
        h.add(400);
        System.out.println(h.size() + " " + h.capacity());
        h.print();
        int length = h.size();
        for (int i = 0; i < 10; i++)  {
            h.add((int) (Math.random() * 1000));
            h.print();
            System.out.println(h.size() + " " + h.capacity());
        } 
        System.out.println(h.size() + " " + h.capacity());
    }
    public static void main(String[] args) {
       testHeap();
    }
    
}
