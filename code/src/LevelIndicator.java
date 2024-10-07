//reut lev ID:207385741
import java.awt.Color;
import biuoop.DrawSurface;

/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-09
*/

public class LevelIndicator implements Sprite {
    /**
     * this class create Level Indicator in the game.
     */
    private LevelInformation levelInformation;
    private Rectangle rectangle;
    private Color color;

     /**
     * constructor create a level indicator by rectangle,color and levelInformation.
     * @param rectangle the rectangle (the size and place)
     * @param color the color
     * @param levelInformation the level information
     */
    public LevelIndicator(Rectangle rectangle, Color color, LevelInformation levelInformation) {
        this.levelInformation = levelInformation;
        this.rectangle = rectangle;
        this.color = color;
    }

     /**
     * this method draw the block on the given DrawSurface.
     * @param d - DrawSurface.
     */
    public void drawOn(DrawSurface d) {
        int width = (int) this.rectangle.getWidth();
        int height = (int) this.rectangle.getHeight();
        int xPoint = (int) this.rectangle.getUpperLeft().getX();
        int yPoint = (int) this.rectangle.getUpperLeft().getY();
        d.setColor(this.color);
        d.fillRectangle(xPoint, yPoint, width, height);
        String text = "Level Name: " + this.levelInformation.levelName();
        d.setColor(Color.BLACK);
        d.drawText(xPoint + (width / 2) - text.length() * 2, yPoint + (height - 3), text, 15);
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