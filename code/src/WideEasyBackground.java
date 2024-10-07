//reut lev ID:207385741
import biuoop.DrawSurface;
import java.awt.Color;
/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-12
*/
public class WideEasyBackground implements Sprite {
    /**
     * this class create background for Wide Easy level.
     */

    private Point center;

     /**
     * constructor of WideEasyBackground from point.
     * @param  center the point center.
     */
    public WideEasyBackground(Point center) {
        this.center = center;
    }

     /**
     * this method draw the object to the screen.
     * @param d - draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 600);
        int distance = 20;
        int xCenter = (int) this.center.getX();
        int yCenter = (int) this.center.getY();
        int size = 50;
        d.setColor(new Color(255, 255, 204));
        d.drawCircle(xCenter, yCenter, size);
        d.fillCircle(xCenter, yCenter, size);
        d.setColor(new Color(255, 255, 153));
        d.drawCircle(xCenter, yCenter, (size * 2) / 3);
        d.fillCircle(xCenter, yCenter, (size * 2) / 3);
        d.setColor(Color.YELLOW);
        d.drawCircle(xCenter, yCenter, size / 3);
        d.fillCircle(xCenter, yCenter, size / 3);
        d.setColor(new Color(255, 255, 204));
        for (int i = 0; i < 800; i += 10) {
            d.drawLine(xCenter - (size * 2) / 3, yCenter + (size * 2) / 3,
                        i + distance - (i / 10), (int) this.center.getY() + 100);
        }
    }

    /**
     * this method notify the sprite that time has passed.
     */
    public void timePassed() {
    }
}