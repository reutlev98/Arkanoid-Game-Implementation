//reut lev ID:207385741
import biuoop.DrawSurface;
import java.awt.Color;


/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-12
*/
public class FinalFourBackground implements Sprite {
     /**
     * this class create background for Final Four level.
     */
    private Point point;

     /**
     * constructor of FinalFourBackground from point.
     * @param  point the point we will use.
     */
    public FinalFourBackground(Point point) {
        this.point = point;
    }

   /**
     * this method draw the object to the screen.
     * @param d - draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(196, 235, 235));
        d.fillRectangle(0, 0, 800, 600);
        int xPoint = (int) this.point.getX();
        int yPoint = (int) this.point.getY();
        createCloud(d, xPoint, yPoint);
        for (int i = 0; i < 5; i += 2) {
            createflowers(d, xPoint - i * 40, yPoint + 100, new Color(102, 0 + i * 40, 100 + i * 20));
        }
        xPoint = xPoint * 3 + 100;
        createCloud(d, xPoint, yPoint);
        for (int i = 0; i < 5; i += 2) {
            createflowers(d, xPoint - i * 40, yPoint + 100, new Color(255, 0 + i * 40, 0 + i * 40));
        }
    }

    /**
     * this method draw the clouds on the screen.
     * @param d - draw surface.
     * @param xPoint - the x coordinate.
     * @param yPoint - the y coordinate.
     */
    public void createCloud(DrawSurface d , int xPoint , int yPoint) {
        int size = 40;
        d.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 10; i++) {
        d.drawLine(xPoint - 10 * i, yPoint + 10, xPoint - 20 * i, 600);
        }
        d.fillCircle(xPoint - 100 , yPoint + 10, size - 10);
        d.fillCircle(xPoint - 80 , yPoint + 30, size);

        d.setColor(new Color(170, 170, 170));
        d.fillCircle(xPoint - 50 , yPoint, size);

        d.setColor(new Color(160, 160, 160));
        d.fillCircle(xPoint - 20 , yPoint + 20, size);
        d.fillCircle(xPoint - 40, yPoint + 40, size - 10);
    }
    /**
     * this method draw the clouds on the screen.
     * @param d - draw surface.
     * @param xPoint - the x coordinate.
     * @param yPoint - the y coordinate.
     * @param color - the color of the flower.
     */
    public void createflowers(DrawSurface d , int xPoint , int yPoint , java.awt.Color color) {
        int size = 10;
        d.setColor(Color.GREEN);
        d.fillRectangle(xPoint , yPoint, size / 5, size * 10);
        d.setColor(color);
        d.fillCircle(xPoint, yPoint + 5, size);
        d.fillCircle(xPoint - 5 , yPoint + 10, size);
        d.fillCircle(xPoint - 5 , yPoint + 20, size);
        d.fillCircle(xPoint + 5 , yPoint + 10, size);
        d.fillCircle(xPoint + 5 , yPoint + 20, size);
    }
     /**
     * this method notify the sprite that time has passed.
     */
    public void timePassed() {
    }
}