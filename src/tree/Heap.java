/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author a.efemwonkieke
 * @param <E>
 */
public class Heap<E extends Comparable<E>> {
    Heap left_;
    Heap right_;
    E data_;
    Heap() {
    }
    Heap(E[] arr) {
        Heapify(arr);
    }
    Heap left() {
        return left_;
    }
    Heap right() {
        return right_;
    }
    E data() {
        return data_;
    }
    void setLeft(Heap left) {
        left_ = left;
    }
    void setRight(Heap right) {
        right_ = right;
    }
    void setData(E data) {
        data_ = data;
    }
    void Heapify(E[] arr) {
        
    }
}
