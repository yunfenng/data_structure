package collections;

import java.util.Stack;

/**
 * @Author: Jaa
 * @Description:
 * @Date 2023/12/31
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println(stack.search(4));

        stack.pop();
        stack.pop();
        Integer topElement = stack.peek();
        System.out.println(topElement);
        System.out.println("3的位置：" + stack.search(3));


    }
}
