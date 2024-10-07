//reut lev ID:207385741
import java.util.List;
import java.util.ArrayList;
/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-04-23
*/
public class GameEnvironment {
    /**
    * This class represents a GameEnvironment.
    */
    private List<Collidable> collidableList;

    /**
     * constructor create a game environment.
     */
    public GameEnvironment() {
        this.collidableList = new ArrayList<Collidable>();
    }
     /**
     * constructor create a game environment.
     * @param collidableList a list of collidable object.
     */
    public GameEnvironment(List<Collidable> collidableList) {
        this.collidableList = new ArrayList<Collidable>();
    }

     /**
     * This method add the given collidable to the environment.
     * @param c a collidable.
     */
   public void addCollidable(Collidable c) {
       this.collidableList.add(c);
   }
    /**
     * This method return information about the closest collision that is going to occur,
     * between a line and any of the collidables in this collection.
     * @param trajectory a line.
     * @return information about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {

        for (int i = 0; i < collidableList.size(); i++) {

            Point collectionPoint = trajectory.closestIntersectionToStartOfLine(
            collidableList.get(i).getCollisionRectangle());
            if (collectionPoint != null) {
                return new CollisionInfo(collectionPoint , collidableList.get(i));
            }
        }
        return null;
    }

     /**
     * get collidable.
     * @return list of collidable.
     */
     public List<Collidable> getCollidable() {
        return this.collidableList;
    }
}