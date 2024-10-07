//reut lev ID:207385741
import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;
/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-08
*/
public class AnimationRunner {
    /**
    * This class represents an animation runner.
    */
   private GUI gui;
   private Sleeper sleeper;


       /**
     * constructor create a new animation runner.
     * @param  gui to create a gui.
     * @param  sleeper to create a  sleeper.
     */
     public AnimationRunner(GUI gui, Sleeper sleeper) {
       this.gui = gui;
        this.sleeper = sleeper;
    }

   /**
     * This method run the game.
     * @param  animation in order to run the game animation.
     */
   public void run(Animation animation) {
      int millisecondsPerFrame = 1000 / 60;
      while (!animation.shouldStop()) {
         long startTime = System.currentTimeMillis(); // timing
         DrawSurface d = gui.getDrawSurface();
         animation.doOneFrame(d);
         gui.show(d);
         long usedTime = System.currentTimeMillis() - startTime;
         long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
         if (milliSecondLeftToSleep > 0) {
             this.sleeper.sleepFor(milliSecondLeftToSleep);
         }
      }
   }
    /**
     * this method returns the gui.
     * @return  a gui.
     */
    public GUI getGui() {
        return this.gui;
    }

    /**
     * this method close gui.
     */
    public void closeGui() {
        this.gui.close();
    }
}