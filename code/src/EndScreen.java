//reut lev ID:207385741
import biuoop.DrawSurface;
import java.awt.Color;
/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-11
*/

public class EndScreen implements Animation {
     /**
     * this class create an end screen.
     */
    private  boolean isWon;
    private  boolean stop;
    private  int score;

    /**
     * constructor create an EndScreen by bool and score.
     * @param isWon if the player won the game.
     * @param score the score in the game.
     */
    public EndScreen(boolean isWon , int score) {
      this.stop = false;
      this.isWon = isWon;
      this.score = score;
   }
    /**
     * this method create one frame of the game.
     * @param d a draw surface.
     */
   public void doOneFrame(DrawSurface d) {
        String massage = "";
        d.setColor(Color.BLACK);
       if (isWon) {
            massage = "You Win! Your score is " + this.score;
        } else {
            massage = "Game Over. Your score is " + this.score;
        }
        d.drawText(10, d.getHeight() / 2, massage, 32);
   }
    /**
     * This method retuen if the game need to stop.
     * @return true if need to stop.
     */
   public boolean shouldStop() {
        return this.stop;
   }
}
