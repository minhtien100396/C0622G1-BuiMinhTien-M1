package demoTReeSet;

import java.util.Objects;

public class A implements Comparable{
    private String id;
    private int age;
    private String name;

    public A() {
    }

    public A(String id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
         o = (A)o;
        return this.getId().compareTo(((A) o).getId());
    }
        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return id.equals(a.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
