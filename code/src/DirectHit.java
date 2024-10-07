//reut lev ID:207385741
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-10
*/

public class DirectHit implements LevelInformation {
     /**
     * this class create a Direct hit level.
     */
    private  int numberOfBalls;
    private  List<Velocity> ballVelocities;
    private  int paddleSpeed;
    private  int paddleWidth;
    private  String levelName;
    private  Sprite background;
    private  List<Block> blocks;
    private  int numberOfBlocksToRemove;

    /**
     * constructor of WideEasy - initial the level.
     */
    public DirectHit() {
        //name
        this.levelName = "Direct Hit";
        //balls
        this.numberOfBalls = 1;
        this.ballVelocities = new ArrayList<>();
        this.ballVelocities.add(Velocity.fromAngleAndSpeed(0, 4));
        //paddle
        this.paddleWidth = 50;
        this.paddleSpeed = 5;
        //block
        this.numberOfBlocksToRemove = 1;
        this.blocks = new ArrayList<>();
        int blockSize = 30;
        int radius = 100;
        Point point = new Point(400, radius + 40);
        Point rectanglePoint = new Point(point.getX() - blockSize / 2, point.getY() - blockSize / 2);
        Rectangle rectangle = new Rectangle(rectanglePoint, blockSize, blockSize);
        Block block = new Block(rectangle, Color.RED);
        this.blocks.add(block);
        //background
        this.background = new DirectHitBackground(radius, point);
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
           return this.ballVelocities;
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