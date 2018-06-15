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
public class Heap {
    Comparable[] heap_;
    int size_;
    Heap() {
    }
    Heap(Comparable[] arr) {
        Heapify(arr);
    }
    
    public void add(Comparable c) {
        if (size_ == heap_.length) {
            heap_ = copy(1, heap_, expand(heap_)); 
        }
        else {
           heap_ =  moveDown(heap_);
        }
        heap_[0] = c;
        size_++;
        siftDown(0, size_, heap_);
    }
    
    /*
     * copies arr1 into arr2 with a given offset
     * Condition: arr1.length + offset <= arr2
     */
    private Comparable[] moveDown(Comparable[] c) {
        for (int i = size_ - 1; i >= 0; i--) {
            c[i + 1] = c[i];
        }
        return c;
    }
    private Comparable[] copy(int offset, Comparable[] arr1,Comparable[] arr2) {
        System.arraycopy(arr1, 0, arr2, offset, arr1.length);
        return arr2;
    }
    private Comparable[] expand( Comparable[] arr ) {
        int newSize = arr.length * 2;
        Comparable[] newArr = new Comparable[newSize];
        return newArr;
    }
    public int size() {
        return size_;
    }
    public int capacity() {
        return heap_.length;
    }
    public Comparable top() {
        return heap_[0];
    }
    
    public Comparable pop() {
        Comparable data = heap_[0];
        heap_[0] = heap_[size_ - 1];
        heap_[size_ - 1] = 0;
        size_--;
        siftDown(0, size_, heap_);
        return data;
    }
    private void Heapify(Comparable[] arr) {
        int end = arr.length - 1;
        int i = end;
        while (i >= 0) {       
            arr = siftDown(i, end, arr);
            i--;
        }
        size_ = arr.length;
        heap_ = arr;
        
    }
    
    private Comparable[] siftDown(int start, int end, Comparable[] arr) {
        int root = start;
        while ((2 * root + 1) <= end) {
            int child = 2 * root + 1;
            if (child + 1 <= end && arr[child].compareTo(arr[child + 1]) < 0) {
                child = child + 1;
            }
            
            if (arr[root].compareTo(arr[child]) < 0) {
                Comparable temp = arr[root];
                arr[root] = arr[child];
                arr[child] = temp;
                root = child;
            }
            else {
                return arr;
            }
        }
        return arr;
    }
    
    public void print() {
        for (int i = 0; i < size_; i++) {
            System.out.print(heap_[i] + " ");
        }
        System.out.println();
    }
}
