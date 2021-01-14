package ngay_9_danh_sach.bai_tap.ArrayList;

import java.util.Arrays;

public class ArrayListLibrary<E> {
    private int size = 0; // so luong phan tu co trong mang
    private static final int DEFAULT_CAPACITY = 10; // suc chua toi da cua mang
    Object elements[];

    public ArrayListLibrary() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public ArrayListLibrary(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];  // constructor voi suc chua duoc truyen vao
        } else {
            throw new IndexOutOfBoundsException("capacity: " + capacity);
        }
    }
    public int size() { // so luong phan tu co trong mang
        return this.size;
    }
    public void clear() { // xoa het phan tu co trong mang
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }
    public boolean add(E element) { // them 1 phan tu vao mang
        if (elements.length == size) { // neu do dai cua mang da dat den max thif dung pt de tang len
            this.ensureCapacity(5); // tang kich thuoc len 5 don vi
        }
        elements[size] = element;
        size++;
        return true;
    }
    public void ensureCapacity(int minCapacity) { // tang kich thuoc cua mang
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements =  Arrays.copyOf(elements, newSize);
        } else {
            throw new IndexOutOfBoundsException("minCapacity" + minCapacity);
        }
    }
    public void add(E element, int index) { // them 1 phan tu vao mot vi tri dc chi dinh
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }
        if (elements[index] == null) {
            elements[index] = element;
        } else {
            for (int i = index + 1; i >= index; i--) { // duyet tu cuoi mang den vi tri index can them phan tu
                elements[i] = elements[i - 1];    // dich phan tu thu i qua vi tri i - 1
                size++;
            }
        }
    }
    public E get(int index) { // lay 1 element tai vi tri index
        return (E) elements[index];
    }
    public int indexOf(E element) { // trich xuat ra vi tri cua phan tu muon tim
        int index = -1; // -1 nghia la khong tim thay
        for (int i = 0; i < size; i++ ) {
            if (this.elements[i] == element) {
                return i;
            }
        }
        return index;
    }
    public boolean contain(E element) { // kiem tra xem phan tu co ton tai trong mang hay khong?
        return this.indexOf(element) >= 0; // nghia la no ton tai trong mang
    }
    public ArrayListLibrary<E> clone() { // sao chep ra mot mang khac
        ArrayListLibrary<E> list = new ArrayListLibrary<>();
        list.elements = Arrays.copyOf(this.elements, this.size); // copy phan tu vao mang moi
        list.size = this.size;                                   // copy size cua mang cu vao amng moi
        return list;
    }
    public E remove(int index) { // xoa phan tu ra khoi mang
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("Error index: " + index);
        }
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) { // day phan tu ben phai qua trai 1 don vi
            elements[i] = elements[i+1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }
}
