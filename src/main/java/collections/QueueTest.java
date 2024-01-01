package collections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Jaa
 * @Description:
 * @Date 2023/12/31
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        System.out.println(queue);

        String polledElement = queue.poll();
        System.out.println(polledElement);
        System.out.println(queue);

        String peekedElement = queue.peek();
        System.out.println(peekedElement);
        System.out.println(queue);

        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }
    }
}
