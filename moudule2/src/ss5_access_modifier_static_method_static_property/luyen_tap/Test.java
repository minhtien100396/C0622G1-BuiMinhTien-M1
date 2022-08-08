package ss5_access_modifier_static_method_static_property.luyen_tap;

public class Test {
    private boolean isMale;
    private String name;
    private int age;

    public void isMale(boolean male) {
        isMale = male;
    }

    public boolean getIsMale() {
         return this.isMale;
    }



    public String getName(){
        return this.name=name;
    }
    public int getAge(){
        return this.age;
    }
    public void setName(String name){
         this.name=name;
    }
    public void setAge(int age){
         this.age=age;
    }
    public Test(){
    }

}
