package org.jeasy.rules.tutorials.insurance.support;

import org.jeasy.rules.api.Action;
import org.jeasy.rules.api.Facts;

public class JsonRuleAction implements Action {

    private String problemLevel;
    private String problemMessage;

    public JsonRuleAction(String problemLevel, String problemMessage) {
        this.problemLevel = problemLevel;
        this.problemMessage = problemMessage;
    }

    @Override
    public void execute(Facts facts) {
        System.out.println("General Action. [" + problemLevel + "]" + problemMessage);
    }
}