# Maven 标准结构迁移说明

## 迁移完成时间
2025-11-09

## 迁移内容

### 目录结构变更

**旧结构：**
```
java01/src/          → 基础阶段代码
java02/src/          → 进阶阶段代码
java03/src/          → GUI阶段代码
java01/Object/src/   → 面向对象代码
java01/Experiment/   → 实验代码
java01/Homework/      → 作业代码
```

**新结构（Maven标准 + 保持原有组织）：**
```
src/main/java/
  ├── java01/        → 基础阶段（java001基础语法、Object面向对象、Experiment实验、Homework作业）
  ├── java02/        → 进阶阶段（Class01oop03包装类、Class02错误处理、Class03 API和线程）
  └── java03/        → GUI阶段（AWT、JavaFX）
src/main/resources/  → 资源文件（.md, .jpg等）
src/test/java/       → 测试代码（预留）
src/test/resources/  → 测试资源（预留）
target/              → Maven编译输出目录
```

### 迁移详情

1. **源码迁移**：所有 `.java` 文件已迁移到 `src/main/java/`，并按原有组织方式分为三个目录：
   - `java01/` - 基础阶段（基础语法、面向对象、实验、作业）
   - `java02/` - 进阶阶段（包装类、异常处理、API、多线程）
   - `java03/` - GUI阶段（AWT、JavaFX）
   - 保持了原有的包结构和目录组织
   - 共迁移了 245 个 Java 文件

2. **资源文件迁移**：所有 `.md`、`.jpg` 等资源文件已迁移到 `src/main/resources/`
   - 保持了原有的目录结构

3. **配置文件更新**：
   - `pom.xml` - 移除了 `build-helper-maven-plugin`，使用标准 Maven 结构
   - `.vscode/settings.json` - 更新了源码路径为 `src/main/java`
   - 输出目录改为 `target/classes`

### 旧目录处理

**注意**：旧的 `java01/`、`java02/`、`java03/` 目录仍然保留在项目中。
- 这些目录可以作为备份参考
- 如果确认迁移无误，可以手动删除这些目录
- 或者将它们添加到 `.gitignore` 中忽略

### 验证迁移

运行以下命令验证迁移是否成功：

```bash
# 清理并编译
mvn clean compile

# 运行JavaFX程序
mvn javafx:run
```

### 后续操作建议

1. **测试编译**：运行 `mvn clean compile` 确保所有代码能正常编译
2. **测试运行**：运行 `mvn javafx:run` 确保 JavaFX 程序能正常运行
3. **清理旧目录**：如果确认迁移无误，可以删除旧的 `java01/`、`java02/`、`java03/` 目录
4. **更新文档**：更新 README.md 中的项目结构说明

## Maven 标准结构优势

1. **标准化**：符合 Maven 约定，任何 Java 开发者都能快速理解
2. **工具支持**：IDE 和构建工具能自动识别项目结构
3. **依赖管理**：Maven 自动管理所有依赖
4. **构建流程**：标准化的构建生命周期
5. **可扩展性**：易于添加测试、资源文件等

