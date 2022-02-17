/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import modelo.Producto;

/**
 * FXML Controller class
 *
 * @author esteb
 */
public class MenuClienteController implements Initializable {

    @FXML
    private VBox cartaProductos;

    @FXML
    private Label productoLbl;

    @FXML
    private Label precioLbl;

    @FXML
    private Label totalLbl;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private ImageView productoImg;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private GridPane grid;

    @FXML
    private void comboBoxEvent(ActionEvent e) {

        if (comboBox.getSelectionModel().getSelectedItem().equals("1"))
        {
            totalLbl.setText(precioLbl.getText());

        } else if (comboBox.getSelectionModel().getSelectedItem().equals("2"))
        {
            totalLbl.setText("2");

        } else if (comboBox.getSelectionModel().getSelectedItem().equals("3"))
        {
            totalLbl.setText("3");

        } else if (comboBox.getSelectionModel().getSelectedItem().equals("4"))
        {
            totalLbl.setText("4");

        }

    }

    private List<Producto> listaProductos = new ArrayList<>();

    private Image image;
    private Producto producto;
    private MiEscuchador miEscuchador;

    private List<Producto> getData() {
        List<Producto> listaProductos = new ArrayList<>();
        Producto producto;

        producto = new Producto();
        producto.setNombre("Oreja");
        producto.setPrecio(3.80);
        producto.setImgSrc("/foodImages/oreja.jpg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        producto = new Producto();
        producto.setNombre("Magra");
        producto.setPrecio(3.80);
        producto.setImgSrc("/foodImages/magratomate.jpeg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        producto = new Producto();
        producto.setNombre("Queso frito");
        producto.setPrecio(4.50);
        producto.setImgSrc("/foodImages/queso-frito.jpg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        producto = new Producto();
        producto.setNombre("Tortilla");
        producto.setPrecio(2.50);
        producto.setImgSrc("/foodImages/tortilla.jpg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        producto = new Producto();
        producto.setNombre("Bravas");
        producto.setPrecio(3.00);
        producto.setImgSrc("/foodImages/bravas.jpg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        producto = new Producto();
        producto.setNombre("Carrillada");
        producto.setPrecio(11.50);
        producto.setImgSrc("/foodImages/carrilladacerdo.jpg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        producto = new Producto();
        producto.setNombre("Huevos rotos");
        producto.setPrecio(7.50);
        producto.setImgSrc("/foodImages/huevosrotosjamon.jpg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        producto = new Producto();
        producto.setNombre("Lubina");
        producto.setPrecio(14.70);
        producto.setImgSrc("/foodImages/lubina.jpg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        producto = new Producto();
        producto.setNombre("Pluma Ibérica");
        producto.setPrecio(17.20);
        producto.setImgSrc("/foodImages/plumaiberica.jpg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        producto = new Producto();
        producto.setNombre("Ensalada cesar");
        producto.setPrecio(3.50);
        producto.setImgSrc("/foodImages/ensaladacesar.jpg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        producto = new Producto();
        producto.setNombre("Ensalada pasta");
        producto.setPrecio(4.00);
        producto.setImgSrc("/foodImages/ensaladapastajpg.jpg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        producto = new Producto();
        producto.setNombre("Natillas");
        producto.setPrecio(2.00);
        producto.setImgSrc("/foodImages/natillas.jpg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        producto = new Producto();
        producto.setNombre("Tarta chocolate");
        producto.setPrecio(5.50);
        producto.setImgSrc("/foodImages/tartachocolate.jpg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        producto = new Producto();
        producto.setNombre("Tarta de queso");
        producto.setPrecio(4.20);
        producto.setImgSrc("/foodImages/tartaqueso.jpg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        producto = new Producto();
        producto.setNombre("Flan de huevo");
        producto.setPrecio(2.10);
        producto.setImgSrc("/foodImages/flanhuevo.jpg");
        producto.setColor("#ffffcc");
        listaProductos.add(producto);

        return listaProductos;
    }

    private void setProductoElegido(Producto producto) {

        //volver al primer item de la lista del combobox
        //comboBox.getSelectionModel().selectFirst();

        productoLbl.setText(producto.getNombre());
        precioLbl.setText(producto.getPrecio() + JavaFXApplication5.CURRENCY);
        totalLbl.setText(precioLbl.getText());
        image = new Image(getClass().getResourceAsStream(producto.getImgSrc()));
        productoImg.setImage(image);
        cartaProductos.setStyle("-fx-background-color:#" + producto.getColor() + ";\n"
                + "    -fx-background-radius: 30;");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaProductos.addAll(getData());

        if (listaProductos.size() > 0)
        {
            setProductoElegido(listaProductos.get(0));
            miEscuchador = new MiEscuchador() {

                @Override
                public void onClickListener(Producto producto) {
                    setProductoElegido(producto);

                }
            };
        }
        int column = 0;
        int row = 1;

        try
        {
            for (int i = 0; i < listaProductos.size(); i++)
            {
                FXMLLoader fmxlLoader = new FXMLLoader();
                fmxlLoader.setLocation(getClass().getResource("/javafxapplication5/Items.fxml"));
                AnchorPane anchorPane = fmxlLoader.load();

                ItemsController itemsController = fmxlLoader.getController();
                itemsController.setData(listaProductos.get(i), miEscuchador);

                if (column == 3)
                {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row); //child, column, row
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10, 10, 10, 10));
            }
        } catch (IOException ex)
        {
            Logger.getLogger(MenuClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

        /////////////combobox funciones - aniadir items//////////////////
        ArrayList<String> listaCantidades = new ArrayList<>();
        Collections.addAll(listaCantidades, new String[]
        {
            "1", "2", "3", "4"
        });
        comboBox.getItems().addAll(listaCantidades);

    }

}
