package org.jeasy.rules.tutorials.insurance.support;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRuleDefinitionReader {
    private ObjectMapper objectMapper=new ObjectMapper();

    public List<RuleDefinition> read(Reader reader) throws Exception {
        List<RuleDefinition> ruleDefinitions = new ArrayList<>();
        Iterable<Map<String, Object>> rules = loadRules(reader);
        for (Map<String, Object> rule : rules) {
            ruleDefinitions.add(createRuleDefinition(rule));
        }
        return ruleDefinitions;
    }

    private Iterable<Map<String, Object>> loadRules(Reader reader) throws Exception {
        List<Map<String, Object>> rulesList = new ArrayList<>();
        Object[] rules = objectMapper.readValue(reader, Object[].class);
        for (Object rule : rules) {
            rulesList.add((Map<String, Object>) rule);
        }
        return rulesList;
    }

    private RuleDefinition createRuleDefinition(Map<String, Object> map) {
        RuleDefinition ruleDefinition = new RuleDefinition();

        String name = (String) map.get("name");
        ruleDefinition.setName(name != null ? name : "rule");

        String description = (String) map.get("description");
        ruleDefinition.setDescription(description != null ? description : "description");


        String failCondition = (String) map.get("failCondition");
        if (failCondition == null) {
            throw new IllegalArgumentException("The rule fail condition must be specified");
        }
        ruleDefinition.setFailCondition(failCondition);

        String problemLevel=(String) map.get("problemLevel");
        if (problemLevel == null) {
            throw new IllegalArgumentException("The rule problemLevel must be specified");
        } 
        ruleDefinition.setProblemLevel(problemLevel);

        String problemMessage=(String) map.get("problemMessage");
        if (problemMessage == null) {
            throw new IllegalArgumentException("The rule problemMessage must be specified");
        } 
        ruleDefinition.setProblemMessage(problemMessage);

        return ruleDefinition;
    }
}