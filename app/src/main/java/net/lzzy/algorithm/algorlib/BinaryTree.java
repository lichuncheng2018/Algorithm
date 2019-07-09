package net.lzzy.algorithm.algorlib;

import android.support.v4.util.Pair;

/**
 * Created by lzzy_gxy on 2019/6/28.
 * Description:
 */
public class BinaryTree<T extends Comparable<? super T>> extends BaseSearch<T> {
    private Pair<Integer, T> root;
    private BinaryTree<T> left, right;


    BinaryTree(T[] items) {
        super(items);
        root = new Pair<>(0, items[0]);
        for (int i = 1; i < items.length; i++) {
            addNode(new Pair<>(i, items[i]));
        }
    }

    private BinaryTree(Pair<Integer, T> node) {
        root = node;
    }

    private void addNode(Pair<Integer, T> node) {
        //todo:增加节点的方法
        int comp = compare(node.second, root.second);
        if (comp > 0) {
            if (right == null) {
                right = new BinaryTree<>(node);
            } else {
                right.addNode(node);
            }
        }
        //左子树
        if (comp < 0) {
            if (left == null) {
                left = new BinaryTree<T>(node);
            } else {
                left.addNode(node);
            }
        }
    }

    private long start = -1;

    @Override
    public int search(T key) {
        if (start < 0) {
            start = System.currentTimeMillis();
        }
        int comp = compare(key, root.second);
        if (comp == 0) {
            setDuration(System.currentTimeMillis() - start);
            return root.first;
        } else if (comp > 0) {
            if (right == null) {
                setDuration(System.currentTimeMillis() - start);
                return -1;
            } else {
                return right.search(key);
            }
        } else {
            if (left == null) {
                setDuration(System.currentTimeMillis() - start);
                return -1;
            } else {
                return left.search(key);
            }
        }
    }
}
