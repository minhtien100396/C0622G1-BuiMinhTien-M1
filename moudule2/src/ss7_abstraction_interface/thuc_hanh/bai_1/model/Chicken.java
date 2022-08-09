package ss7_abstraction_interface.thuc_hanh.bai_1.model;

public class Chicken extends Animal implements IEdible {
    @Override
    public String makeSound() {
        return "Chicken cluck-click";
    }

    @Override
    public String howtoEat() {
        return "Ăn thóc";
    }
}
