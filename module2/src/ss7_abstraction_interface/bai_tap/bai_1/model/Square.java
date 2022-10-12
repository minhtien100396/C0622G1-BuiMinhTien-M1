package ss7_abstraction_interface.bai_tap.bai_1.model;

public class Square extends Shape {
    private double edge = 1.0;

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public Square() {
    }

    public Square(double edge) {
        this.edge = edge;
    }

    public double getArea() {
        return this.edge * this.edge;
    }

    public void resize(double percent) {
        this.edge += this.edge * this.edge * percent / 100;
    }
}

