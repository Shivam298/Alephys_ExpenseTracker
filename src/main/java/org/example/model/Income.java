package org.example.model;

public class Income {
    private String type,month;
    private int year,amount;
    public Income(){
    }

    public Income(String type, String month, int year, int amount) {
        this.type = type;
        this.month = month;
        this.year = year;
        this.amount = amount;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Income {" +
                "type='" + type + '\'' +
                ", month='" + month + '\'' +
                ", year=" + year +
                ", amount=" + amount +
                '}';
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
