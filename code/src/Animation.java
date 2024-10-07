//reut lev ID:207385741
import biuoop.DrawSurface;

/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-08
*/

public interface Animation {
    /**
    * This interface represents animation.
    */

    /**
     * this method create one frame of the game.
     * @param d a draw surface.
     */
       void doOneFrame(DrawSurface d);
     /**
     * This method retuen if the game need to stop.
     * @return true if need to stop.
     */
       boolean shouldStop();
}