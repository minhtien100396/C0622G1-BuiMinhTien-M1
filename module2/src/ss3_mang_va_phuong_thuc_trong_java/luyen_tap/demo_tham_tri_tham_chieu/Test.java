package ss3_mang_va_phuong_thuc_trong_java.luyen_tap.demo_tham_tri_tham_chieu;

public class Test {
    public static void main(String[] args) {

//        //Truyền tham trị
//
//        Student student = new Student("Tiến", 26);
//        //Khi sử dụng toán tử new thì chúng ta đã tạo ra kiểu dữ liệu tham chiếu
//        //Biến đối tượng student lúc này sẽ tham chiếu vào địa chỉ ô nhớ của name và age;
//        //student sẽ lưu vào stack và giá trị của nó sẽ lưu ở Heap
//        System.out.println(student.toString());
//        thayDoiTuoi(student.age);
//        //Khí chúng ta truyền 10 vào tham số thì sẽ có một biến age được tạo ra nằm ở vùng nhớ Stack
//        // có cùng giá trị với thằng student.age là 10, và nó được sử dung cho toàn bộ hàm thayDoiTuoi
//        //vì thằng age này là kiểu tham trị nên giá trị của nó chỉ thay đổi trong vùng Stacck
//        //nhưng giá trị của thằng student.age lại lưu ở vùng nhớ Heap
//        //Do đó thuộc tính age của đối tượng student không thay đổi
//        System.out.println(student.toString());


        //Truyền tham chiếu

        Student student = new Student("Tiến", 26);
        //Khi sử dụng toán tử new thì chúng ta đã tạo ra kiểu dữ liệu tham chiếu
        //Biến đối tượng student lúc này sẽ tham chiếu vào địa chỉ ô nhớ của name và age là thuộc tính của student;
        //student sẽ lưu vào stack và giá trị của nó sẽ lưu ở Heap
        System.out.println(student.toString());
        thayDoiTuoi(student,20);
        //Khí chúng ta truyền đối tượng student vào tham số thì sẽ có một biến đối tượng studen1
        // được tạo ra nằm ở vùng nhớ Stack
        // có cùng địa chỉ ô nhớ giá trị của student tại vùng nhớ Heap (cung trỏ tới cùng địa chỉ
        // ô giá trị nằm trong vùng Heap)
        // và nó được sử dung cho toàn bộ hàm thayDoiTuoi
        //vì thằng studen1 này là kiểu tham chiếu nên giá trị của nó thay đổi thì làm cho giá trị thằng
        //studen thay đổi theo do cùng trỏ tới địa chỉ giá trị giống nhau nằm trong Heap
        System.out.println(student.toString());
    }
    //Truyền tham trị
    public static void thayDoiTuoi(int age){
        age++;
        System.out.println("age = "+age);
    }

    //Truyền tham chiếu

    //Truyền đối số là 1 class có đối tượng là studen1
    public static void  thayDoiTuoi(Student student1){
        student1.age++;
    }

    //Thay đổi age trên Heap nhưng truyền age vào trong tham số
    public static void thayDoiTuoi(Student student1, int newAge){
        Student student2 = new Student(student1.name,newAge);
        student1=student2;
    }

}
