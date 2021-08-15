package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch; //используеться для отрисовки  обьектов
	Backgraund bg;
	Korabl korabl;
	Obstacles obstacles;
	boolean gameover;
	Texture restarttextyre;


	@Override
	public void create() { // метод который загружает в память обьекты
		batch = new SpriteBatch();
		bg = new Backgraund();
		korabl = new Korabl();
		obstacles = new Obstacles();
		gameover = false;
		restarttextyre = new Texture("8.jpeg");//картинка еще разок


	}

	@Override
	public void render() {  // метод кторый отрисовывает 60 раз в секунду
		update();
		ScreenUtils.clear(1, 1, 1, 1); // игровое поле цвет
		batch.begin();// начало отрисовки
		bg.render(batch); //отрисовыывет картинку место согласно x и у

		//korabl.render(batch);// отрисовывает корбаль
		obstacles.render(batch);
		if (!gameover) {
			korabl.render(batch);
		} else {
			batch.draw(restarttextyre, 600, 600);




		}
		batch.end();

	}

	public void update() //для прощета математики игры для обновения игры  для обновления картинки
	{
		bg.update();// обновление позиции
		korabl.update();// обновдение позиции
		obstacles.update();
		for (int i = 0; i < Obstacles.obs.length; i++) {
			if (korabl.position.x > Obstacles.obs[i].position.x && korabl.position.x < Obstacles.obs[i].position.x +
					90) {// если корбаль леит между парой ттруб
				if (!Obstacles.obs[i].empty.contains(korabl.position)) {
					gameover = true;
				}

			}

		}
		if ( korabl.position.y < 0 || korabl.position.y > 1000 && Gdx.input.isKeyPressed(Input.Keys.SPACE ) || korabl.position.y > 1000   ){
			gameover = true;

		}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameover ){
        recreat();
		}
	}


		public void dispose() { // метод который очищает ресурсы
		batch.dispose();

	}
	public void recreat(){

		korabl.recreat();
		obstacles.recreat();
		gameover = false;
	}

}