package entities;

import javafx.scene.image.Image;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan Kulose - s0557320 on 20.05.17.
 */
public class Projectile extends GameObject {
    private double damage;
    private double speed;
    private Shape body;
    private GameObject owner;
    private static List<Projectile> projectiles = new ArrayList<>();

    public Projectile(double x,
                      double y,
                      double velX,
                      double velY,
                      double health,
                      boolean visible,
                      boolean destructible,
                      Image texture,
                      ArrayList<Image> deathAnim,
                      Shape body,
                      String name,
                      double damage,
                      double speed,
                      GameObject owner) {
        super(x, y, velX, velY, health, visible, destructible, texture, deathAnim, name);
        this.damage = damage;
        this.speed = speed;
        this.body = body;
        this.owner = owner;
        projectiles.add(this);
    }

    public Shape getBody() {
        return body;
    }

    public void setBody(Polygon body) {
        this.body = body;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public GameObject getOwner() {
        return owner;
    }

    public void setOwner(GameObject owner) {
        this.owner = owner;
    }

    public static List<Projectile> getProjectiles() {
        return projectiles;
    }

    @Override
    public String toString() {
        return "Projectile{" +
                "damage=" + damage +
                ", speed=" + speed +
                ", body=" + body +
                ", owner=" + owner +
                '}';
    }
}
