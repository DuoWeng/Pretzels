import java.util.Iterator;

/**
 * Interface to handle street parking situations
 * Iterable<String> is an interface
 */
public interface StreetParking extends Iterable<String>{

    /**
     *
     * @param carID an identifier to represent the car
     * @return true if the car is successfully parked on the street and false otherwise (not enough room)
     */
    public boolean add(String carID);

    /**
     * Remove the first car with matching id from the street
     *
     * @param carID
     * @return returns true if this is successful (false if the car is not on the street)
     */
    public boolean remove(String carID);

    /**
     * Has a local driver blocked the last parking spot on the street
     * @return true if a local driver has blocked the last spot
     */
    public boolean isBlockedExit();

    /**
     * An unknown local driver attempts to block the exit of the street
     *
     * @return true if the local is successfully able to block the exit (also true on multiple calls to this function),
     *         false if the street is full and the local cannot block
     */
    public boolean blockExit();

    /**
     * Make the end of the street clear for exits. If the end is not blocked this method has no consequence
     */
    public void unBlockExit();


    /**
     * Determine the capacity of the street, i.e., the number of parking spots
     *
     * @return the capacity of the street
     */
    public int capacity();

    /**
     * Set the capacity of the street (i.e., the total number of parking spots)
     *
     * By default the capacity of the street is 5 spaces
     *
     * @param cap the total number of parking spots on the street to be set
     */
    public void setCapacity(int cap);

    /**
     * Determine the number of occupied spots on the street (this includes locals who may be
     * occupying the end of the street and cars parked regularly
     * @return the total number of occupied spots on the street
     */
    public int size();


    /**
     * reset the street so the exit is unblocked and the capacity is 5 and George's car ("George" is car's id)
     * is the only one parked in the leftmost spot.
     * You can assume this method is always called before any tests are run.
     */
    public void reset();


    /**
     * Return an iterator that can iterates left to right over legally parked cars in the street
     *
     * @return
     */
     public Iterator<String> iterator();



}
