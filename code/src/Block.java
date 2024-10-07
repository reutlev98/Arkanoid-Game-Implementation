//reut lev ID:207385741
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-05-03
*/
public class Block implements Collidable , Sprite , HitNotifier  {
    /**
    * This class represents a Block .
    *
    */
    private Rectangle rectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners; // list of hit listeners.

     /**
     * constructor create a new block from rectangle and color.
     * @param rectangle a rectangle.
     * @param color rectangle's color.
     */
    public Block(Rectangle rectangle , java.awt.Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }
     /**
     * constructor create a new block from rectangle (create rectangle from location and width/height) and color.
     * @param upperLeft is the location of the rectangle's upper-left point.
     * @param width the rectangle's width.
     * @param height the rectangle's height.
     * @param color rectangle's color.
     */
    public Block(Point upperLeft, double width, double height, java.awt.Color color) {
        this.rectangle = new Rectangle(upperLeft , width , height);
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }
     /**
     * constructor create a new block from rectangle (create rectangle from coordinate and width/height) and color.
     * @param x is the x coordinate of the location of the rectangle's upper-left point.
     * @param y is the y coordinate of location of the rectangle's upper-left point.
     * @param width the rectangle's width.
     * @param height the rectangle's height.
     * @param color rectangle's color.
     */
    public Block(double x , double y , double width , double height , java.awt.Color color) {
        this.rectangle = new Rectangle(x , y , width , height);
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }
     /**
     * constructor create a new block from rectangle (create rectangle from coordinate and width/height) and color.
     * @param x is the x coordinate of the location of the rectangle's upper-left point.
     * @param y is the y coordinate of location of the rectangle's upper-left point.
     * @param width the rectangle's width.
     * @param height the rectangle's height.
     */
    public Block(double x, double y, double width, double height) {
        this.rectangle = new Rectangle(x , y , width , height);
        this.hitListeners = new ArrayList<HitListener>();
    }
    /**
     * this method returns rectangle.
     * @return rectangle.
     */
     public  Rectangle getCollisionRectangle() {
         return this.rectangle;
     }

    /**
     * This method notify the object that we collided with it at collisionPoint with a given velocity.
     * @param hitter ball hit.
     * @param collisionPoint collition point.
     * @param currentVelocity current velocity.
     * @return new velocity expected after the hit.
     */
     public Velocity hit(Ball hitter , Point collisionPoint, Velocity currentVelocity) {
          this.notifyHit(hitter);
        boolean changeX = false , changeY = false;
        // if  colliding left or right change x to -x
        if (this.rectangle.getLeft().isBetweenX(collisionPoint)
            || this.rectangle.getRigtht().isBetweenX(collisionPoint)) {
            changeX = true;
        }
        // if If colliding top or bottom change y to -y
        if (this.rectangle.getBottom().isBetweenY(collisionPoint)
            || this.rectangle.getTop().isBetweenY(collisionPoint)) {
            changeY = true;
        }
        if (changeX && changeY) {
            return new Velocity(currentVelocity.getDx() * -1 , currentVelocity.getDy() * -1);
        } else {
            if (changeX) {
                return new Velocity(currentVelocity.getDx() * -1 , currentVelocity.getDy());
            }
            if (changeY) {
                return new Velocity(currentVelocity.getDx() , currentVelocity.getDy() * -1);
            }
                return currentVelocity;
    }
}

     /**
     * this method draw the block on the given DrawSurface.
     * @param surface - DrawSurface.
     */
       public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) (this.rectangle.getUpperLeft().getX()) ,
        (int) (this.rectangle.getUpperLeft().getY()) , (int) (this.rectangle.getWidth()) ,
        (int) (this.rectangle.getHeight()));
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) (this.rectangle.getUpperLeft().getX()) ,
        (int) (this.rectangle.getUpperLeft().getY()) , (int) (this.rectangle.getWidth()) ,
        (int) (this.rectangle.getHeight()));
   }
     /**
     * this method notify the sprite that time has passed.
     */
   public void timePassed() {
   }

     /**
     * this method add block to the game.
     * @param game - add block to the game.
     */
   public void addToGame(GameLevel game) {
       game.addCollidable(this);
       game.addSprite(this);
   }

   /**
     * Remove block from game.
     * @param game the game.
     */
   public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
   }


    /**
     * Add hl as a listener to hit events.
     * @param hl hit listener.
     */
   public void addHitListener(HitListener hl) {
       this.hitListeners.add(hl);
   }

   /**
     * Remove hl from the list of listeners to hit events.
     * @param hl hit listener.
     */
   public void removeHitListener(HitListener hl) {
       this.hitListeners.remove(hl);
   }

    /**
     * notify hit - Notify all listeners about a hit event.
     * @param hitter the hitter
     */
      private void notifyHit(Ball hitter) {
      // Make a copy of the hitListeners before iterating over them.
      List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
      // Notify all listeners about a hit event:
      for (HitListener hl : listeners) {
         hl.hitEvent(this, hitter);
      }
   }
}