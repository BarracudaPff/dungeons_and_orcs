package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.LoadingScreen;
import com.mygdx.game.screens.MenuScreen;
import com.mygdx.game.utils.AppConstants;
import com.mygdx.game.utils.B2dAssetManager;

public class MyGdxGame extends Game {
    private LoadingScreen loadingScreen;
    private MenuScreen menuScreen;
    private GameScreen gameScreen;
    public B2dAssetManager assMan = new B2dAssetManager();

    @Override
    public void create() {
        changeScreen(AppConstants.LOADING);
    }

    public void changeScreen(int screenId) {
        System.out.println(screenId);
        switch (screenId) {
            case AppConstants.LOADING:
                if (loadingScreen == null)
                    loadingScreen = new LoadingScreen(this);
                setScreen(loadingScreen);
                break;
            case AppConstants.MENU:
                if (menuScreen == null)
                    menuScreen = new MenuScreen(this);
                setScreen(menuScreen);
                break;
            case AppConstants.GAME:
                if (gameScreen == null)
                    gameScreen = new GameScreen(this);
                setScreen(gameScreen);
                break;
        }
    }
}
