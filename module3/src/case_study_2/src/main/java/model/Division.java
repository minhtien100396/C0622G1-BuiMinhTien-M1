package model;

public class Division {
    private int id;
    private int name;

    public Division(int id, int name) {
        this.id = id;
        this.name = name;
    }

    public Division() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
