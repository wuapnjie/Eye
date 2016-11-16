package com.xiaopo.flying.eye.model.entity;

import java.util.List;

/**
 * Created by snowbean on 16-11-13.
 */
public class Daily {
    public String nextPageUrl;
    public long nextPublishTime;
    public String newestIssueType;
    public List<Issue> issueList;

    public static class Issue{
        public long releaseTime;
        public String type;
        public long date;
        public long publishTime;
        public List<Feed> itemList;
    }
}
