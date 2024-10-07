/**
* @author reut lev ID:207385741
* @version 1.0
* @since 2021-04-24
*/
public interface Collidable {
    /**
    * this interface represents a colliadable object.
    */

    /**
     * this method Return the "collision shape" of the object.
     * @return a rectangle.
     */
   Rectangle getCollisionRectangle();

     /**
     * This notify the object that we collided with it at collision point.
     * @param hitter ball hit.
     * @param collisionPoint a collition point with an object.
     * @param currentVelocity the current velocity.
     * @return the new velocity expected after the hit.
     */
   Velocity hit(Ball hitter , Point collisionPoint, Velocity currentVelocity);
}