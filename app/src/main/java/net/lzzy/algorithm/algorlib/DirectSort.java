package net.lzzy.algorithm.algorlib;

import android.graphics.Paint;
import android.sax.StartElementListener;

/**
 * Created by lzzy_gxy on 2019/6/13.
 * Description:
 */
public class DirectSort<T extends Comparable<? super T >>extends BaseSort<T> {
    DirectSort(T[] items) {
        super(items);

    }
//    //region 1.field字段  最小权限原则
//
//    private Integer[] items;
//    private  long duration;
//    private int compareCount;
//    private int swapCount;
//    private int moveStep;
//    //endregion
//
//    public DirectSort(Integer[] items){  //构造方法（构造器）
//        this.items=items;
//        compareCount=0;
//        swapCount=0;
//        moveStep=0;
//    }
//
//    boolean bigger(Integer a,Integer b){
//        compareCount++;
//        return a.compareTo(b)>0;
//    }
//
//    public  void swap(int i, int j){
//        int tmp=items[i];
//        items[i]=items[j];
//        items[j]=tmp;
//        swapCount++;
//    }
//    public String getResult() {
//        String display = "";
//        for (Integer i : items) {
//            display = display.concat(i + ",");
//        }
//        return  display.substring(0, display.length() - 1);
//    }
//
//    @Override
//    public void Sort() {
//
//    }


    @Override
    public void Sort() {
        //分为有序区和无序区，每一趟排序都在无序区依次进行对比，记录对比区域的最小元素的位置。
        //然后把无序区第一个元素和所记录的最小元素进行交换，无序区少一个、有序区多一个，循环往复直至无序区
        //元素数量为0
        //for i j 嵌套循环
        //long start=System.currentTimeMillis();
        for (int i = 0; i <= items.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < items.length; j++) {
                if (items[minPos].compareTo(items[j]) > 0) {
                    //记录无序区最小的元素
                    minPos = j;
                }
                //生成方法如下
                swap(minPos, i);
            }
            //duration=System.currentTimeMillis()-start;
        }
    }

}



//    public long getDuration(){
//        return duration;
//    }
//
//
//    public int getCompareCount() {
//        return compareCount;
//    }
//
//
//    public int getSwapCount(){
//        return swapCount;
//    }
//
//
//    public int getMoveStep(){
//        return moveStep;
//    }
//}



