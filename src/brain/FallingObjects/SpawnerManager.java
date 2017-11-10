package brain.FallingObjects;

import bases.GameObject;
import bases.Vector2D;
import bases.actions.*;
import brain.background.Score;
import brain.traps.TrapSpawner;

public class SpawnerManager extends GameObject {
    Spawner leftSpawner;
    Spawner rightSpawner;
    public SpawnerManager(){

        Action waitAction = new ActionWait(1200);
        Action waitAction2 = new ActionWait(1200);
        Action waitAction3 = new ActionWait(1200);
        Action fallingLeftAction = new Action() {
            @Override
            public boolean run(GameObject owner) {
                GameObject.remove(rightSpawner);
                leftSpawner = new Spawner(new Vector2D(105,-20));
                GameObject.add(leftSpawner);
                return true;
            }

            @Override
            public void reset() {
                
            }
        };

        Action fallingRightAction = new Action() {
            @Override
            public boolean run(GameObject owner) {
                GameObject.remove(leftSpawner);
                rightSpawner = new Spawner(new Vector2D(300,-20));
                GameObject.add(rightSpawner);

                return true;
            }

            @Override
            public void reset() {

            }
        };

        Action fallingBothAction = new Action() {
            @Override
            public boolean run(GameObject owner) {
                GameObject.remove(rightSpawner);
                leftSpawner = new Spawner(new Vector2D(105,-20));
                rightSpawner = new Spawner(new Vector2D(300,-20));
                GameObject.add(leftSpawner);
                GameObject.add(rightSpawner);
                return true;
            }

            @Override
            public void reset() {

            }
        };

        Action trapAction = new Action() {
            @Override
            public boolean run(GameObject owner) {
                GameObject.add(new TrapSpawner());
                return true;
            }

            @Override
            public void reset() {

            }
        };


        Action actionSequence = new ActionSequence(fallingLeftAction, waitAction,fallingRightAction,waitAction2,fallingBothAction, waitAction3, trapAction);
        this.addAction(actionSequence);

    }
}
