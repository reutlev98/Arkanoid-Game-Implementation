//reut lev ID:207385741
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-10
*/

public class WideEasy implements LevelInformation {
    /**
     * this class create a wide easy level.
     */
    private  int numberOfBalls;
    private  List<Velocity> ballsVelocities;
    private  int paddleSpeed;
    private  int paddleWidth;
    private  String levelName;
    private  Sprite background;
    private  List<Block> blocks;
    private  int numberOfBlocksToRemove;

     /**
     * constructor of WideEasy - initial the level.
     */
        public WideEasy() {
            this.levelName = "Wide Easy";
            this.numberOfBalls = 10;
             this.ballsVelocities = new ArrayList<>();
               for (int i = 0; i < this.numberOfBalls; i++) {
                this.ballsVelocities.add(Velocity.fromAngleAndSpeed(250 + (this.numberOfBalls * 3)
                                    + (i * ((this.numberOfBalls * 2) - 2)) , 4));
            }
            this.paddleWidth = 500;
            this.paddleSpeed = 5;
            this.numberOfBlocksToRemove = 10;
            this.blocks = new ArrayList<>();
            int blockWidth = (800 - (2 * 20)) / this.numberOfBlocksToRemove;
            int blockHeight = 20;
            for (int i = 0; i < this.numberOfBlocksToRemove; i++) {
                Color color = Color.RED;
                if (i > 7) {
                    color = Color.BLUE;
                } else {
                    if (i > 5) {
                        color = Color.GREEN;
                    } else {
                        if (i > 3) {
                            color = Color.YELLOW;
                        } else {
                            if (i > 1) {
                                color = Color.ORANGE;
                            }
                        }
                    }
                }
                Rectangle rectangle = new Rectangle(
                        new Point(20 + (i * (blockWidth)), 200) , blockWidth , blockHeight);
                this.blocks.add(new Block(rectangle , color));
            }
            this.background = new WideEasyBackground(new Point(100 , 100));
        }
    /**
     * this method Return the number of balls in this level.
     * @return the number of balls.
     */
       public int numberOfBalls() {
            return this.numberOfBalls;
       }
   /**
     * this method Return velocities of the balls in the game.
     * @return list of velocities.
     */
       public List<Velocity> initialBallVelocities() {
               return this.ballsVelocities;
       }
   /**
     * this method Return the paddle Speed.
     * @return the paddle Speed.
     */
       public int paddleSpeed() {
           return this.paddleSpeed;
       }
    /**
     * this method Return the paddle width.
     * @return the paddle width.
     */
      public int paddleWidth() {
           return this.paddleWidth;
       }
     /**
     * this method Return the level name.
     * @return the level name.
     */
       public String levelName() {
           return this.levelName;
       }
    /**
     * this method Return a sprite with the background of the level.
     * @return a sprite with the background of the level.
     */
       public Sprite getBackground() {
           return this.background;
       }
   /**
     * this method Return a list of The Blocks that make up this level.
     * @return a list of blocks.
     */
      public List<Block> blocks() {
            return this.blocks;
      }
     /**
     * this method Return number of blocks that should be removed.
     * @return number of blocks that should be removed.
     */
       public int numberOfBlocksToRemove() {
           return this.numberOfBlocksToRemove;
       }
}