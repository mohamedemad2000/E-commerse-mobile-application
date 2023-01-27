package com.example.new_mobile_project.Models;

public class feedback_model {
    private int feed_id;
    private String feedtxt;
    private String feedrate;
    public feedback_model() {}
    public feedback_model(String feedtxt, String feedrate) {
        this.feedtxt = feedtxt;
        this.feedrate = feedrate;
    }

    public int getFeed_id() {
        return feed_id;
    }

    public void setFeed_id(int id) {
        this.feed_id = id;
    }

    public String getFeedtxt() {
        return feedtxt;
    }

    public void setFeedtxt(String feedtxt) {
        this.feedtxt = feedtxt;
    }

    public String getFeedrate() {
        return feedrate;
    }

    public void setFeedrate(String feedrate) {
        this.feedrate = feedrate;
    }
}
