//reut lev ID:207385741
import biuoop.DrawSurface;

/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-09
*/

public class PauseScreen implements Animation {
    /**
     * this class create a pause screen.
     */
   private boolean stop;

    /**
     * constructor create a PauseScreen.
     */
   public PauseScreen() {
      this.stop = false;
   }
    /**
     * this method create one frame of the game.
     * @param d a draw surface.
     */
   public void doOneFrame(DrawSurface d) {
      d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
   }
   /**
     * This method retuen if the game need to stop.
     * @return true if need to stop.
     */
   public boolean shouldStop() {
        return this.stop;
   }
}