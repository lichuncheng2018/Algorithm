package net.lzzy.algorithm.algorlib;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

/**
 * Created by lzzy_gxy on 2019/6/20.
 * Description:
 */
public class BubbleSort <T extends Comparable<? super T >>extends BaseSort<T> {
    BubbleSort(T[] items) {
        super(items);
    }

    @Override
    public void Sort() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < items.length - 1; i++) {
            boolean exchange = false;
            for (int j = items.length - 2; j >= i; j--) {
                if (bigger(items[j], items[j + 1])) {
                    swap(j, j + 1);
                    exchange = true;
                }
            }
            if (!exchange) {
                break;
            }
        }
        setDuration(System.currentTimeMillis() - start);
    }

    @Override
    public int search(T key) {
        return 0;
    }

}
