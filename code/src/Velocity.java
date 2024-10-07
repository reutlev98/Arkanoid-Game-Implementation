/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-04-05
*/


public class Velocity {
    /**
    * this class represent velocity by specifies the change in position on the `x` and the `y` axes.
    *
    */
        private double dx;
        private double dy;
    /**
     * constructor from two double.
     * @param  dx that show the change in the position on the x axes.
     * @param  dy that show the change in the position on the y axes.
     */
   public Velocity(double dx, double dy) {
       this.dx = dx;
       this.dy = dy;
   }
    /**
     * this method is like a constructor - finds the change in position on the `x` and the `y` axes by angle and speed.
     * @param angle the angle of the vector,90 degrees direction assuming up is angle 0.
     * @param speed the length of the vector.
     * @return velocity object.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radianAngle = Math.toRadians(angle - 90.0);
        double dy = Math.sin(radianAngle) * speed;
        double dx = Math.cos(radianAngle) * speed;
        Velocity v1 = new Velocity(dx, dy);
        return v1;
   }
   /**
     * this method moves a point .
     * @param p a point with position (x,y).
     * @return a new point with position (x+dx, y+dy).
     */
   public Point applyToPoint(Point p) {
       Point newPoint = new Point(p.getX() + this.dx , p.getY() + this.dy);
       return newPoint;
   }
     /**
     * this method returns the dx value - velocitys change in position on the x axis.
     * @return the dx value -velocitys change in position on the x axis.
     */
   public double getDx() {
        return this.dx;
    }
     /**
     * this method returns the dy value - velocitys change in position on the y axis.
     * @return the dy value -velocitys change in position on the y axis.
     */
    public double getDy() {
    return this.dy;
    }
}