package org.example;

public class Subject {
    private String midterm;
    private String endterm;
    private String total;
    private String fianll;

    public Subject(String midterm, String endterm, String finall, String total) {
        this.midterm = midterm;
        this.endterm = endterm;
        this.total = total;
        this.fianll = finall;
    }

    public Subject(String midterm, String endterm, String finall) {
        this.midterm = midterm;
        this.endterm = endterm;
        this.fianll = finall;
    }

    public String getMidterm() {
        return midterm;
    }

    public void setMidterm(String midterm) {
        this.midterm = midterm;
    }

    public String getFianll() {
        return fianll;
    }

    public void setFianll(String fianll) {
        this.fianll = fianll;
    }

    public String getEndterm() {
        return endterm;
    }

    public void setEndterm(String endterm) {
        this.endterm = endterm;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
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
