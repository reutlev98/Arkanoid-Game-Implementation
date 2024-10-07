//reut lev ID:207385741
import java.util.List;
import biuoop.KeyboardSensor;

/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-09
*/

public class GameFlow {
    /**
    * This class represents a game flow.
    */
    private KeyboardSensor keyBoardSensor;
    private AnimationRunner animationRunner;
    private Counter score;
    private boolean isWon;

   /**
     * constructor create a new game flow.
     * @param  ar to create animation Runner.
     * @param  ks to create a  keyboard sensor.
     */
   public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.keyBoardSensor = ks;
        this.animationRunner = ar;
        this.score = new Counter(0);
        this.isWon = true;
   }
    /**
     * this method runs the levels of the game.
     * @param  levels a list that contains the levels of the game .
     */
   public void runLevels(List<LevelInformation> levels) {
      for (LevelInformation levelInfo : levels) {
         GameLevel level = new GameLevel(levelInfo , this.animationRunner , this.keyBoardSensor , this.score);
         level.initialize();

        //level has more blocks and balls
         while (level.getNumbersOfBall().getValue() > 0 && level.getNumbersOfBlock().getValue() > 0) {
            level.run();
         }
        //no more balls
         if (level.getNumbersOfBall().getValue() == 0) {
             isWon = false;
            break;
         }
         this.score.increase(100);
      }
        //this.animationRunner.run(new EndScreen(this.keyBoardSensor ,isWon , score.getValue()));
        this.animationRunner.run(new KeyPressStoppableAnimation(
                                this.keyBoardSensor, KeyboardSensor.SPACE_KEY,
                                new EndScreen(isWon, score.getValue())));
       this.animationRunner.closeGui();
   }
}