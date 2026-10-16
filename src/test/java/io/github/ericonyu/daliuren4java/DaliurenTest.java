package io.github.ericonyu.daliuren4java;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class DaliurenTest {
    @Test void goldenChartAndCanonical() throws Exception {
        Map<String, Object> input = Map.of("date", "2026-09-04", "hour", 18, "timezone", "Asia/Shanghai");
        Map<String, Object> result = Daliuren.calculate(input);
        assertEquals(12, ((List<?>) result.get("gongInfos")).size());
        assertEquals("daliuren-shizhan-v1", result.get("algorithmVersion"));
        assertEquals(false, ((Map<?, ?>) result.get("dateInfo")).get("diurnal"));
        assertFalse(Daliuren.canonical(input).isEmpty());
    }

    @Test void solarTermBoundary() throws Exception {
        Map<String, Object> before = Daliuren.calculate(Map.of("date", "2026-02-18", "hour", 22, "timezone", "Asia/Shanghai"));
        Map<String, Object> after = Daliuren.calculate(Map.of("date", "2026-02-18", "hour", 23, "minute", 55, "timezone", "Asia/Shanghai"));
        assertEquals("子", ((Map<?, ?>) before.get("dateInfo")).get("yueJiang"));
        assertEquals("亥", ((Map<?, ?>) after.get("dateInfo")).get("yueJiang"));
    }

    @Test void lateZiUsesNextDay() {
        assertEquals(((Map<?,?>)Daliuren.calculate(Map.of("date","2026-04-10","hour",23,"minute",30)).get("dateInfo")).get("ganZhi"), ((Map<?,?>)Daliuren.calculate(Map.of("date","2026-04-11","hour",0,"minute",30)).get("dateInfo")).get("ganZhi"));
    }
}
