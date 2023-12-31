package linkedlist;

/**
 * @Author: Jaa
 * @Date: 2023/04/24 08:26
 * @Description: 1) 单链表插入、删除、查找操作
 * 2) 链表存储的是int类型数据
 */
public class SinglyLinkedList {

    private Node head = null;

    /**
     * 根据结点值查找Node
     */
    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    /**
     * 根据索引查找Node
     */
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }

    // 无头结点
    // 表头部插入
    // 这种操作将于输入的顺序相反，逆序
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    private void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    // 顺序插入
    // 链表尾部插入
    public void insertToTail(int value) {
        Node newNode = new Node(value, null);
        insertToTail(newNode);
    }

    private void insertToTail(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            newNode.next = p.next;
            p.next = newNode;
        }
    }

    /**
     * 将新结点插入到 p 结点前面
     *
     * @param p
     * @param value
     */
    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;
        if (head == p) {
            insertToHead(newNode);
            return;
        }
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) {
            return;
        }
        newNode.next = p;
        q.next = newNode;
    }

    /**
     * 将新结点插入到 p 结点后面
     *
     * @param p
     * @param value
     */
    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;
        newNode.next = p.next;
        p.next = newNode;
    }

    /**
     * 通过节点指针删除结点
     *
     * @param p
     */
    public void deleteByNode(Node p) {
        if (p == null || head == null) return;

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) return;

        q.next = q.next.next;
    }

    /**
     * 通过结点值删除结点
     *
     * @param value
     */
    public void deleteByValue(int value) {
        if (head == null) return;

        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }
        if (p == null) return;

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }

        // 可重复删除指定value的代码
        if (head != null && head.data == value) {
            head = head.next;
        }

        Node pNode = head;
        while (pNode != null) {
            if (pNode.next.data == value) {
                pNode.next = pNode.next.next;
                continue;
            }
            pNode = pNode.next;
        }
    }

    public static class Node {
        private int data;
        private Node next;

        public Node() {
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
