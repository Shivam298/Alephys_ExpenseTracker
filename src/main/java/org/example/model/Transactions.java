package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Transactions {
    private List<Income> income;
    private List<Expense> expense;
    public Transactions(){
        income = new ArrayList<>();
        expense = new ArrayList<>();
    }

    public Transactions(List<Income> income, List<Expense> expense) {
        this.income = income;
        this.expense = expense;
    }

    public List<Income> getIncome() {
        return income;
    }

    public void setIncome(List<Income> income) {
        this.income = income;
    }

    public List<Expense> getExpense() {
        return expense;
    }

    public void setExpense(List<Expense> expense) {
        this.expense = expense;
    }
}
