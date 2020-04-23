package org.jeasy.rules.tutorials.weather;

import java.util.HashMap;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

@Rule(name = "weather rule 2", description = "if it is sunny then take an sun-glass")
public class WeatherRule2 {
    @Condition
    public boolean when(@Fact("sunny") boolean sunny) {
        return sunny;
    }

    @Action
    public void then(Facts facts) throws Exception {
        // 调用基类方法,把下面的代码 改写成
        // warn("sunny");
        // error("sunny"); 
        synchronized (facts) {
            HashMap<String, String> map = (HashMap) facts.get("msgHashMap");
            map.put("key", "sunny");
        }
    }
}