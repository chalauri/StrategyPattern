package main.java.strategy.examples;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Chalauri-G on 10/8/2017.
 */
public class SimpleFIFOPrinterQueue implements PrinterQueue {
    public Queue<Job> queue = new LinkedList<>();

    @Override
    public void addJob(Job job) {
        this.queue.add(job);
    }

    @Override
    public Job getNextJob() {
         return queue.poll();
    }
}
