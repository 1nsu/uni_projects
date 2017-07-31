package main;

import entities.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * Created by Jan Kulose - s0557320 on 18.05.17.
 */
public class Entry extends Application {

    final public static int FPS = 60;
    public static double gamespeed = 1;

    public static void main(String... args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();


        primaryStage.setTitle("Game");

        final long startTime = System.currentTimeMillis();

        Group root = new Group();
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);

        InputStream is = cl.getResourceAsStream("sun.png");
        Planet sun = new Planet(scene.getWidth()/2, scene.getHeight()/2, 1000, true, false, new Image(is), new ArrayList<Image>(), "Sun", 200.0,
                0, 0, 0, new Ellipse(30, 30), null);

        is = cl.getResourceAsStream("earth.png");
        Planet earth = new Planet(100, 100, 1000, true, false, new Image(is), new ArrayList<Image>(), "Earth", 25.0,
                250, 0.2, 3.0, new Ellipse(10, 10), Planet.getPlanetByName("Sun"));

        is = cl.getResourceAsStream("moon.png");
        Planet moon = new Planet(100, 100, 500, true, false, new Image(is), new ArrayList<Image>(), "Moon", 4,
                20, 8.0, 0.5, new Ellipse(3, 3), Planet.getPlanetByName("Earth"));


        Timeline gameloop = new Timeline();
        gameloop.setCycleCount(Timeline.INDEFINITE);

        Slider speedSld = new Slider(0.01, 1, gamespeed);
        speedSld.setLayoutX(scene.getWidth()/2 - speedSld.getWidth()/2);
        speedSld.setOnMouseClicked(e -> {
            gamespeed = speedSld.getValue();
            System.out.println("new value = " + speedSld.getValue());
        });



        Canvas canvas = new Canvas(scene.getWidth(), scene.getHeight());
        root.getChildren().addAll(canvas, speedSld);

        scene.setOnMouseClicked(e -> {
            Projectile p1 = new Projectile(e.getSceneX(), e.getSceneY(), Math.random()*2, Math.random()*2, 100, true, false, null, null, new Circle(5), "p1", 10, 1, null);
            root.getChildren().add(p1.getBody());
        });

        scene.setOnKeyPressed(e -> {
            System.out.println(e.getEventType().toString());
        });


        try {
            is.close();
        } catch (IOException e) {
            System.err.println("couldn't close inputstream");
        }

        Planet.getPlanets().forEach(p -> root.getChildren().add(p.getBody()));
        Weapon.getWeapons().forEach(w -> root.getChildren().add(w.getBody()));

        GraphicsContext gc = canvas.getGraphicsContext2D();

        KeyFrame kf = new KeyFrame(
                Duration.millis(1000/FPS),
                e -> {
                    double t = (System.currentTimeMillis() - startTime) / 1000.0;
                    GameLogic.update(t);

                }
        );

        gameloop.getKeyFrames().addAll(kf);
        gameloop.play();

        primaryStage.show();

    }

}
