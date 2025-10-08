# Java `static` 关键字详解

> 目标：在不删除原有知识点的基础上，梳理结构、补充工具类（Utility Class）设计、内存/生命周期、使用规范与示例。所有新增内容均为扩展。

---
## 目录
1. 概述：`static` 是什么
2. 可修饰的结构
3. 静态变量（类变量）
4. 静态方法
5. 访问与调用规则
6. 静态代码块（static block）
7. 静态内部类（Static Nested Class）
8. 工具类（Utility Class）设计规范与示例
9. 使用场景与典型模式
10. 与实例成员的对比
11. 内存与生命周期（类加载时机）
12. 常见误区与注意事项
13. 示例代码汇总
14. 原始笔记保留区（未删减）

---
## 1. 概述：`static` 是什么
`static` 是 Java 的一个**类级别（Class-Level）**关键字，用于将成员与“类本身”绑定，而非与某个对象实例绑定。
- 静态成员在 **方法区 / 元空间（JDK8+）** 中只存储一份。
- 类加载时初始化（详见第 11 节）。
- 访问语义：通过 `类名.成员` 来表达“无需对象即可使用”。

## 2. 可修饰的结构
| 结构 | 说明 | 常见用途 |
|------|------|----------|
| 静态变量（类变量） | 所有实例共享一份 | 计数器 / 配置常量缓存 |
| 静态方法 | 不依赖实例状态 | 工具方法、工厂方法、辅助计算 |
| 静态代码块 | 类初始化逻辑 | 预加载资源、一次性计算 |
| 静态内部类 | 与外部类逻辑关联但不需持有外部实例 | 构建者模式 / 延迟加载单例 |
| 静态常量（`static final`） | 编译期常量或运行期只读 | 常量池定义（`PI`, `MAX_VALUE`） |

> 另：接口里的字段**默认**是 `public static final`，方法（JDK8 起）可以有 `static`。

## 3. 静态变量（类变量）
特点：
- 声明格式：`static 数据类型 变量名;`
- 生命周期：随类加载创建 → 随类卸载回收。
- 访问推荐：`类名.变量`（虽可通过实例访问，但不推荐）。
- 默认值：与实例变量一致（数值型 0，引用型 null，boolean 为 false）。
- 典型用途：
  - 统计：`private static int counter;`
  - 全局共享配置（配合 `final`）。
  - 缓存（需注意并发安全）。

示例：
```java
public class User {
    private static int total; // 统计系统创建的用户数量
    private String name;

    public User(String name) {
        this.name = name;
        total++; // 所有实例共享同一份 total
    }
    public static int getTotal() { return total; }
}
```

## 4. 静态方法
规则：
- 不能直接访问“实例变量 / 实例方法”（因为没有 `this`）。
- 可访问：静态变量 / 其他静态方法。
- 典型用途：
  - 工具类（`Math.random()`）
  - 工厂方法（简化构造逻辑）
  - 静态构建入口（如 `List.of(...)`）

不适用场景：需要依赖对象状态（应使用实例方法）。

## 5. 访问与调用规则（总结表）
| 场景 | 是否允许 | 说明 |
|------|----------|------|
| 静态方法访问实例变量 | 否 | 没有 `this` 上下文 |
| 静态方法访问静态变量 | 是 | 同属类级别 |
| 实例方法访问静态变量 | 是 | 但语义上仍是类数据 |
| 实例方法访问实例变量 | 是 | 通过 `this` |
| 静态方法使用 `this` / `super` | 否 | 编译不通过 |

## 6. 静态代码块（Static Block）
用于**类加载时**执行一次的初始化逻辑：
```java
public class ConfigHolder {
    public static final Map<String, String> CONFIG = new HashMap<>();
    static {
        CONFIG.put("env", "prod");
        CONFIG.put("timeout", "5000");
    }
}
```
注意：
- 避免放耗时 / IO 逻辑，防止类加载阻塞。
- 多个静态代码块按出现顺序执行。

## 7. 静态内部类（Static Nested Class）
特点：
- 不持有外部类实例引用 → 不会引入隐式 `Outer.this`。
- 常用于：
  - Builder 模式
  - 延迟加载单例（Initialization-on-demand holder idiom）

示例（单例）：
```java
public class Singleton {
    private Singleton() {}
    private static class Holder { private static final Singleton INSTANCE = new Singleton(); }
    public static Singleton getInstance() { return Holder.INSTANCE; }
}
```

## 8. 工具类（Utility Class）设计规范与示例
特征：
- 只包含 `static` 方法（可能包含常量）。
- 不需要被实例化。
- 通常 `final` + 私有构造器防止继承与实例化。

设计规范：
```java
public final class StringUtils {
    private StringUtils() { throw new AssertionError("No StringUtils instances"); }

    public static boolean isBlank(String s) {
        if (s == null) return true;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isWhitespace(s.charAt(i))) return false;
        }
        return true;
    }
}
```

与常见 JDK 工具类：
- `java.lang.Math`
- `java.util.Arrays`
- `java.util.Collections`
- `java.util.Objects`

常见补充：
- 可结合静态导入：`import static java.util.Collections.*;`
- 保持单一职责，不要把“业务逻辑 + 工具”混杂。

