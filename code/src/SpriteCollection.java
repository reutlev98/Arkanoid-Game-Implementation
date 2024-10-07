//reut lev ID:207385741
import biuoop.DrawSurface;
import java.util.List;
import java.util.ArrayList;

/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-04-24
*/
public class SpriteCollection {
    /**
    * this class create a SpriteCollection.
    */
    private List<Sprite> spriteList;

    /**
     * constructor of Sprite Collection - Initializes a list of sprites.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<Sprite>();
    }

     /**
     * this method add sprites to the list.
     * @param  s the sprite we need to add.
     */
   public void addSprite(Sprite s) {
       this.spriteList.add(s);
   }

    /**
     * this method call timePassed() on all sprites.
     */
   public void notifyAllTimePassed() {
       for (int i = 0; i < this.spriteList.size(); i++) {
           this.spriteList.get(i).timePassed();
       }
   }

    /**
     * this method call drawOn(d) on all sprites.
     * @param  d the draw surface.
     */
   public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.spriteList.size(); i++) {
           this.spriteList.get(i).drawOn(d);
       }
   }

    /**
     * gets sprites.
     * @return the sprites list.
     */
    public List<Sprite> getSprites() {
        return this.spriteList;
    }
}