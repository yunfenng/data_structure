package array;

/**
 * @Author: YunFenng
 * @Date: 2020/12/29 12:45
 * @Description:
 *      1) 数组的插入、删除、按照下标随机访问操作；
 *      2) 数组中数据类型是int类型
 */
public class Array {
    // 定义整形数组data存储int数据
    public int data[];
    // 定义数组的长度
    private int n;
    // 定义实际元素个数
    private int count;

    // 构造方法，定义数组的大小(容量)
    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;//一开始数组初始化时没有数据所以为0
    }

    // 根据索引找到数组的元素并返回
    public int find(int index) {
        if (index < 0 || index > count) return -1;
        return data[index];
    }

    // 插入元素
    public boolean insert(int index, int value) {
        // 若数组空间已满，返回false
        if (count == n) return false;
        // 若数组空间未满，那么可以将数据插入数组中
        // 判断位置是否合法
        if (index < 0 || index > count) {
            System.out.println("位置不合法！");
            return false;
        }
        // 位置合法
        for (int i = count; i > index; --i) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;
        return true;
    }

    // 根据索引，删除数组中的元素
    public boolean delete(int index) {
        // 判断索引是否合法
        // 如果索引不合法，则返回false
        if (index < 0 || index > count) return false;
        //如果索引合法，从删除位置开始，后面的元素向前移动一位
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        --count; // 数组实际长度减1
        return true;
    }

    // 打印数组
    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array arr = new Array(5);
        arr.printAll();
        arr.insert(0, 3);
        arr.insert(0, 4);
        arr.insert(1, 5);
        arr.insert(3, 9);
        arr.insert(3, 10);
        //arr.insert(3, 11);
        arr.printAll();
    }

}
