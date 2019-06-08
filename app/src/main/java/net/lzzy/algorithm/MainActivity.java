package net.lzzy.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                directSort();
                displayItems(tvResult);
                break;
            default:
                break;
        }
    }

    private void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

    private void directSort() {
//        int num=10;
//        for (int i = 0; i <= num - 1; i++) {
//            for (int j = 0; j <num-1; j++) {
//                if (items[j] > items[j + 1]) {
//                    int temp;
//                    temp = items[j];
//                    items[j] = items[j + 1];
//                    items[j + 1] = temp;
                    //todo:直接选择排序的具体实现
                    //todo:for循环
                    //分为有序区和无序区，每一趟排序都在无序区依次对比，记录对比区域最下元素的位置，
                    //然后把无序区第一元素所记录的最小元素进行交换，无序区少一个，有序区多一个，循环往复直至无序区
                    //元素数量为0
                    for (int i=0;i<items.length-1;i++){
                        int minpos=i;
                        for (int j=i+1;j<items.length;j++){
                            if (items[minpos].compareTo(items[j])>0){
                                minpos = j;
                }
                            swap(minpos,i);
            }
        }
    }

    private void swap(int minpos, int i) {

    }

    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}
