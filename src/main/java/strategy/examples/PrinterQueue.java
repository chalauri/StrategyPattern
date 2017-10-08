package main.java.strategy.examples;

/**
 * Created by Chalauri-G on 10/8/2017.
 */
public interface PrinterQueue {

    void addJob(Job job);
    Job getNextJob();
}
