package ss10_stack_and_queue.luyen_tap.demo_1.controller;

import ss10_stack_and_queue.luyen_tap.demo_1.model.Employee;
import ss10_stack_and_queue.luyen_tap.demo_1.model.User;

public class ManagerGeneric<N> {
    public void addNewElement(N o){
    }

    public static void main(String[] args) {
        ManagerGeneric<User> managerGeneric = new ManagerGeneric();
        managerGeneric.addNewElement(new User());
    }
}
