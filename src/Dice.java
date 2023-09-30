/**
 * Dice Class
 * @author Matthew Gee
 * @since November 2022
 *
 * Simple Dice object containing the faceValue of the object.
 */
public class Dice {
    public int faceValue; // value of dice face

    /**
     * roll()
     * generate a random face value between 1 and 6
     */
    public void roll() { faceValue = (int) (Math.random() * 6) + 1; }


    /**
     * getFaceValue()
     * @return faceValue of dice object
     */
    public int getFaceValue() { return faceValue; }


    /**
     * toString()
     * @return faceValue of dice object as a string
     */
    public String toString() { return String.valueOf(faceValue); }
}
