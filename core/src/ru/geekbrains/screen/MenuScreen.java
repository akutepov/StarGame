package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture bg;
    private Vector2 pos;
    private Background background;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        bg = new Texture("bg.png");
        pos = new Vector2();
        background = new Background(new TextureRegion(bg));
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.2f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        batch.draw(img, 0f, 0f, 0.5f, 0.5f);
        batch.end();
    }

    @Override
    public void dispose() {
        img.dispose();
        bg.dispose();
        super.dispose();
    }
}
