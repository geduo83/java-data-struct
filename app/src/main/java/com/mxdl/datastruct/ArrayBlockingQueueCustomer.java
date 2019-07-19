package com.mxdl.datastruct;

import android.util.Log;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Description: <ArrayBlockingQueueCustomer><br>
 * Author:      mxdl<br>
 * Date:        2019/7/19<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class ArrayBlockingQueueCustomer extends Thread {
    private ArrayBlockingQueue<Integer> mQueue;

    public ArrayBlockingQueueCustomer(ArrayBlockingQueue<Integer> queue) {
        mQueue = queue;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                Thread.sleep(1000 * 1);
                Integer value = mQueue.take();
                Log.v("MYTAG", "value:" + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
