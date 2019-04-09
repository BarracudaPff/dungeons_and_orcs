package com.mygdx.game.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.ecs.components.AnimationComponent;
import com.mygdx.game.ecs.components.SpriteComponent;

public class AnimationSystem extends IteratingSystem {

    ComponentMapper<SpriteComponent> tm;
    ComponentMapper<AnimationComponent> am;
    ComponentMapper<StateComponent> sm;

    @SuppressWarnings("unchecked")
    public AnimationSystem(){
        super(Family.all(SpriteComponent.class,
                AnimationComponent.class,
                StateComponent.class).get());

        tm = ComponentMapper.getFor(SpriteComponent.class);
        am = ComponentMapper.getFor(AnimationComponent.class);
        sm = ComponentMapper.getFor(StateComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

        AnimationComponent ani = am.get(entity);
        StateComponent state = sm.get(entity);

        if(ani.animations.containsKey(state.get())){
            SpriteComponent tex = tm.get(entity);
            tex.region = (TextureRegion) ani.animations.get(state.get()).getKeyFrame(state.time, state.isLooping);
        }

        state.time += deltaTime;
    }
}
