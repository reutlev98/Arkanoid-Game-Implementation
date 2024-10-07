//reut lev ID:207385741
import java.util.List;
import java.util.ArrayList;
/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-04-21
*/
public class Rectangle {
    /**
    * This class represents a rectangle.
    *
    */
      private Point upperLeft;
      private double width;
      private double height;
      private Line left;
      private Line right;
      private Line top;
      private Line bottom;

      /**
     * constructor create a new rectangle with location and width/height.
     * @param upperLeft is the location of the rectangle's upper-left point.
     * @param width the rectangle's width.
     * @param height the rectangle's height.
     */
   public Rectangle(Point upperLeft, double width, double height) {
        this.left = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX(), upperLeft.getY() + height);
        this.right = new Line(upperLeft.getX() + width, upperLeft.getY(),
                              upperLeft.getX() + width, upperLeft.getY() + height);
        this.bottom = new Line(upperLeft.getX(), upperLeft.getY() + height,
                               upperLeft.getX() + width, upperLeft.getY() + height);
        this.top = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX() + width, upperLeft.getY());
   }
    /**
     * constructor create a new rectangle from two coordinates and width/height.
     * @param x is the x coordinate of the location of the rectangle's upper-left point.
     * @param y is the y coordinate of location of the rectangle's upper-left point.
     * @param width the rectangle's width.
     * @param height the rectangle's height.
     */
    public Rectangle(double x, double y, double width, double height) {
        this.left = new Line(x , y , x , y + height);
        this.right = new Line(x + width, y, x + width, y + height);
        this.bottom = new Line(x, y + height, x + width, y + height);
        this.top = new Line(x, y, x + width, y);
    }
    /**
     * This method return a (possibly empty) List of intersection points.
     * @param line specified line.
     * @return a (possibly empty) List of intersection points.
     */
   public java.util.List<Point> intersectionPoints(Line line) {
       List<Point> listIntersectionPoints = new ArrayList<Point>();
         if (line.isIntersecting(this.left)) {
            listIntersectionPoints.add(line.intersectionWith(this.left));
         }
          if (line.isIntersecting(this.right)) {
             listIntersectionPoints.add(line.intersectionWith(this.right));
         }
          if (line.isIntersecting(this.bottom)) {
             listIntersectionPoints.add(line.intersectionWith(this.bottom));
         }
          if (line.isIntersecting(this.top)) {
             listIntersectionPoints.add(line.intersectionWith(this.top));
         }
        return listIntersectionPoints;
   }
    /**
     * this method returns the width of this rectangle.
     * @return the width value of this rectangle.
     */
   public double getWidth() {
       return this.bottom.length();
   }
   /**
     * this method returns the height of this rectangle.
     * @return the height value of this rectangle.
     */
   public double getHeight() {
       return this.left.length();
   }
    /**
     * this method returns the upper-left point of the rectangle.
     * @return the upper-left point of the rectangle.
     */
   public Point getUpperLeft() {
       return this.getTop().intersectionWith(this.getLeft());
   }
    /**
     * this method returns the left side of the rectangle.
     * @return the the left side of the rectangle.
     */
     public Line getLeft() {
       return this.left;
   }
    /**
     * this method returns the right side of the rectangle.
     * @return the the right side of the rectangle.
     */
   public Line getRigtht() {
       return this.right;
   }
    /**
     * this method returns the bottom side of the rectangle.
     * @return the the bottom side of the rectangle.
     */
   public Line getBottom() {
       return this.left;
   }
    /**
     * this method returns the top side of the rectangle.
     * @return the the top side of the rectangle.
     */
   public Line getTop() {
       return this.top;
   }
}