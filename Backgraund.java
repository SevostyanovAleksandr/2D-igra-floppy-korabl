/** класс в котором мы создали движужайся фон для игры
 * с помощью создания массива и циклов
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Backgraund {
    class BGPicturies {



    private Texture tx;
    private Vector2 pos;
    public BGPicturies (Vector2 pos) {
        tx = new Texture("1.jpg");
        this.pos = pos;

    }
}
    private int speed;
    public BGPicturies [] bacs;

    public Backgraund (){
        speed = 5;
        bacs = new BGPicturies[2];
        bacs[0] = new BGPicturies(new Vector2(0,0));
        bacs[1] = new BGPicturies(new Vector2(1900,0));
    }
    public void render (SpriteBatch batch){
        for (int i = 0 ; i < bacs.length ; i++) {
            batch.draw(bacs[i].tx, bacs[i].pos.x,bacs[i].pos.y);
        }

    }
    public void update (){
        for (int i = 0 ; i < bacs.length ; i++){
            bacs[i].pos.x -= speed;
        }

        if (bacs[0].pos.x < -1900){
            bacs[0].pos.x= 0;
            bacs[1].pos.x = 1900;
        }

    }

}

