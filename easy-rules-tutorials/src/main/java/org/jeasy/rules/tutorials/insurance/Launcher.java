package org.jeasy.rules.tutorials.insurance;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.tutorials.insurance.support.JsonRuleDefinitionReader;
import org.jeasy.rules.tutorials.insurance.support.RuleDefinition;
import org.jeasy.rules.tutorials.insurance.support.RuleFactory;

public class Launcher {
    public static void main(String[] args) throws Exception {
        // define facts
        Facts facts = new Facts();
        facts.put("age", 10);
        facts.put("gender", "male");
      
        URL rulesJsonUrl = Launcher.class.getResource("rules.json");
        File rulesFile = new File(rulesJsonUrl.getPath());

        Reader reader = new FileReader(rulesFile);
        JsonRuleDefinitionReader jsonReader = new JsonRuleDefinitionReader();
        List<RuleDefinition> ruleDefinitions = jsonReader.read(reader);
        RuleFactory ruleFactory = new RuleFactory();
        List<Rule> jsonRules = ruleFactory.createRule(ruleDefinitions);

        Rules rules = new Rules();

        for (Rule jsonRule : jsonRules) {
            rules.register(jsonRule);
        }

        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }

    private static Policy assemblePolicy() {
        Policy policy = new Policy();
        Coverage coverage = new Coverage();
        coverage.setFaceAmount(3001);

        Client client = new Client();
        client.setAge(19);
        coverage.setClient(client);

        List<Coverage> coverages = new ArrayList<Coverage>();
        coverages.add(coverage);
        policy.setCoverages(coverages);

        return policy;
    }
}