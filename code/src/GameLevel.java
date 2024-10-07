//reut lev ID:207385741
import biuoop.GUI;
import biuoop.DrawSurface;
import java.awt.Color;
import biuoop.Sleeper;
import biuoop.KeyboardSensor;
import java.util.List;

/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-04-21
*/

public class GameLevel implements Animation {
    /**
    * This class represents a game.
    */
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private static int screenWidth = 800;
    private static int screenHeight = 600;

    private Counter blockCount;
    private Counter ballCount;
    private  Counter score;

    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;

    private  LevelInformation levelInformation;


    /**
     * constructor create a new game.
     */
    public GameLevel() {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.runner = new AnimationRunner(new GUI("Game" , screenWidth , screenHeight), new Sleeper());
        this.score = new Counter(0);
    }

     /**
     *  constructor create a new game..
     * @param  levelInformation the level information.
     */
     public GameLevel(LevelInformation levelInformation) {
        this.levelInformation = levelInformation;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.runner = new AnimationRunner(new GUI("Game" , screenWidth , screenHeight), new Sleeper());
        this.score = new Counter(0);
    }

      /**
     * constructor create a new game.
     * @param  levelInformation the level information.
     * @param  animationRunner animatiom runner.
     * @param  keyboardSensor to create a  keyboard sensor.
     * @param  score to create a  score counter.
     */
      public GameLevel(LevelInformation levelInformation, AnimationRunner animationRunner,
                        KeyboardSensor keyboardSensor, Counter score) {
        this.levelInformation = levelInformation;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.score = score;
        this.runner = animationRunner;
        this.keyboard = keyboardSensor;
    }

     /**
     * This method return the numbers of balls.
     * @return a ball counter.
     */
    public Counter getNumbersOfBall() {
        return this.ballCount;
    }
     /**
     * This method return the numbers of blocks.
     * @return a block counter.
     */
    public Counter getNumbersOfBlock() {
        return this.blockCount;
    }
     /**
     * This method return the score umber.
     * @return a score.
     */
    public Counter getScore() {
        return this.score;
    }
    /**
     * This method add a collidable to the game.
     * @param c a collidable.
     */
   public void addCollidable(Collidable c) {
       this.environment.addCollidable(c);
   }
     /**
     * This method add a sprites to the game.
     * @param s a sprite.
     */
   public void addSprite(Sprite s) {
       this.sprites.addSprite(s);
   }
    /**
     * initialize counters.
     * block counter , ball counter , score counter.
     */
    public void createCounter() {
        this.blockCount = new Counter(0);
        this.ballCount = new Counter(0);
    }
    /**
     * Create score indicator.
     */
    public void createScoreIndicator() {
        ScoreIndicator scoreIndicator = new ScoreIndicator(
                this.score,
                new Rectangle(new Point(0 , 0), this.screenWidth , 20) , Color.LIGHT_GRAY);
        scoreIndicator.addToGame(this);
    }
     /**
     * Create level indicator.
     */
    public void createLevelIndicator() {
        LevelIndicator levelIndicator = new LevelIndicator(
                new Rectangle(new Point(((2 * this.screenWidth) / 3) - 1, 0), (this.screenWidth / 3) + 1, 20),
                Color.LIGHT_GRAY, this.levelInformation);
        levelIndicator.addToGame(this);
    }

    /**
     * Add background to the game.
     */
    public void addBackground() {
        sprites.addSprite(this.levelInformation.getBackground());
    }

    /**
     * Create blocks.
     */
    public void createBlocks() {
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        this.blockCount = new Counter(this.levelInformation.numberOfBlocksToRemove());
         BlockRemover blockRemover = new BlockRemover(this, this.blockCount);
        List<Block> levelBlocks = this.levelInformation.blocks();
        for (Block block : levelBlocks) {
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
            block.addToGame(this);
        }
    }

    /**
     * Create limits.
     */
    public void createLimits() {
        BallRemover ballRemover = new BallRemover(this, this.ballCount); // create listener
        Block [] boundArray = new Block[4];
        Color colorBoundBlocks = new Color(10 , 50 , 100);
        boundArray[0] = new Block(0 , 20 , 20 , screenHeight , colorBoundBlocks); //leftBound
        boundArray[1] = new Block(screenWidth - 20 , 20 , 20 , screenHeight , colorBoundBlocks); //rightBound
        boundArray[2] = new Block(0 , 20 , screenWidth , 20 , colorBoundBlocks); //topBound
        boundArray[3] = new Block(0, screenHeight - 20, screenWidth , 20 , colorBoundBlocks); //bottomBound

        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                boundArray[i].addHitListener(ballRemover);
            }
            boundArray[i].addToGame(this);
        }
    }
   /**
     * Create balls.
     */
    public void createBalls() {
        List<Velocity> ballsVelocity = this.levelInformation.initialBallVelocities();
        int radius = 5;
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball((this.screenWidth / 2) - 5, this.screenHeight - 20 - (2 * radius) ,
                                radius, Color.BLACK , this.environment);
            ball.setVelocity(ballsVelocity.get(i));
            ball.addToGame(this);
        }
        this.ballCount.increase(this.levelInformation.numberOfBalls());
    }
    /**
     * Create paddle.
     */
    public void createPaddle() {
       Paddle paddle = new Paddle(levelInformation.paddleWidth() , levelInformation.paddleSpeed(),
                                screenWidth , screenHeight , this.runner.getGui());
        paddle.addToGame(this);
        //try to init the key board in more a logical place
        this.keyboard = paddle.getKeyBoard();
    }
    /**
     * Create balls on top of paddle.
     */
     public void createBallsOnTopOfPaddle() {
         /* creates the paddle */
        createPaddle();
         /* creates the balls */
        createBalls();
    }
    /**
     * This method initialize a new game: create the Blocks,Ball and Paddle and add them to the game.
     */
       public void initialize() {
           /* add game background */
           addBackground();

           /* creates counter */
           createCounter();

           /* creates  indicators */
           createScoreIndicator();
           createLevelIndicator();

           /* creates the bounding blocks */
          createLimits();

          /*create blocks*/
          createBlocks();

          /*create paddle and balls*/
          createBallsOnTopOfPaddle();
       }

   /**
     * Remove Collidable.
     * @param c the collidable
     */
   public void removeCollidable(Collidable c) {
       this.environment.getCollidable().remove(c);
   }

     /**
     * Remove sprite.
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSprites().remove(s);
    }

    /**
     * This method retuen if the game need to stop.
     * @return true if need to stop.
     */
   public boolean shouldStop() {
       return !this.running;
       }

     /**
     * this method create one frame of the game.
     * @param d a draw surface.
     */
   public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
       if (this.blockCount.getValue() == 0 || this.ballCount.getValue() == 0) {
           this.running = false;
       }
       if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
   }
     /**
     * This method run the game.
     */
   public void run() {
      this.runner.run(new CountdownAnimation(1, 3, this.sprites));
      this.running = true;

      this.runner.run(this);
   }
}
