# daliuren4java

Java 大六壬排盘 SDK，JAR 内置经过版本锁定的排盘引擎。要求 Java 11+ 和 Node.js 20+。

```java
Map<String, Object> input = Map.of(
    "date", "2026-09-04", "hour", 18, "minute", 0,
    "timezone", "Asia/Shanghai"
);
Map<String, Object> chart = Daliuren.calculate(input);
Map<String, Object> canonical = Daliuren.canonical(input);
```

`calculate` 返回完整结构化盘面，`canonical` 返回规范 JSON。当前算法版本为 `daliuren-shizhan-v1`。
