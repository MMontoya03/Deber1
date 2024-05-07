package application;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            //Etiquetas
            MyLabel label1 = new MyLabel("Nombre y apellido", "C:/Users/User/Downloads/Imagen Usuario.jpg");
            MyLabel label2 = new MyLabel("Nombre y apellido", "C:/Users/User/Downloads/Imagen Usuario.jpg");
            MyLabel label3 = new MyLabel("Nombre y apellido", "C:/Users/User/Downloads/Imagen Usuario.jpg");
            MyLabel label4 = new MyLabel("Nombre y apellido", "C:/Users/User/Downloads/Imagen Usuario.jpg");
            MyLabel label5 = new MyLabel("Nombre y apellido", "C:/Users/User/Downloads/Imagen Usuario.jpg");
            MyLabel label6 = new MyLabel("Nombre y apellido", "C:/Users/User/Downloads/Imagen Usuario.jpg");
            MyLabel label7 = new MyLabel("Nombre y apellido", "C:/Users/User/Downloads/Imagen Usuario.jpg");
            MyLabel label8 = new MyLabel("Nombre y apellido", "C:/Users/User/Downloads/Imagen Usuario.jpg");

            // VBox con ScrollPane
            VBox labelsContainer = new VBox(label1, label2, label3, label4, label5, label6, label7, label8);
            ScrollPane scrollPane = new ScrollPane(labelsContainer);

            //ListView
            ObservableList<String> items = FXCollections.observableArrayList(
                    "Texto ... 1", "Texto ... 2", "Texto ... 3", "Texto ... 4", "Texto ... 5");
            ListView<String> listView = new ListView<>(items);

            // TextField
            TextField textField = new TextField();

            // VBox para contener el ListView y el TextField
            VBox vBox = new VBox(listView, textField);
            vBox.setSpacing(12); 

            // Añadimos los elementos al AnchorPane
            AnchorPane anchorPane = new AnchorPane();
            anchorPane.getChildren().addAll(scrollPane, vBox);

            // Establecemos las restricciones de anclaje para los elementos
            AnchorPane.setTopAnchor(scrollPane, 12.0);
            AnchorPane.setLeftAnchor(scrollPane, 12.0);
            AnchorPane.setBottomAnchor(scrollPane, 12.0);
            AnchorPane.setRightAnchor(scrollPane, 265.0);

            AnchorPane.setTopAnchor(vBox, 12.0);
            AnchorPane.setRightAnchor(vBox, 12.0);
            AnchorPane.setBottomAnchor(vBox, 12.0);
            AnchorPane.setLeftAnchor(vBox, 265.0);

            // Creamos la escena y la mostramos
            Scene scene = new Scene(anchorPane, 520, 430);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Tarea 1 <<Layout>>");
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Clase para integrar una imagen mediante un url de ruta
    class MyLabel extends Label {
        public MyLabel(String text, String imagePath) {
            super(text);
            try {
                //ruta de archivo a una URL válida
                File file = new File(imagePath);
                String imageUrl = file.toURI().toString();

                // Image utilizando la URL válida
                Image image = new Image(imageUrl);

                // Crear el ImageView y establecer la imagen
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(50); 
                imageView.setFitHeight(50); 

                // Establecer el ImageView como gráfico del label
                setGraphic(imageView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
