

/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-05-04
*/

public class BallRemover implements HitListener {
    /**
    * this class represente a ball remover.
    */
   private GameLevel game;
   private Counter remainingBalls;

    /**
     * construct a ball remover from a game and removedBalls.
     * @param game a game.
     * @param removedBalls a removed Balls.
     */
       public BallRemover(GameLevel game, Counter removedBalls) {
       this.game = game;
       this.remainingBalls = removedBalls;
       }

   /**
     * this method remove ball that was hit the bottom limit.
     * @param beingHit the block that are hit .
     * @param hitter a ball.
     */
   public void hitEvent(Block beingHit, Ball hitter) {
      hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
   }
}