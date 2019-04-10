package com.mygdx.game.systems;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

public class Box2DDebugRendererSystem extends EntitySystem {

    private Box2DDebugRenderer debugRenderer;

    public Box2DDebugRendererSystem() {
        this.debugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        debugRenderer.render(Objects.world, Objects.camera.combined);
    }
}
