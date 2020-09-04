package com.sg;

import com.sg.stacks.Stacks;

public class Main {

    public static void main(String[] args) {

         final String STACK_TEST_CASE_1= "(){}[]";
         final String STACK_TEST_CASE_2= "(){}[";
         final String STACK_TEST_CASE_3= "[[{}]()]";

        // write your code here
        Stacks stacks = new Stacks();

        System.out.println(stacks.challengeMatchStrings(STACK_TEST_CASE_1));
        System.out.println(stacks.challengeMatchStrings(STACK_TEST_CASE_2));
        System.out.println(stacks.challengeMatchStrings(STACK_TEST_CASE_3));
    }
}
