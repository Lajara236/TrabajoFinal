/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.awt.PageAttributes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import modelo.Producto;

/**
 * FXML Controller class
 *
 * @author esteb
 */
 public class ItemsController implements Initializable {

    @FXML
    private Label nombreLbl;

    @FXML
    private Label precioLbl;

    @FXML
    private ImageView imagen;
    
    @FXML
    private void click(MouseEvent mouseEvent){
        miEscuchador.onClickListener(producto);
    }
    
   
    
    
    
    private Producto producto;
    
    private MiEscuchador miEscuchador;
    
    public void setData(Producto producto, MiEscuchador miEscuchador){
        this.producto=producto;
        this.miEscuchador=miEscuchador;
        nombreLbl.setText(producto.getNombre());
        precioLbl.setText(producto.getPrecio() + JavaFXApplication5.CURRENCY);
        Image image = new Image(getClass().getResourceAsStream(producto.getImgSrc()));
        imagen.setImage(image);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
