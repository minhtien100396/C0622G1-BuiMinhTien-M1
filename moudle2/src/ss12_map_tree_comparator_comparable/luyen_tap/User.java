package ss12_map_tree_comparator_comparable.luyen_tap;

public class User implements Comparable<User> {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(User o) {
        if (this.id>o.id) return 1;
        if (this.id<o.id) return -1;
        return 0;
    }
}
