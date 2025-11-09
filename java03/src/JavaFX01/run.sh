#!/bin/bash

# JavaFX 编译运行脚本

echo "=== 编译 JavaFX 程序 ==="
echo "使用 JAVAFX_HOME: $JAVAFX_HOME"
echo ""

# 检查JAVAFX_HOME是否设置
if [ -z "$JAVAFX_HOME" ]; then
    echo "❌ 错误: JAVAFX_HOME 环境变量未设置"
    echo "请运行: export JAVAFX_HOME=/Volumes/study/Development/javafx-sdk-21.0.9"
    exit 1
fi

# 检查JavaFX SDK是否存在
if [ ! -d "$JAVAFX_HOME/lib" ]; then
    echo "❌ 错误: JavaFX SDK lib目录不存在: $JAVAFX_HOME/lib"
    exit 1
fi

# 编译
echo "🔧 编译中..."
javac --module-path "$JAVAFX_HOME/lib" \
      --add-modules javafx.controls \
      *.java

if [ $? -eq 0 ]; then
    echo "✅ 编译成功！"
    echo ""
    echo "🚀 运行程序..."
    echo "如果看到JavaFX窗口，则运行成功"
    echo ""

    # 运行
    java --module-path "$JAVAFX_HOME/lib" \
         --add-modules javafx.controls \
         -cp . HelloJavaFX

    echo ""
    echo "🎉 程序运行完成！"
else
    echo "❌ 编译失败"
    exit 1
fi
