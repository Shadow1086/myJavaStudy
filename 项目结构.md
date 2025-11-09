# 项目结构说明

## Maven 标准结构 + 原有组织方式

项目已按照 Maven 标准结构组织，同时保持了原有的三个学习阶段的目录划分，便于管理和查看。

## 目录结构

```
myJavaStudy/
├── src/
│   ├── main/
│   │   ├── java/                    # 所有源码（245个Java文件）
│   │   │   ├── java01/              # 基础阶段
│   │   │   │   └── src/
│   │   │   │       ├── java001/      # 基础语法（day01-day07）
│   │   │   │       └── Object/       # 面向对象（Class01-Class11）
│   │   │   │   ├── java02/          # 进阶阶段
│   │   │   │   └── src/
│   │   │   │       ├── Class01oop03/ # 包装类
│   │   │   │       ├── Class02/      # 异常处理
│   │   │   │       └── Class03/      # API和多线程
│   │   │   │   └── java03/          # GUI阶段
│   │   │   │       └── src/
│   │   │   │           ├── AWT01/    # AWT图形界面
│   │   │   │           ├── JavaFX01/ # JavaFX图形界面
│   │   │   │           └── App.java  # 应用程序入口
│   │   │   ├── Experiment/           # 实验代码（与java01/java02/java03并列）
│   │   │   └── Homework/             # 作业代码（与java01/java02/java03并列）
│   │   │   └── resources/            # 资源文件（.md, .jpg等）
│   │   └── test/
│   │       ├── java/                # 测试代码（预留）
│   │       └── resources/           # 测试资源（预留）
│   ├── target/                      # Maven编译输出目录
│   ├── pom.xml                      # Maven配置文件
│   └── lib/                         # 本地库文件
```

## 各阶段说明

### java01 - 基础阶段
- **src/java001/** - 基础语法学习
  - day01_flowControl - 流程控制
  - day02_forWhile - 循环语句
  - day03_forTwice - 嵌套循环
  - day04_arr - 数组
  - day05_arrTwice - 二维数组
  - day06_class - 类和对象
  - day07 - 工具类使用

- **src/Object/** - 面向对象编程
  - Class01 - 构造器、封装
  - Class02 - this关键字
  - Class03 - 继承、super
  - Class04 - 多态
  - Class05 - Object类
  - Class06 - static关键字
  - Class07 - 单例模式、抽象类、final
  - Class08 - 接口
  - Class09 - 内部类
  - Class10 - 枚举类
  - Class11 - 注解和JUnit

### Experiment - 实验代码
- **Homework01/** - 实验作业1
- **Homework02/** - 实验作业2
- **Homework03/** - 实验作业3

### Homework - 作业代码
- **Homework01/** - 作业1

### java02 - 进阶阶段
- **src/Class01oop03/** - 包装类
- **src/Class02/** - 异常处理
- **src/Class03/** - Java API和多线程
  - API/ - 字符串、日期时间、比较器等
  - thread/ - 多线程编程

### java03 - GUI阶段
- **src/AWT01/** - AWT图形界面
- **src/JavaFX01/** - JavaFX图形界面
- **src/App.java** - 应用程序入口

## 优势

1. ✅ **符合Maven标准** - 任何Java开发者都能快速理解
2. ✅ **保持原有组织** - 三个学习阶段清晰分离，便于查找和管理
3. ✅ **便于扩展** - 可以轻松添加新的学习内容
4. ✅ **工具支持** - IDE和构建工具能自动识别

## 使用说明

### 编译项目
```bash
mvn clean compile
```

### 运行JavaFX程序
```bash
mvn javafx:run
```

### 打包项目
```bash
mvn package
```

## 注意事项

- 所有源码都在 `src/main/java/` 下，符合Maven标准
- 三个主要目录（java01、java02、java03）保持了原有的学习阶段划分
- 包结构保持不变，不影响代码运行
- 资源文件（.md、.jpg等）在 `src/main/resources/` 下

