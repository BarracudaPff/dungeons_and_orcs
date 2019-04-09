package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.AppConstants;
import com.mygdx.game.MyGdxGame;

public class MenuScreen extends BasicScreen {
    private Table table;
    private Skin skin;

    private Stage stage;

    public MenuScreen(MyGdxGame game) {
        super(game);
        init();

        TextButton newGame = new TextButton("New Game", skin);
        TextButton settings = new TextButton("Settings", skin);
        TextButton exit = new TextButton("Exit", skin);

        newGame.addListener(newGameListener);
        settings.addListener(settingsListener);
        exit.addListener(exitListener);

        table.add(newGame).pad(20).fillX().uniformX().row();
        table.add(settings).pad(20).fillX().uniformX().row();
        table.add(exit).pad(20).fillX().uniformX().row();

        stage.addActor(table);
    }

    private void init() {
        //Stage setup
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        //Table setup
        table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.addActor(table);

        //font setup
        // TODO: 09.04.2019 Implement font here

        //Main skin setup
        skin = new Skin(Gdx.files.internal("glassy/skin/glassy-ui.json"));
        //Maybe some styles here
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 1f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    private final EventListener newGameListener = new ChangeListener() {
        @Override
        public void changed(ChangeEvent event, Actor actor) {
            Gdx.app.log("New Game", "Clicked");
            setScreen(AppConstants.GAME);
        }
    };

    private final EventListener settingsListener = new ChangeListener() {
        @Override
        public void changed(ChangeEvent event, Actor actor) {
            Gdx.app.log("Settings", "Clicked");
        }
    };

    private final EventListener exitListener = new ChangeListener() {
        @Override
        public void changed(ChangeEvent event, Actor actor) {
            Gdx.app.log("Exit", "Clicked");
            Gdx.app.exit();
        }
    };
}
