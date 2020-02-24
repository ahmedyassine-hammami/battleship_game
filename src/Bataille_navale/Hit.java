package Bataille_navale;

import java.io.Serializable;
import java.util.NoSuchElementException;

public enum Hit implements Serializable {
    MISS(-1, "manqu�"),
    STIKE(-2, "touch�"),
    DESTROYER(2, "Fr�gate"),
    SUBMARINE(3, "Sous-marin"),
    BATTLESHIP(4, "Croiseur"),
    CARRIER(5, "Porte-avion");

    /* ***
     * Attributs
     */
    private int value;
    private String label;

    /* ***
     * Constructeur
     */
    Hit(int value, String label) {
        this.value = value;
        this.label = label;
    }

    /* ***
     * M�thodes
     */
    public static Hit fromInt(int value) {
        for (Hit hit : Hit.values()) {
            if (hit.value == value) {
                return hit;
            }
        }
        throw new NoSuchElementException("no enum for value " + value);
    }

    public String toString() {
        return this.label;
    }
};
