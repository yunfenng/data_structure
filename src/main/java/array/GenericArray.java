package array;

/**
 * @Author: Jaa
 * @Date: 2020/12/29 17:48
 * @Description: 动态数组
 */
public class GenericArray<T> {
    private T[] data;
    private int size;

    // 根据传入容量，构造Array
    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // 无参构造方法，默认容量为10
    public GenericArray() {
        this(10);
    }

    // 获取数组容量大小
    public int getCapacity() {
        return data.length;
    }

    // 获取当前数组元素个数
    public int getCount() {
        return size;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 修改 index 位置的元素
    public void changeValue(int index, T e) {
        checkIndexUpdate(index); // 校验下标是否合法
        data[index] = e;
    }

    // 查看数组是否包含元素e
    public boolean contain(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 获取对应元素的下标，若没有返回-1
    public int findIndex(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 在index位置, 插入元素e, 时间复杂度o(m+n)
    public void add(int index, T e) {
        checkIndexAdd(index);//校验下标是否合法
        // 如果当前元素个数等于当前数组容量，则数组扩容为原来的2倍
        if (size == data.length) {
            resize(2 * data.length);
        }
        // 如果index小于size-1, 则index后面的元素向后移动一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        ++size;
    }

    // 向数组头部插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 向数组尾部插入元素
    public void addLast(T e) {
        add(size, e);
    }

    // 删除 index 位置的元素, 并返回
    public T remove(int index) {
        checkIndexForRemove(index);
        T res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        --size;
        data[size] = null;

        // 缩容
        /*if (size == data.length && data.length / 2 != 0) {
            resize(data.length / 2);
        }*/
        // n为非负数时，>> 1和 / 2的结果是一样的
        // n为负数且还是偶数时，>> 1和/ 2的结果是一样的
        // n为负数且还是奇数时，>> 1和/ 2的结果是不一样的
        if (size == data.length && (data.length >> 1) != 0) {
            resize(data.length >> 1);
        }
        return res;
    }

    // 删除数组第一个元素
    public void removeFirst() {
        remove(0);
    }

    // 删除数组最后一个元素
    public void removeLast() {
        remove(size - 1);
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        int index = findIndex(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 重写toString方法
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append("[");

        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }

        builder.append("]");
        return builder.toString();
    }

    // 扩容方法，时间复杂度o(n)
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndexUpdate(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Update failed! Require index >= 0 and index < size.");
        }
    }

    private void checkIndexForRemove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed! Require index >=0 and index <= size.");
        }
    }

    private void checkIndexAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >= 0 and index < size.");
        }
    }

    public static void main(String[] args) {
        GenericArray<String> arr = new GenericArray<String>();
        System.out.println("初始化后数组是否为空：" + arr.isEmpty());//true
        arr.add(0, "风清扬");
        arr.add(0, "令狐冲");
        System.out.println("添加数组后数组是否为空：" + arr.isEmpty());//false
        // arr.add(3, "冲虚道长");
        arr.add(2, "冲虚道长");
        arr.add(3, "东方不败");
        arr.add(4, "方证大师");
        arr.add(5, "田伯光");
        arr.add(6, "左冷禅");
        arr.add(7, "岳不群");
        arr.add(8, "依琳");
        arr.add(9, "哑巴婆婆");
        System.out.println(arr.toString());
        arr.add(10, "刘正风");

        arr.addFirst("笑傲江湖");
        arr.addLast("金庸大侠");

        System.out.println(arr.toString());
        System.out.println("移除左冷禅");
        arr.remove(arr.findIndex("左冷禅"));
        System.out.println("移除左冷禅后：" + arr.toString());

        System.out.println(arr.contain("东方不败"));//true
        System.out.println(arr.contain("独孤求败"));//false
        System.out.println(arr.getCapacity());
        System.out.println(arr.getCount());
        arr.changeValue(1, "独孤求败");
        System.out.println(arr.toString());
    }
}
