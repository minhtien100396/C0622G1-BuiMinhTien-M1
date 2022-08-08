package ss3_mang_va_phuong_thuc_trong_java.luyen_tap.demo;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Tiến");
        System.out.println(student.getName());
        thayDoiTen1(student);
        System.out.println(student.getName());
    }

    public static void thayDoiTen(Student student1) {
        student1.setName("Bia");
    }

    public static void thayDoiTen1(Student student1) {
        Student newStuden = new Student("Bia");
        student1 = newStuden;
        System.out.println(student1.getName());

    }
    /*
    Khi ta truyền tham chiếu là studen1 thuộc đối tượng Studen thì nó sẽ tạo ra địa chỉ lưu biến
    đối tượng studen1 trên vùng nhớ Stack và nó có địa chỉ ô nhớ gia trị của student lưu trên vùng
    nhớ Heap. Khi ta thay đổi giá trị trên vùng nhớ Heap thì thằng giá trị trên ô nhớ Heap của tk studen
    cũng bị thay đổi theo. Do cùng trỏ tới cùng địa chỉ ô nhớ chứa giá trị.
    Như vậy nó làm thay đổi giá trị ban đầu => tham chiếu
    Nhưng trong Java chỉ truyền tham trị vì sao?

    Bản chất khi studen1 được tạo ra thì nó sẽ tạo ra một địa chỉ mới lưu trên Stack và địa chi của ô
    nhớ giá trị sẽ giống với tk student => địa chỉ thuộc tính chứa giá trị của nó phải giống nhau.
    Khi chúng ta thay đổi giá trị trên ô nhó Heap=> giá trị của ô nhớ sẽ thay đổi, nhưng địa chỉ của ô nhớ
    chứa thuộc tính sẽ không thay đổi. Nên trong java chỉ truyền tham trị.

    */
}
