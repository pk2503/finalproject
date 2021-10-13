package com.example.finalproject;

public class data {

    private String projectName = null;
    private String memberName = null;
    private String leaderName = null;

    public data(String firstName, String lastName, String leaderName) {
        this.projectName = firstName;
        this.memberName = lastName;
        this.leaderName = leaderName;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}

