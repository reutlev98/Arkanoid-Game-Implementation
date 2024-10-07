
/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-05-04
*/

public class ScoreTrackingListener implements HitListener {
    /**
    * this class represente a Score Tracking Listener.
    */
   private Counter currentScore;

    /**
     * construct a Score Tracking Listener remover from a counter.
     * @param scoreCounter a counter of the score.
     */
   public ScoreTrackingListener(Counter scoreCounter) {
      this.currentScore = scoreCounter;
   }

   /**
     * get current score.
     * @return the current score.
     */
   public Counter getCurrentScore() {
      return this.currentScore;
   }

    /**
     * this method increase the counter by 5 (hitting a block is worth 5 points).
     * @param beingHit the block that are hit .
     * @param hitter a ball.
     */
   public void hitEvent(Block beingHit, Ball hitter) {
       this.currentScore.increase(5);
   }

   /**
     * this method increase the counter by 100.
     * Clearning an entire level (destroying all blocks) is worth.
     */
    public void completLevel() {
        this.currentScore.increase(100);
    }

}