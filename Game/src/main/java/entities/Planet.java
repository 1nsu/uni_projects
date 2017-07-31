package entities;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan Kulose - s0557320 on 20.05.17.
 */
public class Planet extends GameObject {
    private double mass, rotationSpeed, orbitalSpeed, orbitalDistance;
    private Planet parent;
    private Ellipse body;
    private static List<Planet> planets = new ArrayList<>();


    public Planet(double x, double y,
                  double health,
                  boolean visible,
                  boolean destructible,
                  Image texture,
                  ArrayList<Image> deathAnim,
                  String name,
                  double mass,
                  double orbitalDistance,
                  double orbitalSpeed,
                  double rotationSpeed,
                  Ellipse body,
                  Planet parent) {
        super(x, y, 0, 0, health, visible, destructible, texture, deathAnim, name);
        this.mass = mass;
        this.body = body;
        this.orbitalDistance = orbitalDistance;
        this.orbitalSpeed = orbitalSpeed;
        this.rotationSpeed = rotationSpeed;
        this.body.setCenterX(x);
        this.body.setCenterY(y);
        this.parent = parent;
        this.body.setFill(new ImagePattern(texture));
        planets.add(this);
    }

    public Planet(double x, double y,
                  double health,
                  boolean visible,
                  boolean destructible,
                  Image texture,
                  ArrayList<Image> deathAnim,
                  String name,
                  double mass,
                  double orbitalDistance,
                  double orbitalSpeed,
                  double rotationSpeed,
                  double rX, double rY,
                  Planet parent) {
        super(x, y, 0, 0, health, visible, destructible, texture, deathAnim, name);
        this.mass = mass;
        this.body = new Ellipse(rX, rY);
        this.body.setCenterX(x);
        this.body.setCenterY(y);
        this.orbitalDistance = orbitalDistance;
        this.orbitalSpeed = orbitalSpeed;
        this.rotationSpeed = rotationSpeed;
        this.parent = parent;
        this.body.setFill(new ImagePattern(texture));
        planets.add(this);
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public Ellipse getBody() {
        return body;
    }

    public void setBody(Ellipse body) {
        this.body = body;
    }

    public double getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(double rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    public double getOrbitalSpeed() {
        return orbitalSpeed;
    }

    public void setOrbitalSpeed(double orbitalSpeed) {
        this.orbitalSpeed = orbitalSpeed;
    }

    public double getOrbitalDistance() {
        return orbitalDistance;
    }

    public void setOrbitalDistance(double orbitalDistance) {
        this.orbitalDistance = orbitalDistance;
    }

    public Planet getParent() {
        return parent;
    }

    public void setParent(Planet parent) {
        this.parent = parent;
    }

    public void setPosition(double x, double y) {
        this.setX(x);
        this.setY(y);
        body.setCenterX(x);
        body.setCenterY(y);
    }

    public static List<Planet> getPlanets() {
        return planets;
    }

    public static Planet getPlanetByName(String s) {
        return planets.stream().filter(e -> e.getName().equalsIgnoreCase(s)).findFirst().get();
    }

    @Override
    public String toString() {
        return "Planet{" +
                "mass=" + mass +
                ", rotationSpeed=" + rotationSpeed +
                ", orbitalSpeed=" + orbitalSpeed +
                ", orbitalDistance=" + orbitalDistance +
                ", parent=" + parent +
                ", body=" + body +
                '}';
    }
}
