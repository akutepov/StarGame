package ru.geekbrains.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.pool.ExplosionPool;

public abstract class Ship extends Sprite {

    protected Vector2 v0;
    protected Vector2 v;
    protected Vector2 bulletV;
    protected float bulletHeight;
    protected int damage;
    protected BulletPool bulletPool;
    protected ExplosionPool explosionPool;
    protected Rect worldBounds;
    protected Sound shootSound;
    protected TextureRegion bulletRegion;
    protected int hp;

    protected float reloadInterval;
    protected float reloadTimer;

    public Ship(TextureRegion region, int rows, int cols, int frames) {
        super(region, rows, cols, frames);
    }

    public Ship() {
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
    }

    @Override
    public void destroy() {
        super.destroy();
        boom();
    }

    protected void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, bulletV, bulletHeight, worldBounds, damage);
        shootSound.play();
    }

    protected void boom() {
        Explosion explosion = explosionPool.obtain();
        explosion.set(getHeight(), pos);
    }
}