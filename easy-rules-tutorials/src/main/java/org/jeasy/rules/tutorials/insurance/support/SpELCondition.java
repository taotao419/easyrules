package org.jeasy.rules.tutorials.insurance.support;

import org.jeasy.rules.api.Condition;
import org.jeasy.rules.api.Facts;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELCondition implements Condition {

    private final ExpressionParser parser = new SpelExpressionParser();
    private Expression compiledExpression;

    public SpELCondition(String expression) {
        compiledExpression = parser.parseExpression(expression);
    }

    @Override
    public boolean evaluate(Facts facts) {
        StandardEvaluationContext context = new StandardEvaluationContext();
        // extract single coverage
        int age = (int) facts.get("age");
        String gender =(String) facts.get("gender");
        context.setVariable("age", age);
        context.setVariable("gender", gender);

        return compiledExpression.getValue(context, Boolean.class);
    }
}