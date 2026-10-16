# daliuren4java

Java 原生大六壬排盘 SDK，历法使用 `tyme4j`，JAR 内置三传规则表。要求 Java 11+，运行时不依赖 Node.js 或其他语言。

```java
Map<String, Object> input = Map.of(
    "date", "2026-09-04", "hour", 18, "minute", 0,
    "timezone", "Asia/Shanghai"
);
Map<String, Object> chart = Daliuren.calculate(input);
Map<String, Object> canonical = Daliuren.canonical(input);
```

`calculate` 返回完整结构化盘面，`canonical` 返回规范 JSON。当前算法版本为 `daliuren-shizhan-v1`。
