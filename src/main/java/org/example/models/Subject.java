package org.example.models;

import lombok.*;
@Getter
@Setter
public class Subject {
    private int midterm;
    private int endterm;
    private int total;
    private int fianll;

    public Subject(int midterm, int endterm, int finall, int total) {
        this.midterm = midterm;
        this.endterm = endterm;
        this.total = total;
        this.fianll = finall;
    }

    public Subject(int midterm, int endterm, int finall) {
        this.midterm = midterm;
        this.endterm = endterm;
        this.fianll = finall;
    }

    public int getMidterm() {
        return midterm;
    }

    public void setMidterm(int midterm) {
        this.midterm = midterm;
    }

    public int getFianll() {
        return fianll;
    }

    public void setFianll(int fianll) {
        this.fianll = fianll;
    }

    public int getEndterm() {
        return endterm;
    }

    public void setEndterm(int endterm) {
        this.endterm = endterm;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Grades: "+
                "Register Midterm = " + midterm  +
                ",Register Endterm = " + endterm  +
                ",Register Final = " + fianll  +
                ", Register Total = " + total + "\n"
                ;
    }

}
