/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-04-24
*/
public class CollisionInfo {
    /**
    * This class represents a collision information.
    *
    */
    private Point collisionPoint;
    private Collidable collisionObject;

     /**
     * constructor CollisionInfo from point and colli object.
     * @param collisionPoint is the collition point with the object.
     * @param collisionObject the object we collide with .
     */
    public CollisionInfo(Point collisionPoint , Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * this method returns the point at which the collision occurs.
     * @return the point at which the collision occurs.
     */
   public Point collisionPoint() {
       return this.collisionPoint;
   }

     /**
     * this method returns the collidable object involved in the collision.
     * @return the collidable object involved in the collision.
     */
   public Collidable collisionObject() {
       return this.collisionObject;
   }
}