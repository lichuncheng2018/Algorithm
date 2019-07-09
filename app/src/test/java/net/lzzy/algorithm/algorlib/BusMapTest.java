package net.lzzy.algorithm.algorlib;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lzzy_gxy on 2019/7/9.
 * Description:
 */
public class BusMapTest {

    @Test
    public void textGetMinDistance() {
        BusMap map = new BusMap(5);
        map.setStart(0);
        map.setTarget(4);
        map.addTwoWayEdge(0,4,10);
        map.addTwoWayEdge(0,1,2);
        map.addTwoWayEdge(0,2,4);
        map.addTwoWayEdge(0,4,7);
        map.addTwoWayEdge(0,2,3);
        map.addTwoWayEdge(0,3,4);
        map.addTwoWayEdge(0,4,3);
        map.addTwoWayEdge(0,4,5);
        int expetcted=7;
        assertEquals(expetcted,(int)map.getMinDistance(BusMap.KEY_FYOYD));

    }
}