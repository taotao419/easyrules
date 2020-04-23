package org.jeasy.rules.tutorials.spEL;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Launcher {
    public static void main(String[] args) {
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("age", 40);

        String expressionString = "#age ge 19 and #age lt 30";//ge == greate and equal
        SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, null);
        ExpressionParser parser = new SpelExpressionParser(config);
        Expression expression = parser.parseExpression(expressionString);

        boolean result=(boolean) expression.getValue(context);

        System.out.println(result);
    }
}