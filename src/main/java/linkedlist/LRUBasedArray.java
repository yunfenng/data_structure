package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Jaa
 * @Date: 2023/4/19 8:35
 * LRU（Least Recently Used）
 * 基于数组实现的LRU缓存
 * 1. 空间复杂度为O(n)
 * 2. 时间复杂度为O(n)
 * 3. 不支持null的缓存
 */
public class LRUBasedArray<T> {

    // 默认缓存大小
    private static final int DEFAULT_CAPACITY = (1 << 3);
    // 指定缓存容量
    private int capacity;
    // 缓存中元素个数
    private int count;
    private T[] value;

    // 存储数据
    private Map<T, Integer> holder;

    // 默认初始化容量
    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<T, Integer>(capacity);
    }

    /**
     * 模拟访问某个值
     *
     * @param object
     */
    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("该缓存容器不支持null!");
        }
        Integer index = holder.get(object);
        if (index == null) { // 也可以用工具类 Objects.isNull(index)
            if (isFull()) {
                // 缓存满的情况，踢出后，再缓存到数组头部
                removeAndCache(object);
            } else {
                // 缓存数据到头部，但要先右移
                cache(object, count);
            }
        } else {
            update(index);
        }
    }

    /**
     * 若缓存中有指定的值，则更新位置
     *
     * @param end
     */
    private void update(Integer end) {
        T target = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * 缓存数据到头部，但要先右移
     *
     * @param object
     * @param end    数组右移的边界
     */
    private void cache(T object, int end) {
        rightShift(end);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * end左边的数据统一右移一位
     *
     * @param end
     */
    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    /**
     * 缓存满的情况，踢出后，再缓存到数组头部
     *
     * @param object
     */
    private void removeAndCache(T object) {
        T key = value[--count];
        holder.remove(key);
        cache(object, count);
    }

    public boolean isFull() {
        return count == capacity;
    }

    public boolean isContain(T object) {
        return holder.containsKey(object);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    static class TestLRUBasedArray {

        public static void main(String[] args) {
            testDefaultConstructor();
            testSpecifiedConstructor(4);
            testWithException();
        }

        private static void testDefaultConstructor() {
            System.out.println("======无参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        private static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(8);
            System.out.println(lru);
            lru.offer(9);
            System.out.println(lru);
        }

        private static void testWithException() {
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(null);
        }
    }
}
