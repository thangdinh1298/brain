package brain.traps;

import bases.FrameCounter;
import bases.GameObject;

public class TrapSpawner extends GameObject {
    FrameCounter frameCounter = new FrameCounter(200);
//to do: change spawning algorithm
    @Override
    public void run() {
        if(frameCounter.run()){
            GameObject.add(new ShapeShifting());
            frameCounter.reset();
        }
    }
}
