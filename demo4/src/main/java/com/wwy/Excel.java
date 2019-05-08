package com.wwy;

public class Excel {
    private String date;
    private String type;
    private String endpoint;//端点
    private String page;
    private String bugDescribe;
    private String bugReason;//问题原因
    private String bugSolution;//解决方案
    private String priority;//优先级
    private String rmarks;//备注
    private String personInCharge;//负责人
    private String questioner;//提问人
    private String developmentGroup;//开发组
    private String solutionMan;//解决人
    private String solutionManGroup;//结局人所在组

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getBugDescribe() {
        return bugDescribe;
    }

    public void setBugDescribe(String bugDescribe) {
        this.bugDescribe = bugDescribe;
    }

    public String getBugReason() {
        return bugReason;
    }

    public void setBugReason(String bugReason) {
        this.bugReason = bugReason;
    }

    public String getBugSolution() {
        return bugSolution;
    }

    public void setBugSolution(String bugSolution) {
        this.bugSolution = bugSolution;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRmarks() {
        return rmarks;
    }

    public void setRmarks(String rmarks) {
        this.rmarks = rmarks;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    public String getQuestioner() {
        return questioner;
    }

    public void setQuestioner(String questioner) {
        this.questioner = questioner;
    }

    public String getDevelopmentGroup() {
        return developmentGroup;
    }

    public void setDevelopmentGroup(String developmentGroup) {
        this.developmentGroup = developmentGroup;
    }

    public String getSolutionMan() {
        return solutionMan;
    }

    public void setSolutionMan(String solutionMan) {
        this.solutionMan = solutionMan;
    }

    public String getSolutionManGroup() {
        return solutionManGroup;
    }

    public void setSolutionManGroup(String solutionManGroup) {
        this.solutionManGroup = solutionManGroup;
    }

    public Excel() {
    }

    public Excel(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Excel{" +
                "date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", endpoint='" + endpoint + '\'' +
                ", page='" + page + '\'' +
                ", bugDescribe='" + bugDescribe + '\'' +
                ", bugReason='" + bugReason + '\'' +
                ", bugSolution='" + bugSolution + '\'' +
                ", priority='" + priority + '\'' +
                ", rmarks='" + rmarks + '\'' +
                ", personInCharge='" + personInCharge + '\'' +
                ", questioner='" + questioner + '\'' +
                ", developmentGroup='" + developmentGroup + '\'' +
                ", solutionMan='" + solutionMan + '\'' +
                ", solutionManGroup='" + solutionManGroup + '\'' +
                '}';
    }
}
