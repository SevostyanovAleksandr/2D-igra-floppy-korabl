package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Korabl {
    Texture img; // поле картинка
    Vector2 position;
    float vy; // движение корабля вниз сила приятжения
    float gravity; // на сколько ускоряетьсяя падение

    public Korabl() {
        img = new Texture("4.png");
        position = new Vector2(200,500);
        vy= 0;
        gravity = - 0.7f;

    }

    /**
     * метод котороый принимает параметр спрайт батч который
     * с помощью этого обьекта мы отрисовывеваем все объекты
     */
    public void render(SpriteBatch batch) {
        batch.draw(img, position.x, position.y);//графическая команда которая отрисовывет обьект


    }

    /**
     * метод который обновляет положение объекта
     */
    public void update() {
       // реакция на кнопку спайс
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            vy = 5;// то меняем положение
        }
        vy += gravity; // увеличиваем скорость движения падения
        position.y += vy;  // меням позицию корабля на vy
}
    public void recreat(){
        position = new Vector2(200,500);
        vy = 0;
    }
}