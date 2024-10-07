//reut lev ID:207385741
import biuoop.GUI;
import biuoop.DrawSurface;
import java.awt.Color;
import biuoop.KeyboardSensor;


/**
* @author reut lev ID:207385741
* @version 1.5
* @since 2021-04-24
*/

public class Paddle implements Sprite, Collidable {
    /**
    * this class create a paddle.
    */
    private KeyboardSensor keyboard;
    private static int screenWidth;
    private static int screenHeight;
    private  int width;
    private  int height;
    private Rectangle rectangle;
    private int paddleSpeed;

    /**
     * constructor of paddle from width,height and gui.
     * @param  screenWidth the screen width.
     * @param  screenHeight the screen height.
     * @param  gui to create a  keyboard sensor.
     */
  public Paddle(int screenWidth, int screenHeight, GUI gui) {
        this.width = 50;
        this.height = 5;
        this.paddleSpeed = (this.width / 10);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        Point point = new Point((this.screenWidth - this.width) / 2 , this.screenHeight - 5 * this.height);
        this.rectangle = new Rectangle(point, this.width, this.height);
        this.keyboard = gui.getKeyboardSensor();
    }
    /**
     * constructor of paddle.
     * @param  paddleWidth the paddle width.
     * @param  paddleSpeed the paddle speed.
     * @param  screenWidth the screen width.
     * @param  screenHeight the screen height.
     * @param  gui to create a  keyboard sensor.
     */
     public Paddle(int paddleWidth , int paddleSpeed , int screenWidth , int screenHeight , GUI gui) {
        this.width = paddleWidth;
        this.height = 5;
        this.paddleSpeed = paddleSpeed;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        Point point = new Point((this.screenWidth - this.width) / 2 , this.screenHeight - 5 * this.height);
        this.rectangle = new Rectangle(point, this.width, this.height);
        this.keyboard = gui.getKeyboardSensor();
    }
    /**
     * this method Return the KeyBoard.
     * @return a KeyBoard.
     */
    public KeyboardSensor getKeyBoard() {
        return this.keyboard;
    }
    /**
     * this method Return the paddle Width.
     * @return the paddle width.
     */
    public int getPaddleWidth() {
        return this.width;
    }
    /**
     * this method Return the paddle height.
     * @return the paddle height.
     */
    public int getPaddleHeight() {
        return this.height;
    }
    /**
     * this method moves the paddle to the left.
     */
   public void moveLeft() {
       double x , y;
         if (this.rectangle.getUpperLeft().getX() - this.paddleSpeed < 20) {
               x = 20;
           }  else {
            x = this.rectangle.getUpperLeft().getX() - this.paddleSpeed;
           }
        y = this.rectangle.getUpperLeft().getY();
       this.rectangle = new Rectangle(x , y , this.width , this.height);
   }
    /**
     * this method moves the paddle to the right.
     */
   public void moveRight() {
       double x , y;
             if (this.rectangle.getUpperLeft().getX() + this.width + this.paddleSpeed > screenWidth - 20) {
               x = (screenWidth - this.width) - 20;
           } else {
            x = this.rectangle.getUpperLeft().getX() + this.paddleSpeed;
           }
        y = this.rectangle.getUpperLeft().getY();
       this.rectangle = new Rectangle(x , y , this.width , this.height);
   }

   // Sprite
    /**
     * this method  notify the sprite that time has passed.
     */
   public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
                this.moveRight();
        }
   }
   /**
     * this method draw the object to the screen.
     * @param d - draw surface.
     */
   public void drawOn(DrawSurface d) {
        d.setColor(Color.MAGENTA);
        d.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                        (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                        (int) rectangle.getWidth(), (int) rectangle.getHeight());
   }

   // Collidable
   /**
     * this method Return the "collision shape" of the object.
     * @return a rectangle.
     */
   public Rectangle getCollisionRectangle() {
       return this.rectangle;
   }
     /**
     * This notify the object that we collided with it at collision point.
     * @param hitter a ball.
     * @param collisionPoint a collition point with an object.
     * @param currentVelocity the current velocity.
     * @return the new velocity expected after the hit.
     */
    public Velocity hit(Ball hitter , Point collisionPoint, Velocity currentVelocity) {
        double xCorOfPaddle = this.rectangle.getUpperLeft().getX();
        double paddlePart = ((width / 5) + xCorOfPaddle);
        //calculation of speed according to Pythagoras
        double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        double collisionPointX = collisionPoint.getX();
        if (collisionPointX <= paddlePart) {
            return Velocity.fromAngleAndSpeed(300, speed);
        } else {
            if (collisionPointX <= 2 * paddlePart) {
                return Velocity.fromAngleAndSpeed(330, speed);
            } else {
                if (collisionPointX <= 3 * paddlePart) {
                    return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
                } else {
                    if (collisionPointX <= 4 * paddlePart) {
                        return Velocity.fromAngleAndSpeed(30, speed);
                    }
                }
                return Velocity.fromAngleAndSpeed(60, speed); // collisionPointX =5
            }
        }
    }
    /**
     * This method add this paddle to the game.
     * @param game a gamelevel object.
     */
   public void addToGame(GameLevel game) {
       game.addCollidable(this);
       game.addSprite(this);
   }

   /**
     * This notify the object that we collided with it at collision point.
     * without dividing the paddle into different parts.
     * @param collisionPoint a collition point with an object.
     * @param currentVelocity the current velocity.
     * @return the new velocity expected after the hit.
     */
      public Velocity hitNotFun(Point collisionPoint, Velocity currentVelocity) {
           boolean changeX = false , changeY = false;
        if (this.rectangle.getLeft().isContainingPoint(collisionPoint)
            || this.rectangle.getRigtht().isContainingPoint(collisionPoint)) {
            changeX = true;
        }
        if (this.rectangle.getBottom().isContainingPoint(collisionPoint)
            || this.rectangle.getTop().isContainingPoint(collisionPoint)) {
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
        }
        // velocity does not change
        return currentVelocity;
   }

   /**
     * collided with it at collision point.
     * @param collisionPoint a collition point with an object.
     * @param currentVelocity the current velocity.
     * @return the collision point.
     */
   public Point sideHit(Point collisionPoint, Velocity currentVelocity) {
        if (this.rectangle.getLeft().isBetweenX(collisionPoint)
            || this.rectangle.getRigtht().isBetweenX(collisionPoint)
            || this.rectangle.getBottom().isBetweenY(collisionPoint)) {
            return new Point(collisionPoint.getX() , collisionPoint.getY() + this.height);
        }
        return collisionPoint;
   }
}