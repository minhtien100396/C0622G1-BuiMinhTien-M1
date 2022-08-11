package ss9_array_list_linked_list.bai_tap.trien_khai_cac_phuong_thuc_cua_array_list.model;

import java.util.Arrays;

public class MyArrayList<E> {
    /**
     * Số lượng phần tử có trong MyArrayList
     */
    private int size = 0;

    /**
     * Sức chứa của MyaArrayList
     */
    private static int DEFAULT_CAPACITY = 10;

    /**
     * Mảng chứa các phần tử
     */
    public Object[] elements;

    /**
     * Sức chứa mặc định khi khởi tạo bằng Constructor không có tham số
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Phương thức Constructor với sức chứa được truyền vào
     *
     * @param capacity : độ lớn của mảng
     */
    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
    }

    /**
     * Phương thức trả về số lượng phần có trong mảng
     */
    public int size() {
        return this.size;
    }

    /**
     * Phương thức xóa toàn bộ phần tử trong mảng
     */
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    /**
     * Phương thức add 1 phần tử vào mảng
     *
     * @param element: đối tượng muốn thêm
     * @return
     */

    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }

    /**
     * Phương thức tăng kích thước của mảng
     *
     * @param minCapacity
     * @throws IllegalAccessException
     */
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("mindCapacity: " + minCapacity);
        }
    }

    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }

        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    /**
     * Phương thức lấy 1 element tại vị trí index
     *
     * @param index
     * @return
     */
    public E get(int index) {
        return (E) elements[index];
    }

    /**
     * Phương thức lấy index của 1 phần tử
     *
     * @param element
     * @return
     */
    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }

    /**
     * Phương thức kiểm tra 1 phần tử có trong mảng hay không
     *
     * @param element : phần tử cần kiểm tra
     * @return true : có, flase: không
     */
    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    /**
     * Phương thức tạo ra một bản sao của mảng hiện tại
     *
     * @return
     */
    public MyArrayList<E> clone() {
        MyArrayList<E> y = new MyArrayList<>();
        y.elements = Arrays.copyOf(elements, size);
        y.size = this.size;
        return y;
    }

    public E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("Error index " + index);
        }
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }
}
