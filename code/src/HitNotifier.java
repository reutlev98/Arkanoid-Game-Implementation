
/**
* @author reut lev ID:207385741
* @version 1.0
* @since 2021-05-02
*/

public interface HitNotifier {
    /**
    * this interface create a hit notifier.
    */

    /**
     * Add hl as a listener to hit events.
     * @param hl a hit listener.
     */
    void addHitListener(HitListener hl);

    /**
     * This method Remove hl from the list of listeners to hit events.
     * @param hl a hit listener.
     */
    void removeHitListener(HitListener hl);
}