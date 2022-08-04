package ss4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_fan;

public class Main {
    public static void main(String[] args) {
        //Tạo 2 đối tượng Fan
        //Đối tượng Fan 1: Gán giá trị lớn nhất cho speed, radius là 10, color là yellow và quạt ở trạng thái bật.
        //Đối tượng Fan 2: Gán giá trị trung bình cho speed, radius là 5, color là blue và quạt ở trạng thái tắt
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        //Thuộc tính của fan1
        System.out.println("Đối tượng Fan1:");
        fan1.setColor("Yellow");
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.isOn();
        fan1.display();
        //Thuộc tính fan2
        System.out.println();

        System.out.println("Đối tượng Fan2:");
        fan2.setSpeed(2);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.display();
    }
}
