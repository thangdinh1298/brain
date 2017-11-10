package brain.FallingObjects.shapes;


import bases.Animation;
import bases.GameObject;
import bases.ImageRenderer;
import bases.Utils;
import brain.FallingObjects.FallingObjects;
import brain.background.Score;
import brain.playershape.PlayerLeftShape;
import brain.playershape.PlayerRightShape;


public class Diamond extends FallingObjects {

    public final int type = 3;
    public Diamond(){
        super();
//        this.renderer = new ImageRenderer("assets/shape/Diamond1.png");
        this.renderer = new Animation(
                Utils.loadImage("assets/shape/Diamond1.png"),
                Utils.loadImage("assets/shape/Diamond2.png"),
                Utils.loadImage("assets/shape/Diamond3.png"),
                Utils.loadImage("assets/shape/Diamond4.png"),
                Utils.loadImage("assets/shape/Diamond5.png"),
                Utils.loadImage("assets/shape/Diamond6.png")
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
                GameObject.remove(this);
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
