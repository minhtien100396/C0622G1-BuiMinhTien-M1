package ss10_stack_and_queue.luyen_tap.demo_1.model;

public class ManagerGeneric<N> {
    public void addNewElement(N o){
    }

    public static void main(String[] args) {
        ManagerGeneric<User> managerGeneric= new ManagerGeneric<>();
        managerGeneric.addNewElement(new User());
        managerGeneric.addNewElement(new User());
    }
}
