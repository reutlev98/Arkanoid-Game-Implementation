//reut lev ID:207385741

import java.util.List;
/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-08
*/

public interface LevelInformation {
    /**
     * this interface represent a level information.
     */

    /**
     * this method Return the number of balls in this level.
     * @return the number of balls.
     */
   int numberOfBalls();
   /**
     * this method Return velocities of the balls in the game.
     * @return list of velocities.
     */
   List<Velocity> initialBallVelocities();
   /**
     * this method Return the paddle Speed.
     * @return the paddle Speed.
     */
   int paddleSpeed();
     /**
     * this method Return the paddle width.
     * @return the paddle width.
     */
   int paddleWidth();
   /**
     * this method Return the level name.
     * @return the level name.
     */
   String levelName();
   /**
     * this method Return a sprite with the background of the level.
     * @return a sprite with the background of the level.
     */
   Sprite getBackground();
   /**
     * this method Return a list of The Blocks that make up this level.
     * @return a list of blocks.
     */
   List<Block> blocks();
   /**
     * this method Return number of blocks that should be removed.
     * @return number of blocks that should be removed.
     */
   int numberOfBlocksToRemove();
}