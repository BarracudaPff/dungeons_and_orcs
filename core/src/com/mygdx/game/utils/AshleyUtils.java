package com.mygdx.game.utils;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;

public final class AshleyUtils {

    private AshleyUtils() {
    }

    public static final <T extends Component> boolean hasComponent(Entity e1, Class<T> component) {
        return e1.getComponent(component) != null;
    }

    public static final <T extends Component> void addComponents(Entity entity, Component... components) {
        for (Component component : components) {
            entity.add(component);
        }
    }

}
