package main.java.strategy.examples;

import java.util.Random;

/**
 * Created by Chalauri-G on 10/8/2017.
 */
public class Main {

    private static final int NUMBER_OF_JOBS = 10;
    private static final int MAX_JOB_DURATION_IN_SEC = 2;

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Starting experiment");
        User users[] = {
                new User("Peter"),
                new User("Pavel"),
                new User("Jemal")
        };

        Printer printer = new Printer();
        printer.start();

        for (int i = 0; i < NUMBER_OF_JOBS; i++) {
            printer.print(
                    new Job(
                            i,
                            users[random.nextInt(users.length)],
                            "Content is something random " + random.nextInt()
                    )
            );
        }

        try {
            /*
            we know that experiment should not take more than this time
             */
            Thread.sleep(NUMBER_OF_JOBS * MAX_JOB_DURATION_IN_SEC * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printer.shutDownPrinter();
        System.out.println("experiment finished");
    }
}
