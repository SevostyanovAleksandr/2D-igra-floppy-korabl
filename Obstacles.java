package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Obstacles {
    class WallPair {

        Vector2 position;
        float speed;
        int offset;
        Rectangle empty;// пустое расстояние между трубами

        public WallPair(Vector2 pos) {
            position = pos;
            speed = 3;
            offset = new Random().nextInt(250); //переменная для того чтобы двигать трубы
            empty = new Rectangle(position.x, position.y - offset + 430, 90, betweenDistance);
        }

        public void update() {
            position.x -= speed;
            if (position.x < -100) {
                position.x = 1800;
                offset = new Random().nextInt(250);// чтобы труба
                // была представлена всегда по разному
            }
               empty.x = position.x;//
        }
    }

    static WallPair[] obs;// трубы парные cтатик чтобыможно было полуучить доступ отовсюду
    Texture txt; //картинка
    int betweenDistance; //расстояние между этими трубами

    public Obstacles() {
        txt = new Texture("7.png"); //обьект картинка
        obs = new WallPair[4];//создал обьект масссив из 4 обьектов
        betweenDistance = 400;// расстояние между трубами по вертикали
        int startposx = 400;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startposx, 0));
            startposx += 520;
        }
    }

    public void render(SpriteBatch batch) { // метод для отображения
        for (int i = 0; i < obs.length; i++) { // проходимся циклом по всем нашим препядствиям
            // и говорим ему
            batch.draw(txt, obs[i].position.x, obs[i].position.y  - obs[i].offset); // отрисовка нижних труб
            batch.draw(txt, obs[i].position.x, obs[i].position.y + betweenDistance + txt.getHeight() - obs[i].offset);
            //выше отрисовка верхних труб
        }
    }

    public void update() { // метод для общета математике
        for (int i = 0; i < obs.length; i++) {
            obs[i].update();

        }
    }

    public void recreat() {
        int startposx = 400;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startposx, 0));
            startposx += 420;
        }

    }
}