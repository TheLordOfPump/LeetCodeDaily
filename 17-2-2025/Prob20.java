/** Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Every close bracket has a corresponding open bracket of the same type.*/
import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;  
                char last = stack.pop();
                
                if ((c == ')' && last != '(') || 
                    (c == '}' && last != '{') || 
                    (c == ']' && last != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));     
        System.out.println(isValid("()[]{}"));  
        System.out.println(isValid("(]"));      
        System.out.println(isValid("([)]"));    
        System.out.println(isValid("{[]}"));   
    }
}
