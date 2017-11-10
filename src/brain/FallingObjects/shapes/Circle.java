package brain.FallingObjects.shapes;

import bases.Animation;
import bases.GameObject;
import bases.ImageRenderer;
import bases.Utils;
import brain.FallingObjects.FallingObjects;
import brain.background.Score;
import brain.playershape.PlayerLeftShape;
import brain.playershape.PlayerRightShape;


public class Circle extends FallingObjects {

    public final int type = 0;

    public Circle(){
        super();

        this.renderer = new Animation(
                Utils.loadImage("assets/shape/circle.png"),
                Utils.loadImage("assets/shape/circle1.png"),
                Utils.loadImage("assets/shape/circle2.png"),
                Utils.loadImage("assets/shape/circle3.png"),
                Utils.loadImage("assets/shape/circle4.png"),
                Utils.loadImage("assets/shape/circle5.png"),
                Utils.loadImage("assets/shape/circle6.png")

        );
    }

    @Override
    public void run() {
        super.run();
        collide();
    }

    public void collide(){
        if(this.position.x < 200){
            if(this.hitBox.collideWith(PlayerLeftShape.boxCollider) && this.type == PlayerLeftShape.currentType){
                Score.addScore(1);
                GameObject.remove(this);//remove object from gameobject vector
            }
        }
        if(this.position.x > 200){
            if(this.hitBox.collideWith(PlayerRightShape.boxCollider) && this.type == PlayerRightShape.currentType ){
                Score.addScore(1);
                GameObject.remove(this);
            }
        }

    }
}
