package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Expense;
import org.example.model.Income;
import org.example.model.Transactions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExpenseTracker {

    public static void monthlySummary (Transactions transactions) {

        System.out.println("Monthly expense grouped by each month");
        Map<String, List<Expense>> grouped = transactions.getExpense().stream()
                .collect(Collectors.groupingBy(expense -> expense.getMonth()));
        for (Map.Entry<String, List<Expense>> entry : grouped.entrySet()) {
            System.out.println("Month: " + entry.getKey());
            entry.getValue().forEach((expense -> {
                System.out.println("Expense: Type: "+expense.getType()+" Year:"+expense.getYear()+" Amount:"+expense.getAmount());
            }));
            System.out.println();
        }

        System.out.println("Monthly Income grouped by each month");
        Map<String, List<Income>> grouped1 = transactions.getIncome().stream()
                .collect(Collectors.groupingBy(income -> income.getMonth()));
        for (Map.Entry<String, List<Income>> entry : grouped1.entrySet()) {
            System.out.println("Month: " + entry.getKey());
            entry.getValue().forEach((income -> {
                System.out.println("Income: Type: "+income.getType()+" Year: "+income.getYear()+" Amount: "+income.getAmount());
            }));
            System.out.println();
        }

        }


    public static void main(String[] args) throws IOException {
        String filePath="/home/shku275347/Documents/Alephys/ExpenseTracker/src/main/resources";
        ObjectMapper mapper = new ObjectMapper();
        Transactions transactions = new Transactions();
        Scanner in = new Scanner(System.in);
        int ch = -1;
        while (ch != 4) {
            System.out.println("Enter 1 for Expense, 2 for Income, 3 for input via file, 4 for Exit");
            ch = in.nextInt();
            in.nextLine();
            if(ch != 3){
                transactions = mapper.readValue(new File(filePath + "/test.json"), Transactions.class);
            }
            switch (ch) {
                case 1: {
                    String type, month;
                    int amount, year;
                    System.out.println("Enter Type (Food/Rent/Travel)");
                    type = in.nextLine();
                    System.out.println("Enter Month");
                    month = in.nextLine();
                    System.out.println("Enter Amount");
                    amount = in.nextInt();
                    System.out.println("Enter Year");
                    year = in.nextInt();
                    Expense expense = new Expense(type, month, year, amount);
                    transactions.getExpense().add(expense);
                    mapper.writeValue(new File(filePath + "/test.json"), transactions);
                    transactions = mapper.readValue(new File(filePath + "/test.json"), Transactions.class);
                    monthlySummary(transactions);
                    break;
                }
                case 2: {
                    String type, month;
                    int amount, year;
                    System.out.println("Enter Type (Salary/Business)");
                    type = in.nextLine();
                    System.out.println("Enter Month");
                    month = in.nextLine();
                    System.out.println("Enter Amount");
                    amount = in.nextInt();
                    System.out.println("Enter Year");
                    year = in.nextInt();
                    Income income = new Income(type, month, year, amount);
                    transactions.getIncome().add(income);
                    mapper.writeValue(new File(filePath + "/test.json"), transactions);
                    transactions = mapper.readValue(new File(filePath + "/test.json"), Transactions.class);
                    monthlySummary(transactions);
                    break;
                }

                case 3: {
                    transactions = mapper.readValue(new File(filePath + "/file_input.json"), Transactions.class);
                    mapper.writeValue(new File(filePath + "/test.json"), transactions);
                    monthlySummary(transactions);
                    break;
                }

                case 4: {
                    break;
                }

                default: {
                    System.out.println("Enter valid input");
                }
            }
        }
    }
}
