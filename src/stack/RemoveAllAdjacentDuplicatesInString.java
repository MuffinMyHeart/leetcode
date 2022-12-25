package stack;

import java.util.Stack;

//You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
//        We repeatedly make duplicate removals on s until we no longer can.
//
//        Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        int index = 0;
        while (index < chars.length) {
            if (characterStack.empty() || chars[index] != characterStack.peek()) {
                characterStack.push(chars[index]);
            } else {
                characterStack.pop();
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : characterStack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
