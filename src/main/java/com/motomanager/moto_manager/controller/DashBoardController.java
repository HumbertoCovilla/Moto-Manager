package com.motomanager.moto_manager.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class DashBoardController {

    private final ApplicationContext context;

    @FXML
    private BorderPane mainContainer;

    public DashBoardController(ApplicationContext context){
        this.context = context;
    }

    @FXML
    public void mostrarInventario(){
        cargarVista("/fmxl/main.fxml");
    }

    private void cargarVista(String ruta){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
            loader.setControllerFactory(context::getBean);
            Parent vista = loader.load();

            mainContainer.setCenter(vista);
        }catch (IOException e){
            e.printStackTrace();
        }
    }



}
