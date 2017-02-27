package com.example.sachinsbethur.sortingbenchmark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static int[] array;
    private static int sizeOfArray;

    private TextView tvSelectedCase,tvBubbleSort,tvQuickSort,tvMergeSort,tvInsertionSort,tvSelectionSort;
    private EditText etSize;
    private RadioGroup rgTestCase;
    private RadioButton rbBestCase,rbWorstCase,rbAverageCase;
    private Button btnBubbleSort,btnQuickSort,btnMergeSort,btnInsertionSort,btnSelectionSort,btnBenchmarkAll,btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Edit Text References
        etSize=(EditText)findViewById(R.id.etSize);

        //Text Views References
        tvBubbleSort=(TextView)findViewById(R.id.tvBubbleSort);
        tvInsertionSort=(TextView)findViewById(R.id.tvInsertionSort);
        tvMergeSort=(TextView)findViewById(R.id.tvMergeSort);
        tvQuickSort=(TextView)findViewById(R.id.tvQuickSort);
        tvSelectionSort=(TextView)findViewById(R.id.tvSelectionSort);
        tvSelectedCase=(TextView)findViewById(R.id.tvSelectedCase);

        //RadioButtonGroup References
        rgTestCase=(RadioGroup)findViewById(R.id.rgTestCase);

        //Radio Buttons References
        rbBestCase=(RadioButton)findViewById(R.id.rbBestCase);
        rbWorstCase=(RadioButton)findViewById(R.id.rbWorstCase);
        rbAverageCase=(RadioButton)findViewById(R.id.rbAverageCase);

        //Button References
        btnBubbleSort=(Button)findViewById(R.id.btnBubbleSort);
        btnQuickSort=(Button)findViewById(R.id.btnQuickSort);
        btnMergeSort=(Button)findViewById(R.id.btnMergeSort);
        btnInsertionSort=(Button)findViewById(R.id.btnInsertionSort);
        btnSelectionSort=(Button)findViewById(R.id.btnSelectionSort);
        btnBenchmarkAll=(Button)findViewById(R.id.btnBenchmarkAll);
        btnReset=(Button)findViewById(R.id.btnReset);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

   private boolean isChecked(){
        if((rbWorstCase.isChecked()==false)&&(rbAverageCase.isChecked()==false)&&(rbBestCase.isChecked()==false))
            return true;
        else
            return false;
    }

    public void onClick(View view){
        //sizeOfArray=Integer.parseInt(etSize.getText().toString());
        switch(view.getId()){

            case R.id.rbBestCase:

                if(isEmpty()==true){
                    Toast.makeText(this,"Enter the size of array",Toast.LENGTH_LONG).show();
                    //rbBestCase.setChecked(false);
                }else{
                    tvSelectedCase.setText("Generated Sorted Array.");
                    tvSelectedCase.setSingleLine();
                    array = new int[sizeOfArray];
                    for (int i = 0; i < sizeOfArray; i++)
                        array[i] = (int) (Math.random() * 100);
                    Arrays.sort(array);
                }

                break;

            case R.id.rbAverageCase:

                if(isEmpty()){
                    Toast.makeText(this,"Enter the size of array",Toast.LENGTH_LONG).show();
                    //rbAverageCase.setChecked(false);
                }else{
                    tvSelectedCase.setText("Generated Random Array.");
                    tvSelectedCase.setSingleLine();
                    array = new int[sizeOfArray];
                    for (int i = 0; i < sizeOfArray; i++)
                        array[i] = (int) (Math.random() * 100);
                }

                break;

            case R.id.rbWorstCase:

                if(isEmpty()){
                    Toast.makeText(this,"Enter the size of array",Toast.LENGTH_LONG).show();
                    //rbWorstCase.setChecked(false);
                }else{
                    tvSelectedCase.setText("Generated Descending Sorted Array.");
                    tvSelectedCase.setSingleLine();
                    array = new int[sizeOfArray];
                    for (int i = 0; i < sizeOfArray; i++)
                        array[i] = (int) (Math.random() * 100);
                    Arrays.sort(array);
                    for (int i = 0; i < array.length / 2; i++) {
                        // swap the elements
                        int temp = array[i];
                        array[i] = array[array.length - (i + 1)];
                        array[array.length - (i + 1)] = temp;
                    }

                }
                break;

            case R.id.btnBubbleSort:

                if(isEmpty()){
                    Toast.makeText(this,"Enter the size of array",Toast.LENGTH_LONG).show();

                }else if(isChecked()) {
                    Toast.makeText(this,"Please select Test case",Toast.LENGTH_LONG).show();
                }else{
                    double bubbleTime=doBubbleSort();
                    tvBubbleSort.setText("Result is:"+bubbleTime);

                }
                break;

            case R.id.btnInsertionSort:

                if(isEmpty()){
                    Toast.makeText(this,"Enter the size of array",Toast.LENGTH_LONG).show();

                }else if(isChecked()) {
                    Toast.makeText(this,"Please select Test case",Toast.LENGTH_LONG).show();
                }else{
                    double insertionTime=doInsertionSort();
                    tvInsertionSort.setText("Result is:"+insertionTime);
                }
                break;

            case R.id.btnMergeSort:

                if(isEmpty()){
                    Toast.makeText(this,"Enter the size of array",Toast.LENGTH_LONG).show();
                }else if(isChecked()) {
                    Toast.makeText(this,"Please select Test case",Toast.LENGTH_LONG).show();
                }else{
                    double mergeTime=doMergeSort();
                    tvMergeSort.setText("Result is"+mergeTime);
                }
                break;

            case R.id.btnQuickSort:

                if(isEmpty()){
                    Toast.makeText(this,"Enter the size of array",Toast.LENGTH_LONG).show();
                }else if(isChecked()) {
                    Toast.makeText(this,"Please select Test case",Toast.LENGTH_LONG).show();
                }else{
                    double quickTime=doQuickSort();
                    tvQuickSort.setText("Result is"+quickTime);
                }
                break;

            case R.id.btnSelectionSort:

                if(isEmpty()){
                    Toast.makeText(this,"Enter the size of array",Toast.LENGTH_LONG).show();
                }else if(isChecked()) {
                    Toast.makeText(this,"Please select Test case",Toast.LENGTH_LONG).show();
                }else{
                    double selectionTime=doSelectionSort();
                    tvSelectionSort.setText("Result is"+selectionTime);

                }
                break;

            case R.id.btnBenchmarkAll:

                if(isEmpty()){
                    Toast.makeText(this,"Enter the size of array",Toast.LENGTH_LONG).show();

                }else if(isChecked()) {
                    Toast.makeText(this,"Please select Test case",Toast.LENGTH_LONG).show();
                }else{
                    doAll();
                }

                break;

            case R.id.btnReset:
                etSize.setText("");
                tvMergeSort.setText("Result is:");
                tvSelectionSort.setText("Result is:");
                tvBubbleSort.setText("Result is:");
                tvInsertionSort.setText("Result is:");
                tvQuickSort.setText("Result is:");
                tvSelectedCase.setText("");
                rbBestCase.setChecked(false);
                rbAverageCase.setChecked(false);
                rbWorstCase.setChecked(false);
                break;
        }
    }

    private boolean isEmpty(){
        if (etSize.getText().toString().equals(""))
            return true;
        else {
            sizeOfArray=Integer.parseInt(etSize.getText().toString());
            return false;
        }
    }

    private static double doHeapSort() {
        int[] heap = new int[sizeOfArray];
        heap = array.clone();
        double heapStart = System.currentTimeMillis();
        heap = SortAlgorithms.heapSort(heap);
        double heapEnd = System.currentTimeMillis();
        return (heapEnd - heapStart);
    }

    private static double doInsertionSort() {
        int[] insertion = new int[sizeOfArray];
        insertion = array.clone();
        double insertionStart = System.currentTimeMillis();
        insertion = SortAlgorithms.InsertionSort(insertion);
        double insertionEnd = System.currentTimeMillis();
        return (insertionEnd - insertionStart);
    }

    private static double doMergeSort() {
        int[] merge = new int[sizeOfArray];
        merge = array.clone();
        double mergeStart = System.currentTimeMillis();
        SortAlgorithms.MergeSort(merge);
        double mergeEnd = System.currentTimeMillis();
        return (mergeEnd - mergeStart);
    }

    private static double doQuickSort() {
        int[] quick = new int[sizeOfArray];
        quick = array.clone();
        int low = 0;
        int high = quick.length - 1;
        double quickStart = System.currentTimeMillis();
        SortAlgorithms.quickSort(quick, low, high);
        double quickEnd = System.currentTimeMillis();
        return (quickEnd - quickStart);
    }

    private static double doBubbleSort() {
        int[] bubble = new int[sizeOfArray];
        bubble = array.clone();
        double bubbleStart = System.currentTimeMillis();
        bubble = SortAlgorithms.BubbleSort(bubble);
        double bubbleEnd = System.currentTimeMillis();
        return (bubbleEnd - bubbleStart);
    }

    private static double doSelectionSort() {
        int[] selection = new int[sizeOfArray];
        selection = array.clone();
        double selectionStart = System.currentTimeMillis();
        selection = SortAlgorithms.SelectionSort(selection);
        double selectionEnd = System.currentTimeMillis();
        return (selectionEnd - selectionStart);
    }

    private void doAll() {

        tvBubbleSort.setText("Result is:" + doBubbleSort());
        tvInsertionSort.setText("Result is:" + doInsertionSort());
        tvMergeSort.setText("Result is" + doMergeSort());
        tvQuickSort.setText("Result is" + doQuickSort());
        tvSelectionSort.setText("Result is:" + doSelectionSort());

    }

}
