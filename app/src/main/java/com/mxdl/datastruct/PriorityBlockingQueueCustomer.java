package com.mxdl.datastruct;

import android.util.Log;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Description: <PriorityBlockingQueueCustomer><br>
 * Author:      mxdl<br>
 * Date:        2019/7/19<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class PriorityBlockingQueueCustomer extends Thread {
    private PriorityBlockingQueue<MyTask> mTasks;

    public PriorityBlockingQueueCustomer(PriorityBlockingQueue<MyTask> tasks) {
        mTasks = tasks;
    }

    @Override
    public void run() {
        super.run();
        for(;;){
            try {
                MyTask take = mTasks.take();
                Log.v("MYTAG",take.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
