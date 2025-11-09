# JavaFX 学习模块

## 环境配置

### 已完成配置
- ✅ JDK 21.0.9 LTS (OpenJDK)
- ✅ JavaFX SDK 21.0.9 (macOS ARM64)
- ✅ JAVAFX_HOME 环境变量已设置

### 安装位置
- JavaFX SDK: `/Volumes/study/Development/javafx-sdk-21.0.9`
- 环境变量: `JAVAFX_HOME=/Volumes/study/Development/javafx-sdk-21.0.9`

## 如何运行程序

### 方法1：使用运行脚本（推荐）
```bash
cd java03/src/JavaFX01
./run.sh
```

### 方法2：手动编译运行
```bash
# 编译
javac --module-path $JAVAFX_HOME/lib \
      --add-modules javafx.controls \
      HelloJavaFX.java

# 运行
java --module-path $JAVAFX_HOME/lib \
     --add-modules javafx.controls \
     -cp . HelloJavaFX
```

## 示例程序说明

### HelloJavaFX.java
- **功能**: 基本的JavaFX应用程序示例
- **演示内容**:
  - JavaFX应用程序的基本结构
  - UI组件创建（Label、Button）
  - 事件处理（按钮点击）
  - 布局管理（VBox）
  - 样式设置（CSS样式）
  - 窗口配置（Stage、Scene）

## JavaFX 核心概念

1. **Application 类**: JavaFX程序的入口点
2. **Stage**: 应用程序窗口
3. **Scene**: 窗口中的场景，包含UI组件
4. **布局容器**: VBox、HBox、GridPane等
5. **UI组件**: Label、Button、TextField等
6. **事件处理**: setOnAction() 方法
7. **样式**: 使用CSS或内联样式

## 学习建议

1. **从基础开始**: 先理解Application、Stage、Scene的关系
2. **布局练习**: 尝试不同的布局容器
3. **组件熟悉**: 学习常用UI组件的使用
4. **事件处理**: 掌握用户交互的处理方式
5. **样式美化**: 学习CSS样式设置

## 常用模块

JavaFX由多个模块组成，根据需要添加：
- `javafx.controls`: UI控件（Button、Label等）
- `javafx.fxml`: FXML支持
- `javafx.web`: WebView组件
- `javafx.media`: 媒体播放
- `javafx.graphics`: 图形和动画

## IDE 配置说明

### VS Code / Cursor 配置
项目已配置VS Code设置文件：
- `.vscode/settings.json` - Java项目配置和JavaFX库引用
- `.vscode/launch.json` - 运行配置，支持JavaFX程序调试
- `.vscode/tasks.json` - 编译任务配置

### IDE 错误解决
如果在IDE中仍看到JavaFX类无法解析的错误：
1. 重新加载VS Code窗口 (`Ctrl+Shift+P` → "Developer: Reload Window")
2. 确保Java扩展已安装并启用
3. 检查 `.vscode/settings.json` 中的JavaFX路径是否正确

## 故障排除

### 编译错误
- 检查JAVAFX_HOME是否正确设置
- 确认添加了必要的模块（--add-modules）
- 检查JavaFX版本与JDK版本的兼容性

### 运行错误
- 确认模块路径正确
- 检查类路径设置
- 确认JavaFX SDK文件完整

### 窗口不显示
- 检查macOS的权限设置
- 确认JavaFX线程正确启动
- 查看终端是否有错误信息