## 9. 使用场景与典型模式
| 模式 | 示例 | 说明 |
|------|------|------|
| 计数器 | `User.total` | 统计创建数量 |
| 常量池 | `public static final double PI = 3.14159;` | 不变配置 |
| 单例 Holder | 静态内部类 | 线程安全 + 延迟加载 |
| 工具类 | `Arrays.sort()` | 不需实例化 |
| 静态工厂 | `LocalDate.now()` | 替代构造器，可增强语义 |

## 10. 与实例成员的对比
| 维度 | 静态成员 | 实例成员 |
|------|----------|----------|
| 归属 | 类 | 对象 |
| 内存 | 一份共享 | 每个对象一份 |
| 访问方式 | `类名.成员` | `对象.成员` |
| 适用 | 全局共享、不依赖状态 | 依赖实例的行为或数据 |

## 11. 内存与生命周期（类加载时机）
类加载步骤：加载 → 验证 → 准备 → 解析 → 初始化（执行 `<clinit>`，含静态变量赋值与静态块）。
触发初始化常见情况：
1. 首次访问类的静态变量 / 静态方法。
2. 反射：`Class.forName("...")`。
3. 创建类实例：`new`。
4. 启动类的 `main` 方法。

不触发的情况：
- 访问 `static final` 编译期常量（已内联）。
- 通过数组定义：`X[] arr = new X[10];`

## 12. 常见误区与注意事项
| 误区 | 说明 | 建议 |
|------|------|------|
| 滥用静态变量 | 造成全局可变状态 | 优先局部 / 依赖注入 |
| 工具类可继承 | 破坏封装 | `final` + 私有构造器 |
| 静态方法易测性差 | 难以 Mock | 业务逻辑放实例 / 接口 |
| 在静态块做重 IO | 类加载缓慢 | 延迟加载或懒初始化 |
| 用静态共享可变集合不加锁 | 并发问题 | 使用并发集合或同步策略 |

## 13. 示例代码汇总
### 13.1 静态变量 & 计数
```java
public class IdGenerator {
    private static long counter = 0;
    public static synchronized long nextId() { return ++counter; }
}
```

### 13.2 静态工具类 + 校验
```java
public final class Validate {
    private Validate() {}
    public static <T> T notNull(T obj, String msg) {
        if (obj == null) throw new IllegalArgumentException(msg);
        return obj;
    }
}
```

### 13.3 静态导入提升可读性
```java
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class Demo {
    public static void main(String[] args) {
        System.out.println(emptyList());
        System.out.println(singletonList("Hi"));
    }
}
```

### 13.4 静态内部类实现懒加载单例
```java
public class ConfigService {
    private ConfigService() {}
    private static class Holder { private static final ConfigService INSTANCE = new ConfigService(); }
    public static ConfigService getInstance() { return Holder.INSTANCE; }
}
```

### 13.5 静态代码块初始化不可变集合
```java
public final class StatusDict {
    public static final Map<Integer, String> CODE_DESC;
    static {
        Map<Integer, String> m = new HashMap<>();
        m.put(200, "OK");
        m.put(404, "NOT_FOUND");
        m.put(500, "ERROR");
        CODE_DESC = Collections.unmodifiableMap(m);
    }
    private StatusDict() {}
}
```

## 14. 原始笔记保留区（未删减）
> 下方为原始笔记内容（格式略调整，语句未删除）：

```
1.什么是static
static是Java中的一个关键字，用于声明类的成员（变量或方法）为静态的。
静态成员属于类本身，而不是类的实例（对象）。
这意味着静态成员在内存中只有一份，无论创建多少个类的实例，它们共享同一个静态成员。

static用来修饰的结构：属性，方法，代码块，内部类

2.静态变量（类变量）
静态变量也称为类变量，用static修饰。静态变量随着类的加载而加载，且只会加载一次。
静态变量可以通过类名直接访问，也可以通过对象名访问，
但推荐使用类名访问以提高代码的可读性。

3.调用
* 静态方法只能调用静态变量，不可以调用非静态变量
* 非静态方法可以调用静态变量和非静态变量
* 静态方法中不能使用this和super关键字，因为this代表当前对象，
而静态方法不依赖于任何对象。
* 在非静态方法中，可以调用当前类中的静态结构（属性和方法）以及非静态结构。

4.静态方法
* 静态方法用static修饰，可以通过类名直接调用，而不需要创建类的实例。
* 静态方法不能访问类的非静态成员（变量和方法），因为非静态成员属于对象实例,而静态方法不依赖于任何对象实例。
* 静态方法通常用于工具类或与类相关的操作，而不需要依赖于对象实例。

5.开发中；
常常在工具类中的方法使用static修饰，方便调用<br>
工具类：就是没有属性，不需要实例对象。仅使用其中的方法。<br>
如：Math、Arrays、Collections等<br>
```

---
## 快速记忆口诀
- “类的，不是对象的” → 用 `static`。
- 共享、不变 → `static final`。
- 只方法无需状态 → 工具类（私有构造 + final）。
- 惰性单例 → 静态内部类 Holder。
- 初始化多步逻辑 → 静态代码块。

---
如需进一步扩展（并发下的 static、类加载器隔离、反射与 static 交互等），可在本文件后继续追加。
