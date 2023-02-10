package com.eric.todolist.leetCode;

import java.util.LinkedHashMap;

/**
 * FileName:romanToInteger
 *
 * @author Eric
 * @date 2023/2/3下午 04:55
 */
public class romanToInteger {
    public int romanToInt(String s) {
        int ansNum = 0;
        String romanStr = "";
        LinkedHashMap<String, Integer> romanCorRespond = new LinkedHashMap<>();
        romanCorRespond.put("I", 1);
        romanCorRespond.put("V", 5);
        romanCorRespond.put("X", 10);
        romanCorRespond.put("L", 50);
        romanCorRespond.put("C", 100);
        romanCorRespond.put("D", 500);
        romanCorRespond.put("M", 1000);

        char[] charArray = s.toCharArray();
//        System.out.println("charArray.length =" + charArray.length);
        for (int index = charArray.length - 1; index >= 0; index--) {
            if (index == charArray.length - 1 || romanCorRespond.get(String.valueOf(charArray[index])) >= romanCorRespond.get(String.valueOf(charArray[index + 1]))) {
//                System.out.println("index=" + index + " ,> index-1");
                ansNum += romanCorRespond.get(String.valueOf(charArray[index]));
            } else if (romanCorRespond.get(String.valueOf(charArray[index])) < romanCorRespond.get(String.valueOf(charArray[index + 1]))) {
//                System.out.println("index=" + index + " ,<= index-1");
                ansNum -= romanCorRespond.get(String.valueOf(charArray[index]));
            }
        }
        return ansNum;
    }

    static int getValue(String ch) {
        switch (ch) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt2(String s) {
        int ansNum = 0;
        String romanStr = "";

        char[] charArray = s.toCharArray();
//        System.out.println("charArray.length =" + charArray.length);
        for (int index = charArray.length - 1; index >= 0; index--) {
            if (index == charArray.length - 1 || getValue(String.valueOf(charArray[index])) >= getValue(String.valueOf(charArray[index + 1]))) {
//                System.out.println("index=" + index + " ,> index-1");
                ansNum += getValue(String.valueOf(charArray[index]));
            } else if (getValue(String.valueOf(charArray[index])) < getValue(String.valueOf(charArray[index + 1]))) {
//                System.out.println("index=" + index + " ,<= index-1");
                ansNum -= getValue(String.valueOf(charArray[index]));
            }
        }
        return ansNum;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
