//reut lev ID:207385741
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-10
*/

public class Green3  implements LevelInformation {
    /**
     * this class create a Green3 level.
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
    public Green3() {
        this.levelName = "Green 3";
        this.paddleWidth = 100;
        this.paddleSpeed = 5;
        this.background = new Green3Background(new Point(100, 380));
        this.numberOfBalls = 2;
        this.ballsVelocities = new ArrayList<>();
        ballsVelocities.add(Velocity.fromAngleAndSpeed(30, 4));
        ballsVelocities.add(Velocity.fromAngleAndSpeed(30 * 7, 4));
        this.numberOfBlocksToRemove = 40;
         this.blocks = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 10 - i; j++) {
                int blockHight = 20;
                int blockWidth = blockHight * 2;
                int xPoint = (800 - 20) - (blockWidth * j);
                int yPoint = (blockHight * i) + 100;
                Color colorBlocks;
                switch (i) {
                    case (1):
                        colorBlocks = Color.GRAY;
                        break;
                    case (2):
                        colorBlocks = Color.RED;
                        break;
                    case (3):
                        colorBlocks = Color.YELLOW;
                        break;
                    case (4):
                        colorBlocks = Color.BLUE;
                        break;
                    case (5):
                        colorBlocks = Color.WHITE;
                        break;
                    default:
                        colorBlocks = Color.PINK;
                        break;
                }
                blocks.add(new Block(xPoint , yPoint , blockWidth , blockHight , colorBlocks));
            }
        }
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