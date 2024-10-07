//reut lev ID:207385741
import biuoop.DrawSurface;
import java.awt.Color;
/**
* @author reut lev ID:207385741
* @version 1.5
* @since 2021-06-12
*/
public class DirectHitBackground implements Sprite {
    /**
     * this class create background for direct hit level.
     */
    private int radius;
    private Point point;

     /**
     * constructor of DirectHitBackground from radius and point.
     * @param  radius the radius.
     * @param  point the point point.
     */
    public DirectHitBackground(int radius, Point point) {
        this.radius = radius;
        this.point = point;
    }

    /**
     * this method draw the object to the screen.
     * @param d - draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle(0, 0, 800, 600);
        int distance = 20;
        int xPoint = (int) this.point.getX();
        int yPoint = (int) this.point.getY();
        d.setColor(Color.BLUE);
        d.drawCircle(xPoint, yPoint, this.radius);
        d.drawCircle(xPoint, yPoint, (this.radius + this.radius) / 3);
        d.drawCircle(xPoint, yPoint, this.radius / 3);
        d.drawLine(xPoint, yPoint - (this.radius + distance), xPoint, yPoint + (this.radius + distance));
        d.drawLine(xPoint - (this.radius + distance), yPoint, xPoint + (this.radius + distance), yPoint);
    }
    /**
     * this method notify the sprite that time has passed.
     */
    public void timePassed() {
    }
}