
/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-05-04
*/

public class BlockRemover implements HitListener {
    /**
    * this class represente a block remover.
    * removing blocks from the game, and keeping count of the number of blocks that remain.
    */
   private GameLevel game;
   private Counter remainingBlocks;

     /**
     * constructor BlockRemover from game, and removedBlocks.
     * @param game a game.
     * @param removedBlocks a counter.
     */
       public BlockRemover(GameLevel game, Counter removedBlocks) {
       this.game = game;
       this.remainingBlocks = removedBlocks;
       }

    /**
     * this method remove blocks that was hit.
     * @param beingHit the block that are hit .
     * @param hitter a ball.
     */
       public void hitEvent(Block beingHit, Ball hitter) {
            beingHit.removeFromGame(this.game);
            beingHit.removeHitListener(this);
            this.remainingBlocks.decrease(1);
       }
}