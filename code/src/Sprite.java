//reut lev ID:207385741
import biuoop.DrawSurface;
/**
* @author reut lev ID:207385741
* @version 1.0
* @since 2021-04-24
*/
public interface Sprite {
    /**
    * this interface represents objects that can be drawn.
    */

   /**
     * this method draw the object to the screen.
     * @param d - draw surface.
     */
   void drawOn(DrawSurface d);
    /**
     * this method notify the sprite that time has passed.
     */
   void timePassed();
}