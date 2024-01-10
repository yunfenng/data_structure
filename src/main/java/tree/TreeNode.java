package tree;

import lombok.Data;

/**
 * @Author: Jaa
 * @Description:
 * @Date 2024/1/9
 */
@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode() {}

    @Override
    public String toString() {
        return "[" + val + "]";
    }
}


