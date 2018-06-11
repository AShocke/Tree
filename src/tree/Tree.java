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
public class Tree {
   private Tree left_ = null;
   private Tree right_ = null;
   private Comparable data_;
   public Tree(Comparable data) {
       data_ = data;
       right_ = null;
       left_ = null;

   }
   public Tree left() {
       return left_;
   }
   
   public Tree right() {
       return right_;
   }
   
   public Comparable data() {
       return data_;
   }
   
   public void setRight(Tree right) {
      right_ = right;
   }
   
   public void setLeft(Tree left) {
      left_ = left;
   }
   
   public void add(Comparable data) {
       addR(this, data);
   }
   
   private void addR(Tree t, Comparable data) {
       if (t.right() == null && data.compareTo(t.data()) >= 0) {
           t.setRight(new Tree(data));
           return;
       }
       else if  (t.left() == null && data.compareTo(t.data()) < 0) {
             t.setLeft(new Tree(data));
           return;
       }           
       else if (data.compareTo(t.data()) > 1) {
           addR(t.right(), data);
       }
       else if (data.compareTo(t.data()) < 1) {
           addR(t.left(), data);
       }    
   }
   public void remove(Comparable data) {
       removeR(this, data);
   }
   private void removeR(Tree t, Comparable data) {
       if (t == null) {
           return;
       }
       if (t.left().data().compareTo(data) == 0) {
           t.setLeft(null);
           return;
       }
       else if (t.right().data().compareTo(data) == 0) {
           t.setRight(null);
           return;
       }
       if (t.data().compareTo(data) > 1) {
           removeR(t.right(), data);
       }
       else if (t.data().compareTo(data) < 1) {
           removeR(t.left(), data);
       }
   }
   public void preOrder() {
       preOrderR(this);
   }
   private void preOrderR(Tree t) {
       if (t == null)
           return;
       System.out.println(t.data());
       inOrderR(t.left());
       inOrderR(t.right());
   }
   
   public void inOrder() {
       inOrderR(this);
   }
   private void inOrderR(Tree t) {
       if (t == null)
           return;
       preOrderR(t.left());
       System.out.println(t.data());
       preOrderR(t.right());
   }
   public void postOrder() {
       postOrderR(this);
   }
   private void postOrderR(Tree t) {
       if (t == null)
           return;
       postOrderR(t.left());
       postOrderR(t.right());
       System.out.println(t.data());
   }
}
