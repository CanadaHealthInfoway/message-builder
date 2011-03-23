package ca.infoway.messagebuilder.j5goodies;

/**
 * <p>A class that provides a final tally of counted items.  Used with
 * the <tt>Counter</tt> class to keep a running count of items.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * @param <T> - the type of thing being counted
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class Tally<T extends Comparable<T>> implements Comparable<Tally<T>> {

    private final T key;
    private final int count;

    Tally(T key, int count) {
        this.key = key;
        this.count = count;
    }
    /**
     * <p>Get the final count.
     * @return - the count of items
     */
    public int getCount() {
        return this.count;
    }
    /**
     * <p>The value being counted.
     * @return - the value
     */
    public T getKey() {
        return this.key;
    }
    /**
     * <p>Comparison method.
     * @param o - the item being compared 
     * @return - the comparison value, per the Comparator standards
     */
	public int compareTo(Tally<T> o) {
        if (o.count == this.count) {
            return this.key.compareTo(o.key);
        } else {
            return this.count - o.count;
        }
    }

	/**
	 * <p>Standard debug string.
	 * @return - the string
	 */
    public String toString() {
        return "" + this.key + " -> " + this.count;
    }

}
