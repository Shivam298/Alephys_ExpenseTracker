package org.example.model;

public class Expense {
    private String type,month;
    private int amount,year;

    public Expense(){
    }

    @Override
    public String toString() {
        return "Expense {" +
                "type='" + type + '\'' +
                ", month='" + month + '\'' +
                ", amount=" + amount +
                ", year=" + year +
                '}';
    }

    public Expense(String type, String month, int year, int amount) {
        this.type = type;
        this.month = month;
        this.amount = amount;
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
