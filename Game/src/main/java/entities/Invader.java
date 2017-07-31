package entities;

import javafx.scene.image.Image;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan Kulose - s0557320 on 20.05.17.
 */
public class Invader extends GameObject {
    private ArrayList<Weapon> weapons;
    private double speed;
    private Polygon body;
    private static List<GameObject> invaders = new ArrayList<>();

    public Invader(double x, double y,
                   double velX, double velY,
                   double health,
                   boolean visible,
                   boolean destructible,
                   Image texture,
                   ArrayList<Image> deathAnim,
                   String name,
                   ArrayList<Weapon> weapons,
                   double speed,
                   Polygon body) {
        super(x, y, velX, velY, health, visible, destructible, texture, deathAnim, name);
        this.weapons = weapons;
        this.speed = speed;
        this.body = body;
        invaders.add(this);
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Polygon getBody() {
        return body;
    }

    public void setBody(Polygon body) {
        this.body = body;
    }

    public static List<GameObject> getInvaders() {
        return invaders;
    }
}
