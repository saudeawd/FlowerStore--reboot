package flower.store;

/**
 * Enum representing flower colors.
 */
public enum FlowerColor {
    /** Red color. */
    RED("#FF0000"),
    /** Blue color. */
    BLUE("#0000FF");

    /** String representation of the color. */
    private final String stringRepresentation;

    /**
     * Constructor.
     * @param colorString the string representation
     */
    FlowerColor(final String colorString) {
        this.stringRepresentation = colorString;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
