/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import Utile.util;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JColorChooser;

/**
 *
 * @author esteb
 */
public class FXMLDocumentController implements Initializable {

    /**
     * FXML Controller class
     *
     * @author esteban
     */
    @FXML
    private Button salirBtn;

    @FXML
    private TextField usuarioTxt;

    @FXML
    private PasswordField pwTxt;

    @FXML
    private Button loginBtn;

    @FXML
    private Label olvidarLbl;

    @FXML
    private Label errorLbl;

    @FXML
    private Button ojoBtn;

    @FXML
    private Label mostrarPwLbl;

    boolean activo = false;

    private String mensajeError = "";

    @FXML

    void ojoClick(ActionEvent event) {

        mostrarPwLbl.setVisible(true);
        mostrarPwLbl.setText(pwTxt.getText());

    }

    private boolean campoRelleno() {
        boolean rellenado = true;
        if (usuarioTxt.getText().isEmpty()) {
            rellenado = false;
            mensajeError = "Usuario vacío.";

        }
        if (pwTxt.getText().isEmpty()) {
            rellenado = false;
            if (mensajeError.isEmpty()) {
                mensajeError = "Contraseña vacía.";
            } else {
                mensajeError += "\nContraseña vacía.";

            }

        }
        errorLbl.setText(mensajeError);
        return rellenado;
    }

    @FXML
    private void salirAction(ActionEvent event) {
        System.exit(0);

    }

    //NUEVA VENTANA DEL MENU DEL CLIENTE :D
    private void clienteMenuwindow() {

        try {
            Stage secondStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("MenuCliente.fxml"));
            //stage.setMaximized(true);
            secondStage.setTitle("Gestorante - Menu del Cliente");
            secondStage.setScene(new Scene(root));
            secondStage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void loginAction(ActionEvent event) throws SQLException {
        mensajeError = "";
        if (campoRelleno()) {
            String nombre = usuarioTxt.getText();
            String contrasenia = pwTxt.getText();
            Utile.util.conectorQuerySELECT(nombre, contrasenia);
            Alert alert = new Alert(AlertType.INFORMATION, "Bienvenido,  " + nombre + ", gracias por elegirnos, no te arrepentiras!.", ButtonType.OK);

            alert.initStyle(StageStyle.UNDECORATED);
            alert.setGraphic(new ImageView(this.getClass().getResource("/icons/welcome.png").toString()));
            alert.setHeaderText(null);

            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(
                    this.getClass().getResource("/styles/EstiloAlertas.css").toExternalForm());
            dialogPane.getStyleClass().add("myDialog");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                clienteMenuwindow();
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarPwLbl.setVisible(false);

    }

}
