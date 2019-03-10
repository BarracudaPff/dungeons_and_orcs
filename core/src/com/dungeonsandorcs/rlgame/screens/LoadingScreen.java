package com.dungeonsandorcs.rlgame.screens;

import com.badlogic.gdx.Screen;
import com.dungeonsandorcs.rlgame.DungeonGame;

public class LoadingScreen implements Screen {



    private DungeonGame parent;

    public LoadingScreen(DungeonGame parent) {
        this.parent = parent;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
     parent.changeScreen(DungeonGame.MENU);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
