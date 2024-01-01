package collections;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Jaa
 * @Description:
 * @Date 2024/1/1
 */
public class DequeTest {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        deque.addLast("d");
        deque.addLast("e");


        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}
