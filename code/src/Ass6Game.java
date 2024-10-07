//reut lev ID:207385741
import biuoop.GUI;
import biuoop.Sleeper;
import java.util.ArrayList;
import java.util.List;

/**
* @author reut lev ID:207385741
* @version 1.2
* @since 2021-06-11
*/

public class Ass6Game {
    /**
    * this class run a game.
    */

    /**
     * This method retuen if the string have only digits.
     * @param str the string we check.
     * @param len the length of the string.
     * @return true if the string contain only digits.
     */
   public static boolean onlyDigits(String str, int len) {
        for (int i = 0; i < len; i++) {
            return (str.charAt(i) >= '0' && str.charAt(i) <= '9');
        }
        return false;
    }

     /**
     * this main creates a new object of game flow.
     * @param args command line arguments - gets the levels of the game.
     */
       public static void main(String[] args) {
        GUI gui = new GUI("Arkanold", 800, 600);
        GameFlow gameFlow = new GameFlow(new AnimationRunner(gui, new Sleeper()), gui.getKeyboardSensor());
         List<LevelInformation> levelsArray = new ArrayList<LevelInformation>();
         boolean isGameEmpty = true;
         if (args.length != 0) {
             for (int i = 0; i < args.length; i++) {
                  if (onlyDigits(args[i], args[i].length())) {
                  int levelNumber = Integer.parseInt(args[i]);
                switch (levelNumber) {
                    case (1):
                        levelsArray.add(new DirectHit());
                        isGameEmpty = false;
                        break;
                    case (2):
                         levelsArray.add(new WideEasy());
                         isGameEmpty = false;
                        break;
                    case (3):
                        levelsArray.add(new Green3());
                        isGameEmpty = false;
                        break;
                    case (4):
                        levelsArray.add(new FinalFour());
                        isGameEmpty = false;
                        break;
                    default :
                        break;
                }
              }
            }
         }
         if (args.length == 0 || isGameEmpty) {
             levelsArray.add(new DirectHit());
             levelsArray.add(new WideEasy());
             levelsArray.add(new Green3());
             levelsArray.add(new FinalFour());
         }
        gameFlow.runLevels(levelsArray);
    }
}

