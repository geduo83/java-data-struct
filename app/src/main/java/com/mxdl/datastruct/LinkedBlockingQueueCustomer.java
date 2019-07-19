package com.mxdl.datastruct;

import android.util.Log;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description: <LinkedBlockingQueueCustomer><br>
 * Author:      mxdl<br>
 * Date:        2019/7/19<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class LinkedBlockingQueueCustomer extends Thread {
    public LinkedBlockingQueue<Integer> mQueue;

    public LinkedBlockingQueueCustomer(LinkedBlockingQueue<Integer> queue) {
        mQueue = queue;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            try {
                Integer value = mQueue.take();

                mQueue.poll();
                Log.v("MYTAG","value:"+value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
