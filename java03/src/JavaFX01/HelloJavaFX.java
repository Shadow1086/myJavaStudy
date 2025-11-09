package JavaFX01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX 入门示例 - Hello World
 * 演示基本的JavaFX应用程序结构
 */
public class HelloJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 创建UI组件
        Label titleLabel = new Label("欢迎学习 JavaFX！");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label messageLabel = new Label("这是你的第一个JavaFX应用程序");
        messageLabel.setStyle("-fx-font-size: 14px;");

        Button clickButton = new Button("点击我");
        Label statusLabel = new Label("状态：等待交互");

        // 按钮点击事件处理
        clickButton.setOnAction(event -> {
            statusLabel.setText("状态：按钮被点击了！✓");
            messageLabel.setText("恭喜！你已经成功运行了JavaFX程序");
        });

        // 创建布局容器
        VBox root = new VBox(15); // 垂直布局，组件间距15px
        root.setPadding(new Insets(20)); // 内边距20px
        root.setAlignment(Pos.CENTER); // 居中对齐
        root.setStyle("-fx-background-color: #f0f0f0;"); // 背景色

        // 将组件添加到布局中
        root.getChildren().addAll(
            titleLabel,
            messageLabel,
            clickButton,
            statusLabel
        );

        // 创建场景
        Scene scene = new Scene(root, 400, 300);

        // 配置舞台（窗口）
        primaryStage.setTitle("JavaFX 学习示例");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); // 禁止调整窗口大小
        primaryStage.show();
    }

    public static void main(String[] args) {
        // 启动JavaFX应用程序
        launch(args);
    }
}
