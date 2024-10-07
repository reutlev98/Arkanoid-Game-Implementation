
/**
* @author reut lev ID:207385741
* @version 1.0
* @since 2021-05-02
*/

public interface HitListener {
     /**
    * this interface create a hit listener.
    */

    /**
     * This method is called whenever the beingHit object is hit.
     * @param beingHit a block that was hit.
     * @param hitter a ball that's doing the hitting.
     */
   void hitEvent(Block beingHit, Ball hitter);
}