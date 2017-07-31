package entities;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan Kulose - s0557320 on 20.05.17.
 */
public class Weapon extends GameObject {
    private double damage, rotation;
    private Polygon body;
    private WeaponType type;
    private GameObject owner;
    private Point2D anchor;
    private static List<Weapon> weapons = new ArrayList<>();

    public Weapon(double x, double y,
                  double health,
                  boolean visible,
                  boolean destructible,
                  Image texture,
                  ArrayList<Image> deathAnim,
                  String name,
                  double damage,
                  double rotation,
                  Polygon body,
                  WeaponType type,
                  Point2D anchor,
                  GameObject owner) {
        super(x, y, 0, 0, health, visible, destructible, texture, deathAnim, name);
        this.damage = damage;
        this.rotation = rotation;
        this.body = body;
        this.type = type;
        this.anchor = anchor;
        this.owner = owner;
        weapons.add(this);
    }

    public Weapon(double health,
                  boolean visible,
                  boolean destructible,
                  Image texture,
                  ArrayList<Image> deathAnim,
                  String name,
                  double damage,
                  double rotation,
                  Polygon body,
                  WeaponType type,
                  Point2D anchor) {
        super(anchor.getX(), anchor.getY(), 0, 0, health, visible, destructible, texture, deathAnim, name);
        this.damage = damage;
        this.rotation = rotation;
        this.body = body;
        this.type = type;
        this.anchor = anchor;
        weapons.add(this);
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public GameObject getOwner() {
        return owner;
    }

    public void setOwner(GameObject owner) {
        this.owner = owner;
    }

    public Point2D getAnchor() {
        return anchor;
    }

    public void setAnchor(Point2D anchor) {
        this.anchor = anchor;
    }

    public Polygon getBody() {
        return body;
    }

    public void setBody(Polygon body) {
        this.body = body;
    }

    public static List<Weapon> getWeapons() {
        return weapons;
    }

    public enum WeaponType {
        MISSILE("Missile"),
        GUN("Gun"),
        LASER("Laser");

        final String name;

        WeaponType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
