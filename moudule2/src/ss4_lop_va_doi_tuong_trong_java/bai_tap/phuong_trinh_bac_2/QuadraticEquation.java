package ss4_lop_va_doi_tuong_trong_java.bai_tap.phuong_trinh_bac_2;

import java.util.Scanner;

public class QuadraticEquation {
    double a;
    double b;
    double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {

        return Math.pow(this.b, 2) - 4 * this.a * this.c;
    }

    public double getGetRoot1() {

        return  (-this.b + Math.sqrt(this.getDiscriminant())) / (2 * this.a);
    }

    public double getGetRoot2() {

        return  (-this.b - Math.sqrt(this.getDiscriminant())) / (2 * this.a);
    }


}

