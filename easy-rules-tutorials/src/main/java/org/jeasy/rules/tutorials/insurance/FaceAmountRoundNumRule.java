package org.jeasy.rules.tutorials.insurance;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

@Rule(name = "face amount round number rule", description = "face amount should be multiple of 1000")
public class FaceAmountRoundNumRule extends BaseRule {
    @Condition
    public boolean when(Facts facts) {
        Policy policy = (Policy) facts.get("policy");
        int faceAmount = policy.getCoverages().get(0).getFaceAmount();// take first one
        return faceAmount % 1000 != 0;//not round number 1000
    }

    @Action
    public void then(Facts facts) throws Exception {
        warn("face amount should be multiple of 1000.");
    }
}