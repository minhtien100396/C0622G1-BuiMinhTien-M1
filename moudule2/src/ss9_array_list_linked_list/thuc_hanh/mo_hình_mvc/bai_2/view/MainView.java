package ss9_array_list_linked_list.thuc_hanh.mo_hình_mvc.bai_2.view;

import ss9_array_list_linked_list.thuc_hanh.mo_hình_mvc.bai_2.controller.StudentController;

public class MainView {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        studentController.menuManagement();
    }
}
