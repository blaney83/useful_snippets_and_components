package com.blaney83;

public class Main {

    public static void main(String[] args) {
        int numberCheck = 2;
        for(int i = 0; i < 1000; ){
            if(isPrime(numberCheck)){
                System.out.println(numberCheck);
                i++;
            }
            numberCheck++;
        }

    }

    public static boolean isPrime(int n){
        if(n == 1){
            return false;
        }
        for(int i =2; i<= n/2; i++){
            if(n % i ==0 ){
                return false;
            }
        }
        return true;
    }
}
