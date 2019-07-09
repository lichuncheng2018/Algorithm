package net.lzzy.algorithm.algorlib;

import android.content.ClipData;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class DirectdSearch <T extends Comparable<? super T >>extends BaseSearch<T> {
    DirectdSearch(T[] items) {
        super(items);
    }

    @Override
    int search(T key) {
        long start=System.currentTimeMillis();
        int pos = 0;
        for (T item : items) {
            if (equal(item, key)) {
                setDuration(System.currentTimeMillis()-start);
                return pos;
            }
                pos++;
            }
        setDuration(System.currentTimeMillis()-start);
            return -1;
        }
    }

