package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/20.
 * Description:
 */
public class SortFactory {
    public static<T extends Comparable<? super T>>  BaseSort<T> getInstance(int key, T[]items){
      BaseSort<T> sort;
      switch (key){
          case 0:
              sort= new DirectSort<>(items);
              break;
          case 1:
              sort= new InsetSort<>(items);
              break;
          case 2:
              sort= new Shellsort<>(items);
              break;
          defaul:
          return null;
      }
      return sort;
    }
    public static String[] getSortNmme(){
        return new String[]{"选择排序","直接插入排序","希尔排序"};
    }
}
