package org.jeasy.rules.tutorials.insurance;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

@Rule(name = "face amount min rule", description = "face amount minimum should be greater than config in DB ")
public class FaceAmountMinRule extends BaseRule{
    @Condition
    public boolean when(Facts facts) {
        // fetch face amount min config value from context
        int minFaceAmount = facts.get("faceAmountMin");
        Policy policy = (Policy) facts.get("policy");
        int faceAmount = policy.getCoverages().get(0).getFaceAmount();// take first one
        return faceAmount < minFaceAmount;
    }

    @Action
    public void then(Facts facts) throws Exception {
        warn("face amount should be greater than " + facts.get("faceAmountMin"));
    }
}