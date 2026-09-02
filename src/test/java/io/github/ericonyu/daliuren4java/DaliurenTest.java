package io.github.ericonyu.daliuren4java;
import org.junit.jupiter.api.Test;import java.util.*;import static org.junit.jupiter.api.Assertions.*;
class DaliurenTest{
 @Test void smoke()throws Exception{Map<String,Object> r=Daliuren.calculate(Map.of("date","2026-04-10","hour",14,"minute",30,"timezone","Asia/Shanghai"));assertEquals(12,((List<?>)r.get("gongInfos")).size());}
 @Test void lateZi()throws Exception{Map<String,Object>a=Daliuren.calculate(new HashMap<>(Map.of("date","2026-04-10","hour",23,"minute",30,"timezone","Asia/Shanghai"))),b=Daliuren.calculate(new HashMap<>(Map.of("date","2026-04-11","hour",0,"minute",30,"timezone","Asia/Shanghai")));assertEquals(((Map<?,?>)((Map<?,?>)a.get("dateInfo")).get("ganZhi")).get("day"),((Map<?,?>)((Map<?,?>)b.get("dateInfo")).get("ganZhi")).get("day"));assertEquals(((Map<?,?>)((Map<?,?>)a.get("dateInfo")).get("ganZhi")).get("hour"),((Map<?,?>)((Map<?,?>)b.get("dateInfo")).get("ganZhi")).get("hour"));}
}
