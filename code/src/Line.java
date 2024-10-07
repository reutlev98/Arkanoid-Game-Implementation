import java.util.List;
/**
* @author reut lev ID:207385741
* @version 1.5
* @since 2021-04-23
*/
public class Line  {
    /**
    * This class represents a line.
    *
    */
        private Point start;
        private Point end;
     /**
     * constructor from two points.
     * @param start the first point that defines the line.
     * @param end the second point that defines the line.
     */
        public Line(Point start, Point end) {
           this.start = start;
           this.end = end;
       }
     /**
     * constructor from four coordinates.
     * @param x1 the x coordinate of the first point that defines the line - start point.
     * @param y1 the y coordinate of the first point that defines the line - start point.
     * @param x2 the x coordinate of the second point that defines the line - end point.
     * @param y2 the y coordinate of the second point that defines the line - end point.
     */
           public Line(double x1, double y1, double x2, double y2) {
                this.start = new Point(x1 , y1);
                this.end = new Point(x2 , y2);
            }
    /**
     * this method calculates the length of the line.
     * @return the length of the line.
     */
           public double length() {
                return start.distance(end);
           }
    /**
     * this method calculates the middle point of the line.
     * @return the middle point of this line.
     */
           public Point middle() {
               double xMid , yMid;
               xMid = (this.start.getX() + this.end.getX()) / 2;
               yMid = (this.start.getY() + this.end.getY()) / 2;
               Point midPoint = new Point(xMid , yMid);
               return midPoint;
           }
    /**
     * this method returns the start point - the first point that definesthe line.
     * @return the start point of the line.
     */
           public Point start() {
                return this.start;
           }
     /**
     * this method returns the end point of the line - the second point that defines the line.
     * @return the end point of the line.
     */
           public Point end() {
                return this.end;
           }
    /**
     * this method calculates the slope of the line - the 'M' from y = Mx + N.
     * @return the slope of the line.
     */
            public double slope() {
                if ((this.end.getX() - this.start.getX()) != 0 && (this.end.getY() - this.start.getY()) != 0) {
                    double slope = ((this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX()));
                    return slope;
                } else {
                    return 0;
                }
            }
    /**
     * this method calculates the free value of the line - the 'N' from y = Mx + N.
     * @return tthe free value of the line.
     */
            public double n() {
                double valueOfN;
                double slope = this.slope();
                if (slope != 0) {
                    valueOfN = (this.start.getY() - (slope * this.start.getX()));
                } else {
                    valueOfN = this.start.getX();
                }
                return valueOfN;
            }
    /**
     * this method return the max x in the line - between the start and the end.
     * @return return the max value of x in the line.
     */
            public double maxX() {
                return Math.max(this.start.getX() , this.end.getX());
            }
    /**
     * this method return the max y in the line - between the start and the end.
     * @return return the max value of y in the line.
     */
            public double maxY() {
                return Math.max(this.start.getY() , this.end.getY());
            }
    /**
     * this method return the min x in the line - between the start and the end.
     * @return return the min value of x in the line.
     */
            public double minX() {
                return Math.min(this.start.getX() , this.end.getX());
            }
    /**
     * this method return the min y in the line - between the start and the end.
     * @return return the min value of y in the line.
     */
            public double minY() {
                return Math.min(this.start.getY() , this.end.getY());
            }
    /**
     * this method checks if the point is contained in the line.
     * @param point to check.
     * @return true if the point is in the line, and false if not.
     */
            public boolean isContainingPoint(Point point) {
                return (point.getX() >= this.minX() && point.getX() <= this.maxX()
                    && point.getY() >= this.minY() && point.getY() <= this.maxY());
            }
    /**
     * This method checks if a point is between line y values.
     * @param p is the point.
     * @return true if its between the values false otherwise
     */
    public boolean isBetweenY(Point p) {
        return (p.getY() <= this.maxY() + 0.001 && p.getY() >= this.minY() - 0.001);
    }
    /**
     * This method checks if a point is between this line x values.
     * @param p is the point.
     * @return true if its between the values false otherwise
     */
    public boolean isBetweenX(Point p) {
        return (p.getX() <= this.maxX() + 0.001 && p.getX() >= this.minX() - 0.001);
    }
    /**
     * This method returns the difference between the X start and the X end.
     * @param l is the line.
     * @return the difference between the start and the end.
     */
    public double dXLine(Line l) {
        return l.start.getX() - l.end.getX();
    }
    /**
     * This method returns the difference between the  Y start and the Y end.
     * @param l is the line.
     * @return the difference between the start and the end.
     */
    public double dYLine(Line l) {
        return l.end.getY() - l.start.getY();
    }
    /**
     * this method calculating the intersection point of two lines.
     * @param  other - the other line to check intersection with.
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        double dyOther = dYLine(other);
        double dxOther = dXLine(other);
        double cOther = dyOther * other.start.getX() + dxOther * other.start.getY();
        double dyThis = dYLine(this);
        double dxThis = dXLine(this);
        double cThis = dyThis * this.start.getX() + dxThis * this.start.getY();
        double det = dyThis * dxOther - dyOther * dxThis;
        if (det == 0) {
            // Lines are parallel - no intersection
            return null;
        } else {
            double intersectionX = (dxOther * cThis - dxThis * cOther) / det;
            double intersectionY = (dyThis * cOther - dyOther * cThis) / det;
            Point intersection = new Point(intersectionX , intersectionY);
            if (this.isContainingPoint(intersection) && other.isContainingPoint(intersection)) {
                return intersection;
            } else {
                return null;
            }
        }
    }
    /**
     * this method checks if two lines are intersecting.
     * @param  other - the other line to check intersection with.
     * @return true if the lines intersect, false otherwise.
     */
     public boolean isIntersecting(Line other) {
        double dyOther = dYLine(other);
        double dxOther = dXLine(other);
        double cOther = dyOther * other.start.getX() + dxOther * other.start.getY();
        double dyThis = dYLine(this);
        double dxThis = dXLine(this);
        double cThis = dyThis * this.start.getX() + dxThis * this.start.getY();
        double det = dyThis * dxOther - dyOther * dxThis;
        return (det != 0 && intersectionWith(other) != null);
     }
    /**
     * this method checks if two lines are the equals.
     * @param other another line.
     * @return true if the lines are equal, false otherwise.
     */
           public boolean equals(Line other) {
           return ((this.start.equals(other.start) && this.end.equals(other.end))
               || (this.start.equals(other.end) && this.end.equals(other.start)));
           }
         /**
     * this method return the closest intersection point to the start of the line.
     * @param rect a rectangle.
     * @return return the closest intersection point , null if this line does not intersect with the rectangle.
     */
   public Point closestIntersectionToStartOfLine(Rectangle rect) {

        List<Point> intersectionPoints = rect.intersectionPoints(this);
        if (!intersectionPoints.isEmpty()) {
            if (intersectionPoints.size() == 1) {
                return intersectionPoints.get(0);
            } else {
                    for (Point interPoint:intersectionPoints) {
                        double p1 = this.start.distance(intersectionPoints.get(0));
                        double p2 = this.start.distance(interPoint);
                        Point closestPoint = intersectionPoints.get(0);
                        if (p1 > p2) {
                            closestPoint = interPoint;
                        }
                        return closestPoint;
                    }
            }
        }
        return null;
    }
}