package com.xiaopo.flying.eye.model.entity;

/**
 * Created by snowbean on 16-11-16.
 */
public class Feed {
    private String type;
    public Data data;

    public static class Data{
        public String dataType;
        public String id;
        public String title;
        public String description;
        public String category;
        public String playUrl;
        public Cover cover;
        public int duration;

    }

    public static class Cover{
        public String feed;
        public String blurred;
    }
}
