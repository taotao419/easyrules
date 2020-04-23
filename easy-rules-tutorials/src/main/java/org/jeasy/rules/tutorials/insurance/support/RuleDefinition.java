package org.jeasy.rules.tutorials.insurance.support;

public class RuleDefinition {
    private String name;
    private String description;
    private String failCondition;
    private String problemLevel;
    private String problemMessage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFailCondition() {
        return failCondition;
    }

    public void setFailCondition(String condition) {
        this.failCondition = condition;
    }

    public String getProblemLevel() {
        return problemLevel;
    }

    public void setProblemLevel(String problemLevel) {
        this.problemLevel = problemLevel;
    }

    public String getProblemMessage() {
        return problemMessage;
    }

    public void setProblemMessage(String problemMessage) {
        this.problemMessage = problemMessage;
    }
}