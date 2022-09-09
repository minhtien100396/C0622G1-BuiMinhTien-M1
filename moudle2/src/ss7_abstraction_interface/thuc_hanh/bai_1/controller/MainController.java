package ss7_abstraction_interface.thuc_hanh.bai_1.controller;

import ss7_abstraction_interface.thuc_hanh.bai_1.model.*;

public class MainController {
    public static void main(String[] args) {
        Animal[] animal = new Animal[2];
        animal[0] = new Tiger();
        animal[1] = new Chicken();
        for (Animal elements : animal) {
            System.out.println(elements.makeSound());

            if (elements instanceof Chicken) {
                IEdible iEdible = (Chicken) elements;
                System.out.println(iEdible.howtoEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Apple();
        fruits[1] = new Orange();
        for (Fruit elements : fruits) {
            System.out.println(elements.howtoEat());
        }
    }
}
