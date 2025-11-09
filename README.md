# myJavaStudy

## 项目简介
这是一个 Java 学习项目，包含了从基础语法到面向对象编程的完整学习内容。

## 项目结构
- `java01/` - 主要的 Java 学习代码和项目
- `Object/` - 面向对象编程相关示例
- `Homework/` - 作业和练习代码

## Cursor 编辑器配置

### 启动配置
为了让 Cursor 每次打开时都询问打开哪个文件，已进行以下配置：

**配置文件位置：**
- 用户设置文件：`C:\Users\lenovo\AppData\Roaming\Cursor\User\settings.json`

**关键配置项：**
```json
{
    "workbench.startupEditor": "none",
    "window.restoreWindows": "none", 
    "workbench.editor.enablePreview": false,
    "workbench.editor.enablePreviewFromQuickOpen": false
}
```

**配置说明：**
- `workbench.startupEditor: "none"` - 启动时不自动打开任何编辑器
- `window.restoreWindows: "none"` - 不恢复之前的窗口状态
- `workbench.editor.enablePreview: false` - 禁用预览模式
- `workbench.editor.enablePreviewFromQuickOpen: false` - 禁用快速打开预览

**使用方法：**
1. 重启 Cursor 编辑器
2. 启动后不会自动打开任何文件
3. 使用 `Ctrl+O` 或 `Ctrl+P` 来选择要打开的文件
4. 或者使用 `Ctrl+Shift+O` 快速打开文件对话框

## 学习进度
- [x] 基础语法和流程控制
- [x] 面向对象编程基础
- [x] 封装、继承、多态
- [x] 接口和抽象类
- [x] 内部类和枚举
- [ ] 注解和反射
- [ ] 异常处理
- [ ] 集合框架
- [ ] 多线程编程
- [x] GUI 编程 (AWT)
- [x] JavaFX 图形界面

## 模块说明与联系

### `java01/Experiment/src/Homework01`
- 这是您最早练习银行账户需求的实验区。
- 主要关注类的基本属性设置、控制台交互雏形，便于理解题目要求。
- 当前代码仍保留未完成/待优化部分，可用于对照参考。

### `java01/Experiment/src/Homework01Instance`
这是一个全新的、可直接运行的参考实现，帮助您在不知道如何继续时找到思路。

- `Account`
  - 负责保存账户核心信息（账号、姓名、身份证号、余额等）。
  - 提供存款、取款、查询概要、销户等方法。
  - 与 `TransactionHistory` 协作，自动记录每次操作。
  - 所有方法都带有详细注释，引导您理解设计原因与下一步扩展方向。
- `TransactionHistory`
  - 专门存储和输出交易明细。
  - Account 在每次操作后调用它来生成“事件日志”。
- `AccountManager`
  - 控制台交互入口，使用单个 `Scanner` 循环展示菜单。
  - 管理多个 `Account` 实例，负责注册、选择、操作账户。
  - 通过调用 `Account` 的方法把业务串联起来，演示完整流程。
- `Main`
  - 程序入口，只做一件事：new 一个 `AccountManager` 并调用 `start()`。
  - 运行后即可体验控制台版本的银行账户系统。

### 各模块如何协同
1. `Main` 启动 `AccountManager`，显示主菜单。
2. `AccountManager` 根据用户输入，创建或获取 `Account` 实例。
3. `Account` 处理存取款、销户、查询信息等具体业务；每次操作后调用 `TransactionHistory` 生成明细。
4. 当需要查看历史时，`AccountManager` 再通过 `Account` 调用 `TransactionHistory#printAll()` 展示记录。

> ✅ 推荐做法：一边阅读 `Homework01Instance` 的代码，一边尝试在 `Homework01` 中模仿实现；遇到不会写的功能，直接参考对应类/方法的注释说明，逐步填补自己的版本。

### `java03/src/JavaFX01/`
- JavaFX 图形界面学习模块
- 包含基本的JavaFX应用程序示例
- 已配置好JavaFX SDK 21环境
- 运行方式：`cd java03/src/JavaFX01 && ./run.sh`
- 学习内容：Application类、Stage、Scene、布局容器、UI组件、事件处理

## 注意事项
- 所有代码都包含详细注释，便于学习理解
- 建议按顺序学习各个章节
- 每个示例都有对应的测试类