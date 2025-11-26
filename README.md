# myJavaStudy

面向初学者的 Java 自学项目，覆盖基础语法、面向对象、常用 API 以及 GUI。仓库中的示例均带 `main` 方法，可直接运行体验对应知识点。

## 项目亮点

- **结构清晰**：按阶段划分 `java01/java02/java03`，学习路线一目了然。
- **示例丰富**：语法、面向对象、异常、集合、并发、GUI 全覆盖。
- **中文注释**：所有示例提供中文说明，帮助理解设计意图。
- **可运行示例**：每个主题都包含可执行入口，适合自测与课堂演示。

## 目录总览

| 目录 | 说明 |
| --- | --- |
| `java01/` | 基础语法、流程控制、面向对象与实验练习 |
| `java02/` | 包装类、异常、常用 API、多线程等进阶主题 |
| `java03/` | GUI 学习，包括 AWT、JavaFX 示例 |
| `Object/` | 面向对象专题代码（构造器、封装、单例等） |
| `Homework/` | 阶段性作业与综合练习 |
| `lib/` | 统一第三方依赖或教材提供的 jar 包 |

## 环境要求

- JDK 21（项目构建与运行均在 Java 21 下验证）
- Maven 3.9+（统一管理依赖与编译流程）
- 任意 IDE（IntelliJ IDEA / Eclipse / VS Code）或命令行
- 可选：JavaFX SDK 21（若运行 `java03/src/JavaFX01`）

## 快速开始

```bash
git clone https://github.com/yourname/myJavaStudy.git
cd myJavaStudy
mvn clean compile
```

1. 使用 IDE 以 Maven 项目方式导入（`pom.xml` 已配置依赖）。
2. 选择感兴趣的模块并运行其中的 `main` 类：
   - 基础语法：`java01/src/java001/day01/T_HelloWorld.java`
   - OOP 练习：`java01/Object/src/Class03/Encapsulation/EncapsulationTest.java`
   - GUI 示例：`java03/src/AWT01/HelloFrame.java`
3. JavaFX 示例启动方式：`cd java03/src/JavaFX01 && ./run.sh`

## Maven 构建与运行

- 编译全部示例：`mvn clean compile`
- 运行测试示例：`mvn test`
- IDE 中可直接使用 Maven 面板执行常见命令（compile/test/package）
- 若需添加依赖，请编辑根目录 `pom.xml`，运行 `mvn dependency:tree` 可查看依赖关系

## 推荐学习路径

1. `java01/src/java001`：语法、流程控制、数组、方法
2. `java01/Object/src`：封装、继承、多态、接口、抽象类
3. `java01/Experiment` 与 `Homework`：综合练习与业务建模
4. `java02/src`：异常体系、集合框架、包装类、线程基础
5. `java03/src`：GUI（AWT/JavaFX）与事件驱动编程

进度清单：

- [x] 基础语法与流程控制
- [x] 面向对象核心（封装/继承/多态/接口/抽象类）
- [x] 内部类与枚举
- [ ] 注解与反射
- [ ] 异常处理与集合框架
- [ ] 多线程编程
- [x] GUI 编程（AWT / JavaFX）

## 模块亮点

- `java01/Experiment/src/Homework01`：银行账户需求拆解实验，强调属性建模与控制台交互。
- `java01/Experiment/src/Homework01Instance`：
  - `Account`：封装账户信息并通过 `TransactionHistory` 记录操作。
  - `AccountManager`：菜单式控制台入口，串联开户、存取款、查询等业务。
  - `Main`：启动程序，体验完整的账户生命周期。
- `java03/src/JavaFX01`：已配置 JavaFX SDK 21，示例涵盖 Application、Stage、Scene、布局与事件处理。

## 如何参与

- Fork 仓库，按章节补充自己的练习或注释。
- 发现教材缺少的案例可通过 PR 贡献，欢迎附带讲解。
- 提交前请使用 `git status` 确认只提交源码，排除 `bin/`、`.class` 等编译文件。

## 许可与引用

本项目用于学习和教学，可自由引用或二次创作；如用于公开课程或文章，请保留项目来源链接。
