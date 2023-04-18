package com.mygdx.game;



import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MyGdxGame extends ApplicationAdapter{


    private Skin skin;
    private Skin skin2;
    private TextButton button;
    private TextButton button2;
    private TextButton button3;
    private Stage stage;
    private Label nameLabel;
    private TextField nameText;
    private  Label addressLabel ;
    private TextField addressText ;
    private Table table;

    @Override
    public void create() {
        //make a stage for your button to go on
        stage = new Stage();

        //load a skin(a collection of styles for objects)
        // skin is from gdx-skins (https://github.com/czyzby/gdx-skins)
        skin = new Skin(Gdx.files.internal("skin//glassy-ui.json"));
        skin2 = new Skin(Gdx.files.internal("skin//neon-ui.json"));
        //create your button
        button = new TextButton("Button1", skin);
        button3 = new TextButton("Button1", skin);
        button2 = new TextButton("Button1", skin2);
        Label nameLabel = new Label("Name:", skin);
        TextField nameText = new TextField(" ",skin);
        Label addressLabel = new Label("Address:", skin);
        TextField addressText = new TextField("" ,skin);

        //add it to your stage
        
        table = new Table(skin);
       
       
        table.add(button);              // Row 0, column 0.
       
        table.row(); 
        				// Move to next row.
        table.add(button2);      
        	// Row 1, column 0.
        table.top().left();
        table.setFillParent(true);
        table.debug();
        
        stage.addActor(table);
        
        
      
        // add a listener to your buttons so it does something when clicked
        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("I was clicked");
            }
        });
        
        button2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("babuin");
                table.add(button3);
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