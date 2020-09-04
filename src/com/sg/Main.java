package com.sg;

import com.sg.stacks.Stacks;

public class Main {

    public static void main(String[] args) {

         final String STACK_TEST_CASE_1= "(){}[]";
         final String STACK_TEST_CASE_2= "(){}[";

        // write your code here
        Stacks stacks = new Stacks();

        System.out.println(stacks.stringMatches(STACK_TEST_CASE_1));
        System.out.println(stacks.stringMatches(STACK_TEST_CASE_2));
    }
}
