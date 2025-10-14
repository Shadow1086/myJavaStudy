# Homework01Instance 模块说明

本模块实现了一个简易的控制台版银行账户系统，涵盖账户开户、查询、存取款、查看交易明细以及销户等核心流程。下面对四个主要类的职责和它们之间的协作关系做详细说明。

## Main

- 定位：系统的唯一入口类。
- 职责：仅包含 `main` 方法，实例化 `AccountManager` 并调用其 `start()` 方法。
- 关系：把控制权交给 `AccountManager`，自身不处理任何业务逻辑。

## AccountManager

- 定位：控制台交互层，充当“界面控制器”。
- 核心功能：
  - 展示主菜单并读取用户输入。
  - 根据选项调用开户、查询概要、存款、取款、查看交易明细、销户等流程。
  - 维护一个 `List<Account>` 以管理所有开户的账户对象。
- 关键协作：
  - 调用 `Account.create()` 校验并生成新账户，成功后存入账户列表。
  - 根据用户选择的账户对象，分别触发 `Account` 的业务方法，如 `deposit()`, `withdraw()`, `printSummary()`, `printTransactionHistory()`, `closeAccount()`, `markAsClosed()`。
  - 使用内部的 `Scanner` 负责所有控制台输入读取，并提供 `readDouble()`、`readInt()` 作为复用的输入校验工具。

## Account

- 定位：领域层核心类，表示单个银行账户的完整状态与行为。
- 核心字段：
  - `accountNumber`：自动生成的账号。
  - `ownerName`、`personalId`、`openTime`、`balance`：账户关键信息。
  - `TransactionHistory history`：组合一个明细记录器，追踪所有操作。
- 主要方法：
  - `create(...)`：静态工厂，集中校验开户数据并返回 `Account` 实例。
  - `deposit(...)` / `withdraw(...)`：处理存取款并写入交易明细。
  - `printSummary()` / `printTransactionHistory()`：输出账户概要和所有交易记录。
  - `closeAccount()` / `markAsClosed()`：处理销户流程及数据清理。
  - Getter/Setter：暴露必要信息供 `AccountManager` 使用。
- 与其他类的关系：
  - 只被 `AccountManager` 持有并调用。
  - 内部组合 `TransactionHistory`，负责把每次操作的日志委托给该类。

## TransactionHistory

- 定位：账户操作日志的存储与输出工具类。
- 核心职责：
  - 维护一个 `records` 列表，顺序记录格式化后的字符串。
  - `addRecord(...)`：提供金额版与无金额版两种重载，生成统一格式的明细条目。
  - `printAll()`：在控制台输出所有历史记录，无记录时给出友好提示。
  - `clear()`：在账户销户时清空历史。
- 与其他类的关系：
  - 仅由 `Account` 持有并调用，外部不会直接接触。

## 工作流程概览

1. 运行 `Main.main()`，创建 `AccountManager` 并进入 `start()` 主循环。
2. 用户通过菜单选择功能：
   - 开户时，`AccountManager` 收集输入后调用 `Account.create()`；成功返回的账户被保存到列表。
   - 存取款、查询概要、查询明细等操作均先由 `AccountManager` 让用户选择目标账户，再调用对应的 `Account` 方法。
   - 销户流程由 `Account.closeAccount()` 给出确认提示，确认后 `Account.markAsClosed()` 清理数据并由 `AccountManager` 将账户对象移出列表。
3. `Account` 在每次业务操作中调用 `TransactionHistory.addRecord()` 写入明细，或在用户查看明细时调用 `TransactionHistory.printAll()` 输出。

总体而言：

- `Main` 负责启动；
- `AccountManager` 负责互动、调度和账户集合管理；
- `Account` 聚合账户数据与业务规则；
- `TransactionHistory` 专注记录历史，保持业务日志清晰可追溯。

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

## 注意事项
- 所有代码都包含详细注释，便于学习理解
- 建议按顺序学习各个章节
- 每个示例都有对应的测试类