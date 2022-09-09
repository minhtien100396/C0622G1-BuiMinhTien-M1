package ss10_stack_and_queue.luyen_tap.demo_1.controller;

import ss10_stack_and_queue.luyen_tap.demo_1.model.Employee;
import ss10_stack_and_queue.luyen_tap.demo_1.model.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Trạng thái mặc định userList lưu Object
        ArrayList userList = new ArrayList();
        userList.add("Kiều Anh");
        userList.add(1);
        userList.add(new User());
        userList.add(new Employee());

//        for (Object arrayList:userList) {
//            if (arrayList instanceof User){
//                ((User) arrayList).m1();
//            }
//        }

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i) instanceof User) {
                ((User) userList.get(i)).m1();
            }
        }

        //Quy định List danh sách chỉ thuộc một loại kiểu dữ liệu

        ArrayList<User> arrayList = new ArrayList<>();
        //Khi compile thì đã được xác định kiểu dữ liệu
        //Quy định kiểu dữ liệu trong compile như một tham số
        arrayList.add(new User());

    }
}
