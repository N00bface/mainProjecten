package main;

import resources.Enemy;

import java.awt.*;
import java.io.IOException;

/**
 * Created by Jari on 23/12/2015.
 */
public class Environment {
    private World world = new World();
    public Environment() {

    }
    public void newLevel(int level) throws IOException {
        switch (level){
            case 1:
                world.makeWorld();
                for (int i = 0; i < 3; i++) {
                    spawnEnemy(1);
                }
                break;
            case 2:
                break;
            default:
                break;
        }
    }

    public void spawnEnemy(int tier) {
        //reset current environment

        switch (tier){
            case 1:
                new Enemy(tier,"basic",1,new Point(100,100),8);
                break;
            case 2:
                new Enemy(tier,"medium",3,new Point(100,100),10);
                break;
            case 3:
                new Enemy(tier,"advanced",5,new Point(100,100),5);
                break;
            case 4:
                new Enemy(tier,"boss",10,new Point(100,100),2);
                break;
            default:
                break;
        }
    }
}
