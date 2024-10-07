//reut lev ID:207385741
import biuoop.DrawSurface;
import java.awt.Color;

/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-05-04
*/


public class ScoreIndicator implements Sprite {
    /**
     * this class represente a Score indicator.
     */
        private  Counter scoreCounter;
        private  Rectangle rectangle;
        private  java.awt.Color color;

    /**
     * constructor create a new score indicator from counter, rectangle and color.
     * @param scorecounter the score counter
     * @param rectangle the rectangle (the size and place)
     * @param color the color
     */
        public ScoreIndicator(Counter scorecounter, Rectangle rectangle, java.awt.Color color) {
            this.scoreCounter = scorecounter;
            this.rectangle = rectangle;
            this.color = color;
        }

     /**
     * constructor create a new score indicator from counter, rectangle , and color.
     *(create rectangle from location and width/height).
     * @param scorecounter the score counter
     * @param upperLeft is the location of the rectangle's upper-left point.
     * @param width the rectangle's width.
     * @param height the rectangle's height.
     * @param color rectangle's color.
     */
        public ScoreIndicator(Counter scorecounter , Point upperLeft, double width, double height
                                , java.awt.Color color) {
            this.rectangle = new Rectangle(upperLeft , width , height);
            this.color = color;
            this.scoreCounter = scorecounter;
        }
     /**
     * constructor create a new score indicator from counter, rectangle , and color.
     * (create rectangle from coordinate and width/height).
     * @param scorecounter the score counter
     * @param x is the x coordinate of the location of the rectangle's upper-left point.
     * @param y is the y coordinate of location of the rectangle's upper-left point.
     * @param width the rectangle's width.
     * @param height the rectangle's height.
     * @param color rectangle's color.
     */
        public ScoreIndicator(Counter scorecounter , double x , double y , double width , double height
                                , java.awt.Color color) {
            this.rectangle = new Rectangle(x , y , width , height);
            this.color = color;
            this.scoreCounter = scorecounter;
        }

     /**
     * this method draw the block on the given DrawSurface.
     * @param d - DrawSurface.
     */
        public void drawOn(DrawSurface d) {
            int x = (int) this.rectangle.getUpperLeft().getX();
            int y = (int) this.rectangle.getUpperLeft().getY();
            int width = (int) this.rectangle.getWidth();
            int height = (int) this.rectangle.getHeight();
            d.setColor(this.color);
            d.fillRectangle(x, y, width, height);
            String score = "Score: " + this.scoreCounter.getValue();
            d.setColor(Color.BLACK);
            d.drawText((width - (score.length() * 15)) / 2, y + (height - 3), score, 15);
        }

    /**
     * this method  notify the sprite that time has passed.
     */
        public void timePassed() {

        }

    /**
     * This method add this paddle to the game.
     * @param game a game object.
     */
        public void addToGame(GameLevel game) {
            game.addSprite(this);
        }

}