package resources;

import java.awt.*;

/**
 * Created by Jari on 23/12/2015.
 */
public class Enemy {
    private final int movespeed;
    private int grade;
    private String name;
    private int lives;
    private Point position;

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public Point getPosition() {
        return position;
    }

    public int getMovespeed(){
        return movespeed;
    }
    public void setPosition(Point position){
        this.position = position;
    }


    public  Enemy(int grade,String name,int lives,Point position, int movespeed){
        this.grade = grade;
        this.name = name;
        this.lives = lives;
        this.position = position;
        this.movespeed = movespeed;
    }

}
