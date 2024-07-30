package com.AddNumeric.AddNumericString;

import java.util.ArrayList;
import java.util.List;

public class AddNumericString {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n"; 
        String numberString = numbers;

        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf('\n'); 
            delimiter = numbers.substring(2, delimiterIndex); 
            numberString = numbers.substring(delimiterIndex + 1); 
        }


        String[] numberArray = numberString.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;

        for (String num : numberArray) {
            if (!num.trim().isEmpty()) { 
                int number = Integer.parseInt(num.trim());
                if (number < 0) {
                    negativeNumbers.add(number);
                } else {
                    sum += number;
                }
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
        }

        return sum;
    }

    public static void main(String[] args) {
        AddNumericString ans = new AddNumericString();
        System.out.println(ans.add("//;\n1;2;3")); 
    }
}
