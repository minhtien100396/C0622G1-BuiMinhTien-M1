package ss4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_fan;

public class Fan {
    //tạo các thuộc tính cho lớp Fan
    final int SLOW = 1;
    private int speed = SLOW;
    private boolean status = false;
    private double radius = 5.0;
    private String color = "blue";


    //getter

    public int getSpeed() {
        return this.speed;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void isOff() {
        this.status = false;
    }

    public void isOn() {
        this.status = true;
    }

    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    //setter

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //constructor mặc định
    public Fan() {
    }

    //phương thức toString()

    public void display() {
        if (this.getStatus()) {
            if (this.speed < 1 || this.speed > 3) {
                System.out.println("Tốc độ quạt chỉ từ 1 đến 3. Hãy nhập lại");
            } else {
                System.out.println("Tốc độ quạt = " + this.speed + "\n" + "Màu quạt : " + this.color + "\n" + "Bán kính quạt = " + this.radius + "\n" + "Quạt đang bật");
            }
        } else {
            System.out.println("Màu quạt : " + this.color + "\n" + "Bán kính quạt = " + this.radius + "\n" + "Quạt đang tắt");
        }
    }
}
