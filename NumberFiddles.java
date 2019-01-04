package com.blaney83;

public class Main {

    public static void main(String[] args) {
        int myNumber = 0;
        while(myNumber != 5){
            System.out.println(myNumber);
            myNumber++;
        }
        int count = 0;
        while(true){
            if(count ==5){
                break;
            }
            System.out.println(count);
            count ++;
        }
        int doCount = 0;
        do {
            System.out.println(doCount);
            doCount++;
        }while(doCount < 10);

        //do while
        int evenCount = 1;
        do{
            System.out.println(String.valueOf(evenCount) + isEvenNumber(evenCount));
            evenCount++;
        }while(evenCount < 15);
        //while w/ continue
        evenCount = 1;
        while(evenCount < 5){
            evenCount++;
            if(!isEvenNumber(evenCount)){
                continue;
            }
            System.out.println("this number is even" + evenCount);
        }
        //sum numbers
        System.out.println(sumDigits(123));
        System.out.println(sumDigits(901));
        //palindrome
        System.out.println(checkPalindrome(121));
        //has shared digit
        System.out.println(hasSharedDigit(11,32));
        System.out.println(hasSharedDigit(9,39));
        System.out.println(hasSharedDigit(74,44));
        //greatest common denominator
        System.out.println(greatestCommonDenominator(81, 63));
        //perfect number
        System.out.println(perfectNumberCalculator(6));
        System.out.println(perfectNumberCalculator(28));
    }

    public static boolean isEvenNumber(int number){
        if(number % 2 == 0){
            return  true;
        }else{
            return false;
        }
    }

    public static int sumDigits (int number){
        if(number < 10){
            return -1;
        }
        int sum = 0;
        while(number > 0 ){
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        return sum;

        //less efficient solution vvvvvvvv
//        int smallDig = number % 10;
//        int bigDig = number /10;
//        int thirdDig = 0;
//        if(bigDig >= 10){
//            thirdDig = bigDig / 10;
//            bigDig = bigDig % 10;
//        }
//        return(smallDig + bigDig + thirdDig);
    }

    //palindrome
    public static boolean checkPalindrome (int number){
        String revNum = "";
        int initialNum = number;
        while(number > 0){
            int digit = number % 10;
            number = number /10;
            revNum = revNum + digit;
//            System.out.println(number);
        }
        boolean isPalindrome = true;
        int reversedInt = Integer.parseInt(revNum);
        System.out.println(reversedInt);
        System.out.println(initialNum);
        while (initialNum > 0){
            int forwardsDigit = initialNum % 10;
            int backwardsDigit = reversedInt % 10;
            if(forwardsDigit != backwardsDigit){
                isPalindrome = false;
            }
//            System.out.println(initialNum);
            initialNum = initialNum /10;
            reversedInt = reversedInt / 10;
        }
        return isPalindrome;
    }

    public static boolean hasSharedDigit(int digit1, int digit2){
        if(digit1 < 10 || digit1 > 99 || digit2 < 10 || digit2 > 99){
            System.out.println("Invalid values. Choose range 10-99");
            return false;
        }
        boolean hasShared = false;
        int dig1of1 = digit1 /10;
        int dig2of1 = digit1 % 10;
        int dig1of2 = digit2 / 10;
        int dig2of2 = digit2 % 10;
        if(dig1of1 == dig1of2 || dig1of1 == dig2of2 || dig2of1 == dig1of2 || dig2of1 == dig2of2){
            hasShared = true;
        }
        return hasShared;
    }

    public static int greatestCommonDenominator(int dig1, int dig2){
        if(dig1 < 10 || dig2 < 10){
            return -1;
        }
        int digFactor = 1;
        int maxValue = dig1;
        if(dig1 > dig2){
            maxValue = dig2;
        }
        int origCount = 1;
        while(origCount < maxValue + 1){
            if(dig1 % origCount == 0 && dig2 % origCount == 0){
                digFactor = origCount;
            }
            origCount ++;
        }
        return digFactor;
    }

    public static boolean perfectNumberCalculator(int number){
        if(number < 0){
            System.out.println("Invalid values. Choose range 10-99");
            return false;
        }
        int originalNumber = number;
        int sum = 0;
        while(number > 0){
            sum += number % 10;
            number /= 10;
        }
        if (sum == originalNumber){
            return true;
        }else{
            return false;
        }
    }
}
