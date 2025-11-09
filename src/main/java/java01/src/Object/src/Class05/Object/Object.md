# Object 类

## 1. 说明

- **所属包：`java.lang.Object`**  
- **所有的 Java 类（除 `Object` 自身）都直接或间接继承自 `Object`**  
- **`Object` 是所有类的根父类（Java 类层次结构的顶层）**  
- `Object` 类中声明的结构（方法等）具有通用性。  
  > `Object` 类中 **没有声明任何实例属性**。<br>
  > `Object` 类提供了 **一个空参构造器**。<br>
  > 需重点掌握：`Object` 类中声明的 **11 个方法**。

---
## 2. Object 类的 11 个方法

> 下列方法均为所有类所继承；根据使用频率，可分为常用、较少使用（或与并发/GC相关）。

| 方法 | 说明（简要） |
|------|--------------|
| `public final Class<?> getClass()` | 获取对象的运行时类（运行时类型） |
| `public int hashCode()` | 返回对象的哈希值（常与哈希集合相关） |
| `public boolean equals(Object obj)` | 判断与另一个对象是否“相等”（默认==，常需重写） |
| `protected Object clone()` | 创建并返回对象的一个副本（需实现 `Cloneable` 接口，否则抛异常） |
| `public String toString()` | 返回对象的字符串表示（默认：类的全限定名@十六进制哈希） |
| `public final void notify()` | 唤醒在此对象监视器上等待的单个线程（配合同步监视器使用） |
| `public final void notifyAll()` | 唤醒在此对象监视器上等待的所有线程 |
| `public final void wait()` | 使当前线程进入等待状态，直到被唤醒或中断 |
| `public final void wait(long timeout)` | 限时等待 |
| `public final void wait(long timeout, int nanos)` | 更精细的限时等待 |
| `protected void finalize()` | GC 回收前的“最后一次”清理（已不推荐使用，可能带来性能与回收不确定性） |

### 方法分组（记忆提示）
- **常用核心：** `equals()`、`toString()`、`hashCode()`、`getClass()`
- **对象拷贝：** `clone()`（了解）
- **线程通信（监视器方法）：** `wait()` / `wait(long)` / `wait(long, int)` / `notify()` / `notifyAll()`（并发基础）
- **GC 相关（了解/几乎不用）：** `finalize()`

> 说明：`finalize()` 可能导致对象再次逃逸或形成循环引用，影响回收；在现代 Java 中已弱化其使用场景（JDK 9 起标记为“已过时”趋势）。

---
## 3. equals(Object obj) 方法

### 3.1 方法说明
- 作用：指示其他某个对象是否与此对象“相等”。  
- **`Object` 中的默认实现：使用 `==` 比较两个引用是否指向同一个对象。**

源码（JDK 中逻辑简化形式）：
```java
public boolean equals(Object obj) {
    return (this == obj);
}
```

### 3.2 业务需求与重写动机
- 真实开发场景往往需要：判断两个对象 **“内容（属性值）”** 是否相等，而不仅仅是引用是否一致。  
- 常见已重写的类：`String`、`Date`、`File`、包装类（`Integer`、`Double` 等）。这些类都改写了 `equals()` 用于比较“值语义”。

### 3.3 重写 `equals()` 的注意事项（必须遵守）
1. 方法名：`equals`
2. 参数列表：必须是 `Object obj`
3. 通常步骤：
   - 自反性：`x.equals(x)` 必须为 `true`
   - 对称性：`x.equals(y)` 与 `y.equals(x)` 结果一致
   - 传递性：`x.equals(y)`、`y.equals(z)` 为 `true` ⇒ `x.equals(z)` 也应为 `true`
   - 一致性：多次调用结果不变（前提：参与比较的属性未变）
   - 非空性：任何非空引用 `x`，`x.equals(null)` 必须为 `false`
4. 推荐：重写 `equals()` 时通常也要 **配套重写 `hashCode()`**，以满足散列表（如 `HashMap`、`HashSet`）约定。

### 3.4 实际开发说明
> 针对自定义类，为了让“相等”语义符合业务（基于属性值），应重写 `equals()`。  
> 重写方式：
> - 手动编写（遵守判空、类型判断、强转、字段比较等规范）
> - 使用 IDE 自动生成（推荐，减少遗漏与错误）

---
## 4. toString() 方法

### 4.1 方法说明
- 作用：返回对象的字符串表示。  
- **`Object` 默认实现：返回 “运行时类全限定名 + '@' + 对象哈希码的十六进制形式”。**

源码（逻辑简化）：
```java
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

### 4.2 调用场景（隐式触发点）
1. `System.out.println(obj);` 内部自动调用 `obj.toString()`
2. 字符串拼接：`"value=" + obj` 会转成 `obj.toString()`
3. 直接显式调用：`obj.toString()`

### 4.3 子类的默认表现
> 若未重写：打印结果形如 `com.example.User@1a2b3c4d`（可读性差）。  
> 常见类如 `String`、`Date`、`File`、包装类均已重写 `toString()`，更利于日志与调试。

>自定义的类，在没有重写Object类的toString()方法时，调用toString()方法时，输出的是“类的全路径@对象的地址值的十六进制”。
>像String,Date,File或包装类等Object的子类都重写了Object类中的toString()方法，用于输出对象的属性值。

### 4.5 重写注意事项
1. 方法名：`toString`
2. 返回值类型：`String`
3. 访问修饰符：建议使用 `public`
4. 无参数
5. 输出内容建议：结构化且稳定（避免随版本轻易变动）

---
## 5. 常用方法总结（再次强调）
- **开发高频：** `equals()`、`hashCode()`、`toString()`
- **调试/反射：** `getClass()`
- **并发：** `wait()` / `notify()` / `notifyAll()`（需与 `synchronized` 配合）
- **谨慎：** `clone()`（浅拷贝 vs 深拷贝）
- **基本弃用：** `finalize()`（请使用 `try-with-resources` 或显式资源释放）

---
## 6. 补充建议
- 若类表示“值对象”（如坐标、金额、时间段），几乎必重写：`equals()`、`hashCode()`、`toString()`。
- 日志中避免直接依赖默认 `toString()`（否则输出无意义地址片段）。
- `equals()` 与 `compareTo()`（若实现 `Comparable`）要保持语义一致性：`x.compareTo(y) == 0` ⇒ `x.equals(y)` 通常也应为 `true`。

---

