package net.lzzy.algorithm.algorlib;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lzzy_gxy on 2019/7/9.
 * Description:
 */
public class SimpleMapTest {

    @Test
    public void iterateDaptFirst() {
        SimpleMap map = new SimpleMap(6);
        map.addEdg(0, 1, 1);
        map.addEdg(1, 5, 1);
        map.addEdg(0, 2, 1);
        map.addEdg(0, 3, 1);
        map.addEdg(3, 4, 1);
        String expected = "0,1,5,2,3,4";
        assertEquals(expected, map.iterateDaptFirst());
    }
    @Test
    public void iterateRangeFire(){
        SimpleMap map=new SimpleMap(6);
        map.addEdg(0, 1, 1);
        map.addEdg(1, 5, 1);
        map.addEdg(0, 2, 1);
        map.addEdg(0, 3, 1);
        map.addEdg(3, 4, 1);
        String expected = "0,1,,2,3,5,4";
        assertEquals(expected,map.iterateDaptFirst());
    }
}