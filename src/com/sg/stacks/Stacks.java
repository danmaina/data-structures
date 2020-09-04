package com.sg.stacks;

import java.util.Stack;

public class Stacks {

    private static final char LEFT_CURLY_BRACE = '{';
    private static final char RIGHT_CURLY_BRACE = '}';
    private static final char LEFT_SQUARE_BRACE = '[';
    private static final char RIGHT_SQUARE_BRACE = ']';
    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';

    public boolean challengeMatchStrings(String s) {

        // Create Stack
        Stack<Character> st = new Stack<>();

        // Convert String to character array
        char[] csArr = s.toCharArray();

        // Loop through array: If Character == { or [ or ( add character to stack
        // Else if Character == ] or } or ) check the top character in stack to make sure that it is the opposite of
        // current character && that the Stack is not empty: if true pop top character from stack else return false
        // Finally return true if stack is empty
        for(char c : csArr) {
            if (c == LEFT_BRACKET || c == LEFT_CURLY_BRACE || c == LEFT_SQUARE_BRACE){
                st.push(c);
            } else if (
                    !st.empty() &&
                    (c == RIGHT_BRACKET && st.peek() == LEFT_BRACKET) ||
                    (c == RIGHT_CURLY_BRACE && st.peek() == LEFT_CURLY_BRACE)  ||
                    (c == RIGHT_SQUARE_BRACE && st.peek() == LEFT_SQUARE_BRACE)
            ){
                st.pop();
            }
        }

        return st.empty();
    }

}
