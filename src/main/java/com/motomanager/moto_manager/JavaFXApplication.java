package com.motomanager.moto_manager;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

public class JavaFXApplication extends Application{

    private ConfigurableApplicationContext context;

    @Override
    public void init(){
        this.context = new SpringApplicationBuilder()
                .sources(MotoManagerApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage stage){
        context.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop(){
        context.close();
        Platform.exit();
    }

    static class StageReadyEvent extends org.springframework.context.ApplicationEvent{
        public StageReadyEvent(Stage stage){
            super(stage);
        }
        public Stage getStage(){
            return (Stage) getSource();
        }
    }

}


