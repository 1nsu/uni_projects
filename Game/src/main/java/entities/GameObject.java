package entities;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan Kulose - s0557320 on 20.05.17.
 */
public abstract class GameObject {

    private double x, y, velX, velY, health;
    private boolean visible, destructible;
    private Image texture;
    private ArrayList<Image> deathAnim;
    private int id;
    private String name;
    private static List<GameObject> gameObjects = new ArrayList<>();
    private static int n = 0;


    public GameObject(double x,
                      double y,
                      double velX,
                      double velY,
                      double health,
                      boolean visible,
                      boolean destructible,
                      Image texture,
                      ArrayList<Image> deathAnim,
                      String name) {
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;
        this.health = health;
        this.visible = visible;
        this.destructible = destructible;
        this.texture = texture;
        this.deathAnim = deathAnim;
        this.id = n++;
        this.name = name;
        gameObjects.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getTexture() {
        return texture;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isDestructible() {
        return destructible;
    }

    public void setDestructible(boolean destructible) {
        this.destructible = destructible;
    }

    public ArrayList<Image> getDeathAnim() {
        return deathAnim;
    }

    public void setDeathAnim(ArrayList<Image> deathAnim) {
        this.deathAnim = deathAnim;
    }

    public static List<GameObject> getGameObjects() {
        return gameObjects;
    }
}
