package main;

import entities.*;

/**
 * Created by Jan Kulose - s0557320 on 21.05.17.
 */
public class GameLogic {
    final static double GRAV = 1;


    public static void update(double t) {
        Planet.getPlanets().stream().filter(p -> p.getParent() != null).forEach(p -> {
            p.setX(p.getParent().getX() + p.getOrbitalDistance() * Math.cos(t * p.getOrbitalSpeed() * Entry.gamespeed));
            p.setY(p.getParent().getY() + p.getOrbitalDistance() * Math.sin(t * p.getOrbitalSpeed() * Entry.gamespeed));
            p.getBody().setRotate((p.getBody().getRotate() + p.getRotationSpeed() * Entry.gamespeed) % 360);
            p.getBody().setCenterX(p.getX());
            p.getBody().setCenterY(p.getY());
        });

        Weapon.getWeapons().stream().filter(w -> w.getOwner().getClass().equals(Planet.class)).forEach(w -> {
            double n = Planet.getPlanetByName(w.getOwner().getName()).getBody().getRotate();
            w.setX(w.getAnchor().getX()*Math.cos(n) + w.getOwner().getX());
            w.setY(w.getAnchor().getY()*Math.sin(n) + w.getOwner().getY());
            w.getBody().setLayoutX(w.getX());
            w.getBody().setLayoutY(w.getY());
        });

        Projectile.getProjectiles().forEach(p -> {
            updateVelX(p);
            updateVelY(p);
            p.setX(p.getX()+p.getVelX());
            p.setY(p.getY()+p.getVelY());
            p.getBody().setLayoutX(p.getX());
            p.getBody().setLayoutY(p.getY());
        });

    }

    private static void updateVelX(GameObject o) {
        Planet.getPlanets().forEach(p -> o.setVelX(o.getVelX() + Entry.gamespeed * p.getMass() * GRAV / Math.pow(calcDistance(o, p), 2) * ((p.getX() - o.getX())/calcDistance(o, p))));
    }

    private static void updateVelY(GameObject o) {
        Planet.getPlanets().forEach(p -> o.setVelY(o.getVelY() + Entry.gamespeed * p.getMass() * GRAV / Math.pow(calcDistance(o, p), 2) * ((p.getY() - o.getY())/calcDistance(o, p))));
    }

    private static double calcDistance(GameObject o1, GameObject o2) {
        return Math.sqrt(((o1.getX()-o2.getX()) * (o1.getX()-o2.getX())) + ((o1.getY()-o2.getY()) * (o1.getY()-o2.getY())));
    }

}
