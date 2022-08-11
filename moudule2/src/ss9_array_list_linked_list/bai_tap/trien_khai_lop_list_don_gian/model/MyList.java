package ss9_array_list_linked_list.bai_tap.trien_khai_lop_list_don_gian.model;

import java.util.Arrays;

public class MyList<E> {
    /**
     * Số lượng phần tử trong MyList
     */
    private int size;

    /**
     * Sức chứa của MyList
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Mảng chứa các phần tử
     */
    Object[] elements;

    public MyList() {
        /**
         * Sức chứa mặc định khi khởi tạo bằng Constructor không có tham số
         */
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Tăng gấp đôi kích thước mảng chứa các phần tử
     */
    public void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    /**
     * Cài đặt phương thức add()
     * Mục đích: thêm một phần tử vào cuối của danh sách
     * Tham số đầu vào: phần tử cần thêm vào danh sách
     */

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    /**
     * Phương thức get() trả về phần tử vừa ở vị trí thứ i trong danh sách.
     *
     * @param i: số nguyên chứa vị trí cần truy cập đến phần tử trong danh sách
     * @return
     */
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }


}
