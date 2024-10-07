//reut lev ID:207385741
import biuoop.KeyboardSensor;
import biuoop.DrawSurface;
/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-11
*/

public class KeyPressStoppableAnimation implements Animation {
     /**
     * this class create a KeyPressStoppableAnimation.
     */
    private KeyboardSensor keyboardSensor;
    private String keyM;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * constructor create a KeyPressStoppableAnimation by KeyboardSensor , string and animation.
     * @param sensor a KeyboardSensor.
     * @param keyM a string that contains the keyPress.
     * @param animation an animation.
     */
   public KeyPressStoppableAnimation(KeyboardSensor sensor, String keyM, Animation animation) {
        this.stop = false;
        this.isAlreadyPressed = true;
        this.keyboardSensor = sensor;
        this.keyM = keyM;
        this.animation = animation;
   }
    /**
     * this method create one frame of the game.
     * @param drawSurface a draw surface.
     */
    public void doOneFrame(DrawSurface drawSurface) {
        if (!keyboardSensor.isPressed(keyM)) {
        this.isAlreadyPressed = false;
        } else {
             if (!this.isAlreadyPressed) {
                this.stop = true;
            }
        }
        this.animation.doOneFrame(drawSurface);
    }

    /**
     * This method retuen if the game need to stop.
     * @return true if need to stop.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}