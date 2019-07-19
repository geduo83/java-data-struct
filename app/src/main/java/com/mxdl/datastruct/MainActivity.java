package com.mxdl.datastruct;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayBlockingQueue<Integer> mArrayBlockingQueue;
    private LinkedBlockingQueue<Integer> mLinkedBlockingQueue;
    private Button mBtnArrayBlockingQueue;
    private Button mBtnLinkedBlockingQueue;
    private Button mBtnPriorityBlockingQueue;
    private PriorityBlockingQueue<MyTask> mTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnArrayBlockingQueue = findViewById(R.id.btn_array_blocking_queue);
        mBtnLinkedBlockingQueue = findViewById(R.id.btn_linked_blocking_queue);
        mBtnPriorityBlockingQueue = findViewById(R.id.btn_priority_blocking_queue);

        mBtnArrayBlockingQueue.setOnClickListener(this);
        mBtnLinkedBlockingQueue.setOnClickListener(this);
        mBtnPriorityBlockingQueue.setOnClickListener(this);

        mArrayBlockingQueue = new ArrayBlockingQueue(2);
        ArrayBlockingQueueCustomer customer = new ArrayBlockingQueueCustomer(mArrayBlockingQueue);
        customer.start();


        mLinkedBlockingQueue = new LinkedBlockingQueue<>();
        LinkedBlockingQueueCustomer customer1 = new LinkedBlockingQueueCustomer(mLinkedBlockingQueue);
        customer1.start();

        mTasks = new PriorityBlockingQueue<>();
        PriorityBlockingQueueCustomer customer2 = new PriorityBlockingQueueCustomer(mTasks);

        mTasks.put(new MyTask("张三",36));
        mTasks.put(new MyTask("李四",21));
        mTasks.put(new MyTask("王五",11));

        customer2.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_array_blocking_queue:
                Observable.interval(0,10,TimeUnit.SECONDS).take(2).subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if(aLong == 0){
                            mArrayBlockingQueue.put(0);
                            mArrayBlockingQueue.put(1);
                            mArrayBlockingQueue.put(2);
                        }else if(aLong == 1){
                            mArrayBlockingQueue.put(3);
                            mArrayBlockingQueue.put(4);
                            mArrayBlockingQueue.put(5);
                        }
                    }
                });
                break;
            case R.id.btn_linked_blocking_queue:
                Observable.interval(0,10,TimeUnit.SECONDS).take(2).subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if(aLong == 0){
                            mLinkedBlockingQueue.put(01);
                            mLinkedBlockingQueue.put(11);
                            mLinkedBlockingQueue.put(21);
                        }else if(aLong == 1){
                            mLinkedBlockingQueue.put(31);
                            mLinkedBlockingQueue.put(41);
                            mLinkedBlockingQueue.put(51);
                        }
                    }
                });
                break;
        }
    }
}
