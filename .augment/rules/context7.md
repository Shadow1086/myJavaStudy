# Context7 自动查询规则

## 触发条件

当用户询问以下类型问题时，**必须**先使用 Context7 查询最新文档：

1. **第三方库/框架的 API 用法**
   - 例如：Spring Boot、React、Vue、JUnit、Lombok 等

2. **版本特定功能**
   - 例如：Java 17 新特性、Spring Boot 3.x 变化、React 19 新 Hook

3. **最佳实践和推荐写法**
   - 例如：某库的官方推荐配置、性能优化建议

4. **用户明确要求使用 Context7**
   - 例如：消息中包含 "use context7"、"查一下文档"、"最新用法"

## 使用流程

1. **解析库 ID**
   - 调用 `resolve-library-id` 工具，传入库名称
   - 从返回结果中选择最匹配的库 ID

2. **获取文档**
   - 调用 `get-library-docs` 工具，传入库 ID
   - 可指定 `topic` 参数聚焦特定主题
   - 使用 `mode="code"` 获取 API 和代码示例
   - 使用 `mode="info"` 获取概念性指南

3. **基于文档回答**
   - 引用获取到的最新文档内容
   - 确保代码示例符合最新版本规范
   - 如文档不足，可翻页获取更多（page=2, 3...）

## 常用库快速参考

| 库名 | 常用 topic |
|------|-----------|
| Spring Boot | dependency injection, configuration, web, security |
| JUnit | assertions, parameterized tests, mocking |
| React | hooks, components, state management |
| Vue | composition api, reactivity, components |

## 注意事项

- 优先使用 Context7 获取的最新信息，而非训练数据中的旧知识
- 如果 Context7 查询失败，告知用户并使用已有知识回答
- 回答时注明信息来源于最新官方文档

