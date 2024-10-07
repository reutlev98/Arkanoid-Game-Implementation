//reut lev ID:207385741
import biuoop.DrawSurface;
import java.awt.Color;

/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-12
*/
public class Green3Background implements Sprite {
   /**
     * this class create background for Green3 level.
     */
    private Point point;

     /**
     * constructor of Green3Background from point.
     * @param  point the point we will use.
     */
    public Green3Background(Point point) {
        this.point = point;
    }

     /**
     * this method draw the object to the screen.
     * @param d - draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(80, 200, 120));
        d.fillRectangle(0, 0, 800, 600);

        int xPoint = (int) this.point.getX();
        int yPoint = (int) this.point.getY();
        int size = 100;
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(xPoint, yPoint, size, size * 4);

        d.setColor(new Color(100, 100, 100));
        d.fillRectangle(xPoint + (xPoint / 3), yPoint - size, size / 3, size);

        d.setColor(new Color(150, 150, 150));
        d.fillRectangle(xPoint + (xPoint / 2), yPoint - (size * 2), size / 20, size);

        // circles
        d.setColor(new Color(255, 201, 201));
        d.fillCircle(xPoint + (xPoint / 2), yPoint - (size * 2), size / 10);
        d.setColor(Color.RED);
        d.fillCircle(xPoint + (xPoint / 2), yPoint - (size * 2), size / 13);
        d.setColor(Color.WHITE);
        d.fillCircle(xPoint + (xPoint / 2), yPoint - (size * 2), size / 30);

        d.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(xPoint + 5 + (j * 20), yPoint + 5 + (i * 20), size / 10, size / 10);
            }
        }
    }

     /**
     * this method notify the sprite that time has passed.
     */
    public void timePassed() {
    }
}