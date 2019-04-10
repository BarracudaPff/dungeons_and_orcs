package com.mygdx.game.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.controllers.KeyboardController;
import com.mygdx.game.systems.CollisionSystem;
import com.mygdx.game.systems.Box2DDebugRendererSystem;
import com.mygdx.game.utils.BodyFactory;
import com.mygdx.game.utils.EntityUtils;

public class GameScreen extends BasicScreen {
    private OrthographicCamera camera;
    private Engine engine;
    private World world;

    public GameScreen(MyGdxGame game) {
        super(game);

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        world = new World(new Vector2(0, 0), false);

        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1f);

        //create a pooled engine
        engine = new Engine();

        // TODO: 09.04.2019 add entity
        engine.addEntity(EntityUtils.createPlayer());

        // add all the relevant systems our engine should run
        engine.addSystem(new Box2DDebugRendererSystem());
        engine.addSystem(new CollisionSystem());

        // create some game objects
        createPlayer();
        createPlatform(2, 2);
        createPlatform(2, 7);
        createPlatform(7, 2);
        createPlatform(7, 7);

        createFloor();

    }

    private void createPlatform(float x, float y) {
        Entity entity = engine.createEntity();
        /*Box2DComponent b2dbody = engine.createComponent(Box2DComponent.class);
        b2dbody.body = bodyFactory.makeBoxPolyBody(AppConstants.Material.STONE,
                BodyDef.BodyType.StaticBody, x, y, 3, 0.2f);
        SpriteComponent texture = engine.createComponent(SpriteComponent.class);
        texture.region = atlas.findRegion("player");
        TypeComponent type = engine.createComponent(TypeComponent.class);
        type.type = TypeComponent.SCENERY;
        b2dbody.body.setUserData(entity);

        entity.add(b2dbody);
        entity.add(texture);
        entity.add(type);*/

        engine.addEntity(entity);

    }

    private void createFloor() {
        Entity entity = engine.createEntity();
        /*Box2DComponent b2dbody = engine.createComponent(Box2DComponent.class);
        b2dbody.body = bodyFactory.makeBoxPolyBody(AppConstants.Material.STONE, BodyDef.BodyType.StaticBody, 0, 0, 100, 0.2f);
        SpriteComponent texture = engine.createComponent(SpriteComponent.class);
        texture.region = atlas.findRegion("player");
        TypeComponent type = engine.createComponent(TypeComponent.class);
        type.type = TypeComponent.SCENERY;


        b2dbody.body.setUserData(entity);

        entity.add(b2dbody);
        entity.add(texture);
        entity.add(type);*/

        engine.addEntity(entity);
    }


    private void createPlayer() {
        Entity entity = engine.createEntity();
        /*Box2DComponent b2dbody = engine.createComponent(Box2DComponent.class);
        TransformComponent position = engine.createComponent(TransformComponent.class);
        SpriteComponent texture = engine.createComponent(SpriteComponent.class);
        PlayerComponent player = engine.createComponent(PlayerComponent.class);
        CollisionComponent colComp = engine.createComponent(CollisionComponent.class);
        TypeComponent type = engine.createComponent(TypeComponent.class);
        StateComponent stateCom = engine.createComponent(StateComponent.class);

        b2dbody.body = bodyFactory.makeCirclePolyBody(10, 10, 1, AppConstants.Material.STONE, BodyDef.BodyType.DynamicBody, true);
        // set object position (x,y,z) z used to define draw order 0 first drawn
        position.position.set(10, 10, 0);
        texture.region = atlas.findRegion("player");
        type.type = TypeComponent.PLAYER;
        stateCom.set(StateComponent.STATE_NORMAL);
        b2dbody.body.setUserData(entity);

        entity.add(b2dbody);
        entity.add(position);
        entity.add(texture);
        entity.add(player);
        entity.add(colComp);
        entity.add(type);
        entity.add(stateCom);*/

        engine.addEntity(entity);

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        world.step(delta, 6, 2);
        engine.update(delta);
    }

    @Override
    public void resize(int width, int height) {
    }
}
