package ss10_stack_and_queue.luyen_tap.demo_1.model;

public class Manager {
    public void addNewElement(Object o){
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addNewElement(new User());
        manager.addNewElement(new Employee());
    }
}
