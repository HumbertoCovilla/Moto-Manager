package com.motomanager.moto_manager;

import com.motomanager.moto_manager.JavaFXApplication.StageReadyEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Value("classpath:/fxml/main.fxml")
    private Resource mainFxml;

    private final ConfigurableApplicationContext applicationContext;


    public StageInitializer(ConfigurableApplicationContext applicationContext) {

        this.applicationContext = applicationContext;
    }



    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            //Cargo el dashboard
            FXMLLoader dashLoader = new FXMLLoader(getClass().getResource("/fxml/dashboard.fxml"));
            dashLoader.setControllerFactory(applicationContext::getBean);
            Parent dashboardRoot = dashLoader.load();

            //Cargamos vista de inventario
            //FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            //mainLoader.setControllerFactory(applicationContext::getBean);
            //Parent inventoryView = mainLoader.load();

            FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
            homeLoader.setControllerFactory(applicationContext::getBean);
            Parent homeView = homeLoader.load();
            BorderPane root = (BorderPane) dashboardRoot;
            root.setCenter(homeView);

            //BorderPane root = (BorderPane) dashboardRoot;
            //root.setCenter(inventoryView);

            //Mostrar la ventana principal
            Stage stage = event.getStage();
            stage.setScene(new Scene(root));
            stage.setTitle("MotoManager");
            stage.show();


        } catch (IOException e) {
            throw new RuntimeException("Error al cargar MotoManager", e);
        }
    }


}
