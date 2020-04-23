package org.jeasy.rules.tutorials.insurance.support;

import java.util.ArrayList;
import java.util.List;

import org.jeasy.rules.api.Rule;
import org.jeasy.rules.core.RuleBuilder;

public class RuleFactory {
    public List<Rule> createRule(List<RuleDefinition> ruleDefinitions){
        List<Rule> rules=new ArrayList<>();

        for (RuleDefinition ruleDefinition : ruleDefinitions) {
            Rule rule = new RuleBuilder()
            .name(ruleDefinition.getName()) //name
            .description(ruleDefinition.getDescription()) //description
            .when(new SpELCondition(ruleDefinition.getFailCondition())) //condition
            .then(new JsonRuleAction(ruleDefinition.getProblemLevel(),ruleDefinition.getProblemMessage())) //action
            .build();

            rules.add(rule);
        }
      
        return rules;
    }
}