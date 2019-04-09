package com.mygdx.game.units;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.mygdx.game.AppConstants;
import com.mygdx.game.ecs.components.AnimationComponent;
import com.mygdx.game.ecs.components.Box2DComponent;
import com.mygdx.game.ecs.components.CollisionComponent;
import com.mygdx.game.ecs.components.PlayerComponent;
import com.mygdx.game.ecs.components.SpriteComponent;
import com.mygdx.game.ecs.components.TransformComponent;
import com.mygdx.game.ecs.components.TypeComponent;

public class Player extends Entity {
    private AnimationComponent animation;
    private Box2DComponent body;
    private CollisionComponent collision;
    private PlayerComponent player;
    private StateComponent state;
    private SpriteComponent texture;
    private TransformComponent transform;
    private TypeComponent type;

    public Player(BodyFactory bodyFactory, TextureAtlas atlas) {
        Box2DComponent b2dbody = new Box2DComponent();
        TransformComponent position = new TransformComponent();
        SpriteComponent texture = new SpriteComponent();
        PlayerComponent player = new PlayerComponent();
        CollisionComponent colComp = new CollisionComponent();
        TypeComponent type = new TypeComponent();
        StateComponent stateCom = new StateComponent();

        b2dbody.body = bodyFactory.makeCirclePolyBody(10, 10, 1, AppConstants.Material.STONE, BodyDef.BodyType.DynamicBody, true);
        // set object position (x,y,z) z used to define draw order 0 first drawn
        position.position.set(10, 10, 0);
        texture.region = atlas.findRegion("player");
        type.type = TypeComponent.PLAYER;
        stateCom.set(StateComponent.STATE_NORMAL);
        b2dbody.body.setUserData(this);
    }

    public void register(PooledEngine engine) {
        engine.addEntity(this);
    }
}
