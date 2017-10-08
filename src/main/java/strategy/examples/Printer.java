package main.java.strategy.examples;

import java.util.Random;

/**
 * Created by Chalauri-G on 10/8/2017.
 */
public class Printer extends Thread {

    private boolean shouldRun = true;
    private PrinterQueue printerQueue  = new SimpleFIFOPrinterQueue();
    private Random random = new Random();

    public Printer() {
    }

    @Override
    public void run() {
        while (this.shouldRun) {
            try {
                Thread.sleep(100);
                Job j = this.printerQueue.getNextJob();
                if (j != null) {
                    this.printJob(j);
                    this.informUser(j);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printJob(Job j) {
        try{
            System.out.println("Start of Job : " + j.getId());
            Thread.sleep(this.random.nextInt(1000));
            System.out.println("Printed : " + this.getJobAsPrinterLanguage(j));
            Thread.sleep(this.random.nextInt(1000));
            System.out.println("End of Job : " + j.getId());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void informUser(Job j) {
        if(j.getUser() != null){
            System.out.println("Notifying user : " + j.getUser().getName());
            j.getUser().printJobCompete(j);
        }
    }

    private String getJobAsPrinterLanguage(Job j) {
        //fake translation ...
        String retValue  = new StringBuilder(j.getContent().toUpperCase()).reverse().toString();
        System.out.println("Translated : " + j.getContent() + " -->  " + retValue);
        return retValue;
    }

    public synchronized void print(Job job){
        this.printerQueue.addJob(job);
    }

    public void shutDownPrinter() {
        this.shouldRun = false;
    }
}
