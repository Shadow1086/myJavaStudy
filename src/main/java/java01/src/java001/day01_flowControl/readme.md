### switch语句的使用：

基本语法：
```java
switch (表达式){
    case a:{        命令语句        }
    case b:{        命令语句        }
    case c:{        命令语句        }
    default
}
```

### switch的穿透：

当表达式符合某个case，但是语句中没有break时，其余的所有case和default都会执行
除非执行完或遇见break

文件简介：
* T_switch01:switch语法的示例。
* T_switch02:switch的穿透，求几月几日是一年中的多少天。
