package com.mygdx.game;



import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MyGdxGame extends ApplicationAdapter{


    private Skin skin;
    private TextButton button;
    private Stage stage;

    @Override
    public void create() {
        //make a stage for your button to go on
        stage = new Stage();

        //load a skin(a collection of styles for objects)
        // skin is from gdx-skins (https://github.com/czyzby/gdx-skins)
        skin = new Skin(Gdx.files.internal("glassy-ui.json"));

        //create your button
        button = new TextButton("Button1", skin);

        //add it to your stage
        stage.addActor(button);

        // add a listener to your buttons so it does something when clicked
        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("I was clicked");
            }
        });

        // set the sgae as the input processor so it will respond to clicks etc
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render() {
        //clear the screen
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell stage to do action and then draw itself
        stage.draw();
        stage.act();
    }
}