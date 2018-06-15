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
   private Tree parent_ = null;
   private Tree left_ = null;
   private Tree right_ = null;
   private int family_ = 0; // number of trees below the depth of this one

   private Comparable data_ = null;
   public Tree() {
   }
   public Tree(Comparable data) {
       data_ = data;
       family_ = 1;
       right_ = null;
       left_ = null;

   }
   public Tree(Comparable data, Tree parent) {
       data_ = data;
       family_ = 1;
       parent_ = parent;
       right_ = null;
       left_ = null;
       
   }
   public Tree parent() {
       return parent_;
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
   public int size() {
       return family_;
   }
   
   public void setParent(Tree parent) {
       parent_ = parent;
   }
    public void setLeft(Tree left) {
      left_ = left;
   }
   public void setRight(Tree right) {
      right_ = right;
   }
   
 
   public void setData(Comparable data) {
       data_ = data;
   }
   public void add(Comparable data) {
       if (data_ == null) {
           data_ = data;
           family_++;
           return;
       }
       
       addR(this, data);
   }
   
   private void addR(Tree t, Comparable data) {
       if (t.right() == null && data.compareTo(t.data()) > 0) {
           t.setRight(new Tree(data, t));
           family_++;
           return;
       }
       else if  (t.left() == null && data.compareTo(t.data()) < 0) {
             t.setLeft(new Tree(data, t));
             family_++;
           return;
       }           
       else if (data.compareTo(t.data()) > 0) {
           addR(t.right(), data);
       }
       else if (data.compareTo(t.data()) < 0) {
           addR(t.left(), data);
       }    
   }
   private void delete(Tree t) {
       if (t.parent().data().compareTo(t.data()) < 1) {
                   t.parent().setRight(null);
               }
       else { // We know that parent's data cannot equal child's data 
              t.parent().setLeft(null);
        }
   }
   public void remove(Comparable data) {
       Tree t = find(data); // to remove
       if (t == null) {
           return;
       }
       if (t.left() == null && t.right() == null) {
           if (t.parent() != null) {
               delete(t);
               family_--;
           }
           else {
               // t must be the root tree with no children
               t.setData(null);
           }
       }
       if (t.right() != null) {          
           Tree r = findMin(t.right());
           t.setData(r.data());
           delete(r);
           family_--;
       }
       else if (t.left() != null) {
           t = t.left();
       }
   }
   public Tree findMin(Tree t) {
       if (t.left() == null) 
           return t;
       else {
           return findMin(t.left());
       }
   }
   public Tree find(Comparable toFind) {
       return findR(this, toFind);
   }
   private Tree findR(Tree t, Comparable toFind) {
       if (t == null) 
           return null;
       if (t.data().compareTo(toFind) > 0) {
           return findR(t.left(), toFind);
       }
       else if (t.data().compareTo(toFind) < 0) {
           return findR(t.right(), toFind);
       }
       else {
           return t;
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
   
   /*
    * Rebalance
   */
}
