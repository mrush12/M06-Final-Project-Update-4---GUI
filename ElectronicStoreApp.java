import javax.swing.text.html.ListView;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ElectronicStoreApp extends Application {

    private ListView<String> productList;
    private ListView<String> cartList;
    private TextField usernameField;
    private PasswordField passwordField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Electronic Store");

        // Product List
        productList = new ListView<>();
        productList.getItems().addAll("Laptop", "Smartphone", "Tablet", "Headphones");

        // Cart List
        cartList = new ListView<>();

        // Add to Cart Button
        Button addToCartButton = new Button("Add to Cart");
        addToCartButton.setOnAction(e -> addToCart());

        // Checkout Button
        Button checkoutButton = new Button("Checkout");
        checkoutButton.setOnAction(e -> checkout());

        // Login Fields
        usernameField = new TextField();
        passwordField = new PasswordField();

        VBox loginBox = new VBox(5);
        loginBox.setAlignment(Pos.CENTER);
        loginBox.getChildren().addAll(new Label("Username:"), usernameField, new Label("Password:"), passwordField);

        HBox buttonsBox = new HBox(10);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.getChildren().addAll(addToCartButton, checkoutButton);

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(new Label("Products"), productList, buttonsBox, new Label("Cart"), cartList,
                loginBox);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void addToCart() {
        String selectedProduct = productList.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            cartList.getItems().add(selectedProduct);
        }
    }

    private void checkout() {
        // Implement code to handle checkout, e.g., processing the cart items.
    }
}
