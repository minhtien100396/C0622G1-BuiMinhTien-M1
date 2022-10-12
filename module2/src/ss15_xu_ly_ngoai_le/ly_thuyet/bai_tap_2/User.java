package ss15_xu_ly_ngoai_le.ly_thuyet.bai_tap_2;

public class User {
    String tinNhan;
    int age;

    public User(String tinNhan,int age) {
        this.tinNhan = tinNhan;
        this.age = age;
    }

    public String getTinNhan() {
        return tinNhan;
    }

    public int getAge() {
        return age;
    }
    public void m1(int age)   {
        System.out.println("a");
    }

}
