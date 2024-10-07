/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-04-05
*/
public class Point  {
    /**
    * This class represents a point.
    *
    */
        private double x;
        private double y;
     /**
     * constructor from two double.
     * @param  x that show the x coordinate of the point.
     * @param  y that show the x coordinate of the point.
     */
       public Point(double x, double y) {
         this.x = x;
         this.y = y;
         }
    /**
     * this method calculates the distance from this point to another point.
     * @param other another point.
     * @return the distance of this point from the other point.
     */
       public double distance(Point other) {
       double dist;
       dist = ((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y));
       dist = Math.sqrt(dist);
       return dist;
       }
     /**
     * this method checks if two points are the same.
     * @param other another point.
     * @return true if the points are equal, false otherwise.
     */
       public boolean equals(Point other) {
        return (this.x == other.x && this.y == other.y);
       }
     /**
     * this method returns the x value of this point.
     * @return the x value of this point.
     */
       public double getX() {
        return this.x;
        }
    /**
     * this method returns the y value of this point.
     * @return the y value of this point.
     */
       public double getY() {
        return this.y;
       }
}