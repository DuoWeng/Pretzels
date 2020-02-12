import java.util.*;

import java.util.NoSuchElementException;
public class ArrayStreetParking implements StreetParking
{
    private ArrayQue carList;
    //flag to identify the end of street is blocked or not
    private boolean hasBlock;

     public ArrayStreetParking()
    {
        carList = new ArrayQue();
        hasBlock = false;
    }
    /**this method uses to test
    public String toString()
    {return carList.give();}
     */
    /**
     *
     * @param carID an identifier to represent the car
     * @return true if the car is successfully parked on the street and false otherwise (not enough room)
     */
    public boolean add(String carID)
    {
        if(carList.getSize() < carList.getCapacity())
        {
            carList.add(carID);
            return true;
        }
        return false;
    }
    /**
     * Remove the first car with matching id from the street
     *
     * @param carID
     * @return returns true if this is successful (false if the car is not on the street)
     */
    public boolean remove(String carID)
    {
        //return false if you can not find the car
        if(!carList.contains(carID))
            return false;
        String car;
        if(isBlockedExit())
        {
            //using stack to remember the original order
            Stack<String> temp = new Stack<>();
            car = carList.stackRemove();
            while(!car.equals(carID))
            {
                temp.push(car);
                car = carList.stackRemove();
            }
            //parks the temporarily removed cars back on the street
            // maintaining their original order.
            while(!temp.isEmpty())
            {carList.add(temp.pop());}
        }
        else
        {
            car = carList.queRemove();
            while(!car.equals(carID))
            {
                // he parks that car back onto the street and repeats the process.
                carList.add(car);
                car = carList.queRemove();
            }
        }

        return true;
    }
    /**
     * Has a local driver blocked the last parking spot on the street
     * @return true if a local driver has blocked the last spot
     */
    public boolean isBlockedExit()
    {
        return hasBlock;
    }
    /**
     * An unknown local driver attempts to block the exit of the street
     *
     * @return true if the local is successfully able to block the exit (also true on multiple calls to this function),
     *         false if the street is full and the local cannot block
     */
    public boolean blockExit()
    {
        if(carList.getSize() < carList.getCapacity())
        {
            setCapacity(carList.getCapacity()-1);
            hasBlock = true;
            return true;
        }
        return false;
    }
    /**
     * Make the end of the street clear for exits. If the end is not blocked this method has no consequence
     */
    public void unBlockExit()
    {
        if(isBlockedExit())
            hasBlock = false;setCapacity(carList.getCapacity()+1);
    }
    /**
     * Determine the capacity of the street, i.e., the number of parking spots
     *
     * @return the capacity of the street
     */
    public int capacity()
    { return carList.getCapacity(); }
    /**
     * Set the capacity of the street (i.e., the total number of parking spots)
     *
     * By default the capacity of the street is 5 spaces
     *
     * @param cap the total number of parking spots on the street to be set
     */
    public void setCapacity(int cap)
    {
        carList.setStreetCapacity(cap);
    }
    /**
     * Determine the number of occupied spots on the street (this includes locals who may be
     * occupying the end of the street and cars parked regularly
     * @return the total number of occupied spots on the street
     */
    public int size()
    {return carList.getSize();}
    /**
     * reset the street so the exit is unblocked and the capacity is 5 and George's car ("George" is car's id)
     * is the only one parked in the leftmost spot.
     * You can assume this method is always called before any tests are run.
     */
    public void reset()
    {
        carList = new ArrayQue(5);
        carList.add("George");
        hasBlock = false;
    }
    /**
     * Return an iterator that can iterates left to right over legally parked cars in the street
     *
     * @return Iterator<String>
     */
    public Iterator<String> iterator()
    {
        return carList.iterator();
    }

}