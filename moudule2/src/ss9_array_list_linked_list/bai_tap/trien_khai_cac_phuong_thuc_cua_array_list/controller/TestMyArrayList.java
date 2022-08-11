package ss9_array_list_linked_list.bai_tap.trien_khai_cac_phuong_thuc_cua_array_list.controller;

import ss9_array_list_linked_list.bai_tap.trien_khai_cac_phuong_thuc_cua_array_list.model.MyArrayList;

public class TestMyArrayList {
    static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student a = new Student(1, "Tiến");
        Student b = new Student(2, "Bình");
        Student c = new Student(3, "Huy");
        Student d = new Student(4, "Trường");
        Student e = new Student(5, "Sáng");
        Student f = new Student(6, "Dũng");
        Student k = new Student(6, "Dũng");

        MyArrayList<Student> myArrayList = new MyArrayList<>();
        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();
        studentMyArrayList.add(a);
        studentMyArrayList.add(b);
        studentMyArrayList.add(c);
        studentMyArrayList.add(d);
        studentMyArrayList.add(e);
        studentMyArrayList.add(f, 2);
        studentMyArrayList.size();
        System.out.println(studentMyArrayList.size());
        System.out.println(studentMyArrayList.get(2).getName());
        System.out.println(studentMyArrayList.indexOf(f));
        System.out.println(studentMyArrayList.indexOf(k));
        System.out.println(studentMyArrayList.contains(a));
        System.out.println(studentMyArrayList.contains(k));
        myArrayList = studentMyArrayList.clone();
        myArrayList.remove(1);
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i).getName());
        }
    }
}
