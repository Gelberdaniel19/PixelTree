package com.gelber.pixeltree._Model;

public class CreditCard {
    private String num;
    private int expm;
    private int expy;
    private int cvv;

    public CreditCard(String num, int expm, int expy, int cvv) {
        this.num = num;
        this.expm = expm;
        this.expy = expy;
        this.cvv = cvv;
    }

    public CreditCard() {
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getExpm() {
        return expm;
    }

    public void setExpm(int expm) {
        this.expm = expm;
    }

    public int getExpy() {
        return expy;
    }

    public void setExpy(int expy) {
        this.expy = expy;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
