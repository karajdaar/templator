package com.github.bitbucket.issues.to.jira;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class BitBucketToJiraCSV {

    public static class MetaData {

        String kind;
        String version;
        String component;
        String milestone;
    }

    public static class User {

        String username;
        String firstName;
        String lastName;
        String displayName;
        Boolean isTeam;
        String avatar;
        String resourceUri;
    }

    public static class Issue {

        String status;
        String priority;
        String title;
        User reportedBy;
        String commentCount;
        String content;
        String createdOn;
        String utcLastUpdated;
        String localId;
        String resourceUri;
        Boolean isSpam;
        User responsible;
        MetaData metadata;
    }

    public static class Issues {

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }

        public List<Issue> getIssues() {
            return issues;
        }

        public void setIssues(List<Issue> issues) {
            this.issues = issues;
        }

        Long count;
        List<Issue> issues;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: <program> bitbucketissues.json");
            System.err
                    .println("This will create a file in the same location with a .csv ending which can be imported into Jira");
            System.exit(1);
        }
        File inputFile = new File(args[0]);
        if (!inputFile.exists()) {
            System.err.println("File: " + inputFile.getAbsolutePath() + " not found!");
            System.exit(2);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        mapper.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Issues issues = mapper.readValue(inputFile, Issues.class);
        String outFilename = inputFile.getName().split("\\.")[0] + ".csv";
        File outFile = new File(inputFile.getParentFile(), outFilename);
        System.out.println("Writing " + issues.count + " issues to " + outFilename);

        PrintWriter wr = new PrintWriter(outFile);
        StringBuilder sb = new StringBuilder();
        sb.append("Summary, Issue Key, Comment Body, Date Created, Date Modified, Issue Type, Priority, Status, Reporter, Assignee");
        wr.println(sb.toString());
        for (Issue issue : issues.issues) {
            sb = new StringBuilder();
            sb.append(issue.title).append(",");
            sb.append(issue.localId).append(", ");
            sb.append("\"").append(issue.content.replaceAll("\"", "\"\"")).append("\"").append(", ");
            sb.append(issue.createdOn).append(", ");
            sb.append(issue.utcLastUpdated.substring(0, 19)).append(", ");
            sb.append(issue.metadata.kind).append(", ");
            sb.append(issue.priority).append(", ");
            sb.append(issue.status).append(", ");
            sb.append(issue.reportedBy.username).append(", ");
            if (issue.responsible != null) {
                sb.append(issue.responsible.username);
            }
            wr.println(sb.toString());
        }
        wr.close();
    }
}
