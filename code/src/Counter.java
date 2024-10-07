
/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-05-04
*/


public class Counter {
     /**
    * this class represente a counter.
    */
    private int value;

     /**
     * construct a counter from a value.
     * @param value the value.
     */
    public Counter(int value) {
        this.value = value;
    }
    /**
     * this method add number to current count.
     * @param number the number we add to counter.
     */
   void increase(int number) {
       this.value += number;
   }
   /**
     * this method subtract number from current count.
     * @param number the number decrease from counter.
     */
   void decrease(int number) {
       this.value -= number;
   }
   /**
     * get current count.
     * @return the current count.
     */
   int getValue() {
       return this.value;
   }
}