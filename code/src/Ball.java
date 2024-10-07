//reut lev ID:207385741
import biuoop.DrawSurface;
/**
* @author reut lev ID:207385741
* @version 1.6
* @since 2021-04-05
*/
public class Ball implements Sprite {
    /**
    * this class represente a ball.
    */
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
     /**
     * constructor ball from point, radius and color.
     * @param center is the location of the ball's center.
     * @param r the ball's radius.
     * @param color the ball's color.
     */
   public Ball(Point center, int r, java.awt.Color color) {
       this.center = center;
       this.radius = r;
       this.color = color;
       this.gameEnvironment = new GameEnvironment();
   }
        /**
     * constructor ball from two coordinates, radius and color.
     * @param x is the x coordinate of the location of the ball.
     * @param y is the y coordinate of the location of the ball.
     * @param r the ball's radius.
     * @param color the ball's color.
     */
    public Ball(int x , int y , int r , java.awt.Color color) {
       this.center = new Point(x , y);
       this.radius = r;
       this.color = color;
      this.gameEnvironment = new GameEnvironment();
   }
     /**
     * constructor ball from point, radius and color.
     * @param center is the location of the ball's center.
     * @param r the ball's radius.
     * @param color the ball's color.
     * @param gameEnvironment the game environment.
     */
   public Ball(Point center, int r, java.awt.Color color , GameEnvironment gameEnvironment) {
       this.center = center;
       this.radius = r;
       this.color = color;
       this.gameEnvironment = gameEnvironment;
   }
     /**
     * constructor ball from two coordinates, radius and color.
     * @param x is the x coordinate of the location of the ball.
     * @param y is the y coordinate of the location of the ball.
     * @param r the ball's radius.
     * @param color the ball's color.
     * @param gameEnvironment the game environment.
     */
    public Ball(int x , int y , int r , java.awt.Color color , GameEnvironment gameEnvironment) {
       this.center = new Point(x , y);
       this.radius = r;
       this.color = color;
       this.gameEnvironment = gameEnvironment;
   }
    /**
     * this method returns the x coordinate of the ball's center.
     * @return the x coordinate of the ball's center.
     */
   public int getX() {
       return (int) this.center.getX();
   }
   /**
     * this method returns the y coordinate of the ball's center.
     * @return the y coordinate of the ball's center.
     */
   public int getY() {
       return (int) this.center.getY();
   }
   /**
     * this method returns the ball's radius.
     * @return the ball radius.
     */
   public int getSize() {
       return this.radius;
   }
   /**
     * this method returns the ball's color.
     * @return the ball's color.
     */
   public java.awt.Color getColor() {
       return this.color;
   }
      /**
     * this method returns the y coordinate of the board.
     * @return the y coordinate of the board.
     */
    public GameEnvironment getGameEnvironment() {
       return this.gameEnvironment;
   }
     /**
     * This method sets the center point of a Ball.
     * @param p the new point
     */
    public void setCenter(Point p) {
        this.center = p;
    }
    /**
     * This method sets the center point of a Ball by x and y values.
     * @param x is the x value
     * @param y is the y value
     */
    public void setCenter(double x, double y) {
        this.center = new Point(x, y);
    }
   /**
     * this method draw the ball on the given DrawSurface.
     * @param surface - DrawSurface.
     */
   public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
       surface.fillCircle(this.getX() , this.getY() , this.getSize());
   }
   /**
     * this method set the ball's velocity.
     * @param v ball's velocity.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }
    /**
     * this method set the ball's velocity.
     * @param dx - the change in the position on the x axes.
     * @param dy - the change in the position on the y axes.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx , dy);
    }
     /**
     * this method returns the ball's velocity.
     * @return the ball's velocity.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }
     /**
     * this method moves the ball's center according to it's velocity.
     */
    public void moveOneStep() {
        Point nextPoint = this.getVelocity().applyToPoint(this.center);
        Line newLine = new Line(this.center, nextPoint);
        CollisionInfo collitionInfo = gameEnvironment.getClosestCollision(newLine);
        if (collitionInfo != null) {
            //center = almost the hit point
            this.setCenter(collitionInfo.collisionPoint().getX() - this.velocity.getDx(),
                    collitionInfo.collisionPoint().getY() - this.velocity.getDy());
            Velocity newVelocity = collitionInfo.collisionObject().hit(
                            this , collitionInfo.collisionPoint(), this.velocity);
            this.setVelocity(newVelocity); //sets the new velocity
        } else {
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }
     /**
     * this method notify the sprite that time has passed.
     */
   public void timePassed() {
       this.moveOneStep();
   }
    /**
     * this method add ball to the game.
     * @param game - add ball to the game.
     */
     public void addToGame(GameLevel game) {
       game.addSprite(this);
   }
   /**
     * this method remove ball from the game.
     * @param game - remove ball from the game.
     */
   public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}
