//reut lev ID:207385741
import biuoop.DrawSurface;
import java.awt.Color;

/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-12
*/

public class CountdownAnimation implements Animation {
    /**
    * this class create a count down animation.
    */
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stillRun;
    private long numOfMillisecond;
    private int startNumber;
    private long startTime;

    /**
     * constructor create an CountdownAnimation by numOfSeconds , countFrom and gameScreen.
     * @param numOfSeconds the num of seconds the animation will appear.
     * @param countFrom the number we count from.
     * @param gameScreen the game screen.
     */
   public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.stillRun = true;
        this.countFrom = countFrom;
        this.startNumber = countFrom;
        this.gameScreen = gameScreen;
        this.numOfMillisecond = (long) (numOfSeconds * 1000);
        this.startTime = System.currentTimeMillis();
   }
    /**
     * this method create one frame of the game.
     * @param d a draw surface.
     */
   public void doOneFrame(DrawSurface d) {
            this.gameScreen.drawAllOn(d);
            d.setColor(Color.BLACK);
            d.drawText(380, 500, Integer.toString(this.countFrom), 100);
            if ((this.numOfMillisecond / this.startNumber)
                < (System.currentTimeMillis() - this.startTime)) {
                this.countFrom--;
                this.startTime = System.currentTimeMillis();
            }
            if (this.countFrom == 0) {
                this.stillRun = false;
            }
        }
    /**
     * This method retuen if the game need to stop.
     * @return true if need to stop.
     */
   public boolean shouldStop() {
         return !this.stillRun;
   }
}