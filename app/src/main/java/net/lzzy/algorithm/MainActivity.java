package net.lzzy.algorithm;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.AndroidException;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.lzzy.algorithm.algorlib.BaseSort;
import net.lzzy.algorithm.algorlib.SortFactory;

import java.util.Objects;
import java.util.Random;

/**
 * @author Administrator
 */

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSpinner();
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
    }

    private void initSpinner() {
        spinner = findViewById(R.id.acticity_main_sp);
        spinner.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, SortFactory.getSortNmme()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                BaseSort<Integer> sort=SortFactory.getInstance(spinner.getSelectedItemPosition(),items);
                BaseSort<Integer> sortNotNull= Objects.requireNonNull(sort);
                sortNotNull.sortWithTime();
                String result=sort.getResult();
                tvResult.setText(result);
                Toast.makeText(this, "总时长"+sort.getDuration(), Toast.LENGTH_SHORT).show();  tvResult.setText(result);
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
        //todo:直接选择排序的具体实现

        for (int i = 0;i<items.length-1;i++){
            int minPos=i;
            for (int j=i+1;j < items.length;j++){
                if (items[minPos].compareTo(items[j])>0){
                    minPos = j;
                }
            }
            swap(minPos,i);
        }

    }
    private void intsertSort(){
        //todo:直接插入排序
        for (int i=1;i<items.length;i++){
            if (items[i]<items[i-1]){
                int temp=items[i];
                int k=i-1;
                for (int j=k;j>=0&&temp<items[j];j--){
                    items[j+1]=items[j];
                    k--;//有序区域的位置减少
                }
                items[k+1]=temp;
            }
        }
    }

    private void swap(int m, int n) {
        int tmp=items[m];
        items[m]=items[n];
        items[n]=tmp;
    }

    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }

    private class DirectSort<T> {
        public void sorttime() {
        }
    }
}

