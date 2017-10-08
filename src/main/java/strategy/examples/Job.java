package main.java.strategy.examples;

/**
 * Created by Chalauri-G on 10/8/2017.
 */
public class Job {
    private  User user;
    private  String content;
    private int id;

    public Job(int i, User user, String content) {
        this.id = i;
        this.user = user;
        this.content = content;
    }

    public int getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public String getContent() {
        return this.content;
    }
}
