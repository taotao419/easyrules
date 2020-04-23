package org.jeasy.rules.tutorials.insurance;

import java.math.BigDecimal;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

@Rule(name = "face amount max rule", description = "face amount maxiumn should be less than config in DB ")
public class FaceAmountMaxRule extends BaseRule{
    @Condition
    public boolean when(Facts facts) {
        // fetch face amount max config value from context
        int maxFaceAmount = facts.get("faceAmountMax");
        Policy policy = (Policy) facts.get("policy");
        int faceAmount = policy.getCoverages().get(0).getFaceAmount();// take first one
        return faceAmount > maxFaceAmount;
    }

    @Action
    public void then(Facts facts) throws Exception {
        warn("face amount should be less than " + facts.get("faceAmountMax"));
    }
}