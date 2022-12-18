package com.project.ldts.model.game.arena;

import com.project.ldts.model.Position;
import com.project.ldts.model.game.elements.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.Math.abs;

public class Arena {
    private final int width;
    private final int height;
    private List<Wall> walls;
    private List<Water> waters;
    private List<Sand> sand;
    private Player player;
    private List<Enemy> enemies;
    private List<Bullet> bullets;
    private List<SafeHouse> safeHouses;
    private List<SpecialBox> specialBoxes;
    private int seconds;
    private int minutes;
    DecimalFormat dFormat;
    private String dminutes;
    private String dseconds;
    private char power;
    private int powerTime;

    public Arena(int width, int height){
        this.width = width;
        this.height = height;

        this.bullets = new CopyOnWriteArrayList<>();

        this.seconds = 0;
        this.minutes = 5;

        this.dFormat = new DecimalFormat("00");
        this.dminutes = dFormat.format(minutes);
        this.dseconds = dFormat.format(seconds);

        this.power = ' ';
        this.powerTime = 0;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setMinutes(int minutes){
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setDminutes(int minutes) {
        this.dminutes = dFormat.format(minutes);
    }

    public void setDseconds(int seconds) {
        this.dseconds = dFormat.format(seconds);
    }

    public String getDminutes(){ return dminutes;}

    public String getDseconds() {
        return dseconds;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> monsters) {
        this.enemies = monsters;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Water> getWaters() {
        return waters;
    }

    public void setWaters(List<Water> waters) {
        this.waters = waters;
    }

    public List<Sand> getSand() {
        return sand;
    }

    public void setSand(List<Sand> sands) {
        this.sand = sands;
    }

    public List<SafeHouse> getSafeHouses() {
        return safeHouses;
    }

    public void setSafeHouses(List<SafeHouse> safeHouses) {
        this.safeHouses = safeHouses;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<Bullet> bullets) {
        this.bullets = bullets;
    }

    public List<SpecialBox> getSpecialBoxes() {return specialBoxes;}

    public void setSpecialBoxes(List<SpecialBox> specialBoxes) {this.specialBoxes = specialBoxes;}

    public char getPower() {return this.power;}

    public void setPower(char power) {this.power = power;}

    public int getPowerTime() {return this.powerTime;}

    public void setPowerTime(int powerTime) {this.powerTime = powerTime;}


    public char whereToDraw(Position pos){
        for(Sand sa: sand){
            if(pos.equals(sa.getPosition()))
                return 's';
        }
        for(Water water: waters){
            if(pos.equals(water.getPosition()))
                return 'w';
        }
        return 'f';
    }

    public boolean canMove(Position pos){
        if((pos.getX() < 0 || pos.getY() < 1))
            return false;
        if(pos.getX() >= width || pos.getY() >= height)
            return false;
        for(Wall wall: walls){
            if(wall.getPosition().equals(pos))
                return false;
        }
        for(SpecialBox sb: specialBoxes){
            if(sb.getPosition().equals(pos))
                return false;
        }
        return true;
    }

    public boolean isPlayerAlive(){
        return player.getHealth() >= 1;
    }

    public void safeHouseEffect(Position pos){
        for(SafeHouse sh: safeHouses){
            if(sh.getPosition().equals(pos) && sh.isActive()){
                player.increaseHealth();
                sh.setActive(false);
            }
        }
    }

    public void firePlayerShots(){
        bullets.add(new Bullet(player.getPosition().getX(), player.getPosition().getY(), player.getDirection()));
    }

    public void fireEnemyShots(Enemy enemy){
        int eX = enemy.getPosition().getX();
        int eY = enemy.getPosition().getY();
        int pX = player.getPosition().getX();
        int pY = player.getPosition().getY();
        int xDiff = eX - pX;
        int yDiff = eY - pY;
        if(abs(xDiff) < 10 && abs(yDiff) < 10){
            if(eX == pX && eY < pY)
                bullets.add(new Bullet(enemy.getPosition().getX(), enemy.getPosition().getY(), 'd'));
            if(eX == pX && eY > pY)
                bullets.add(new Bullet(enemy.getPosition().getX(), enemy.getPosition().getY(), 'u'));
            if(eX < pX && eY == pY)
                bullets.add(new Bullet(enemy.getPosition().getX(), enemy.getPosition().getY(), 'r'));
            if(eX > pX && eY == pY)
                bullets.add(new Bullet(enemy.getPosition().getX(), enemy.getPosition().getY(), 'l'));
        }
    }

    public void verifyHit(Bullet bullet){
        for(Wall wall: walls){
            if(wall.getPosition().equals(bullet.getPosition()))
                bullets.remove(bullet);
        }
        if(player.getPosition().equals(bullet.getPosition()) && isOnWater(player.getPosition()) && power != 'i'){
            bullets.remove(bullet);
            player.decreaseHealth();
        }
        for(Enemy enemy: enemies){
            if(enemy.getPosition().equals(bullet.getPosition()) && power == 'p'){
                bullets.remove(bullet);
                enemies.remove(enemy);
            }
            if (enemy.getPosition().equals(bullet.getPosition()) && isOnWater(enemy.getPosition())){
                bullets.remove(bullet);
                enemy.decreaseHealth();
            }
        }
        if(bullet.getPosition().getX() < 0 || bullet.getPosition().getY() < 1)
            bullets.remove(bullet);
        if(bullet.getPosition().getX() >= width || bullet.getPosition().getY() >= height)
            bullets.remove(bullet);
    }

    public boolean isOnWater(Position pos){
        for(Water water: waters){
            if(water.getPosition().equals(pos))
                return false;
        }
        return true;
    }

    public void playerEnemyCollision(Enemy enemy){
        if(enemy.getPosition().equals(player.getPosition())){
            enemy.increaseHealth();
            player.decreaseHealth();
        }
    }

    public void collectPower(){
        for (SpecialBox sb: specialBoxes){
            if(player.getPosition().checkIfNear(sb.getPosition()) && !sb.isUsed()){
                power = sb.getRandomPower();
                powerTime = 15;
                sb.setUsed(true);
            }
        }
    }
}
