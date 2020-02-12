import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQue
{
    private String[] array;
    //the numbers of cars in the street
    private int currentSize;

    /**
     * constructor initialize instance variable
     */
     public ArrayQue()
    {this(0);}
     public ArrayQue(int i)
    {array = new String[i];currentSize = 0;}

    /**
     * remove the element from the beginning of this array,mimic stack
     * @return the element is removed
     */

    public String stackRemove()
    {
        if(isEmpty()) throw new NoSuchElementException();
        String str = array[0];
        //move the other elements behind it forward one step --shift left
        for(int i=1;i < currentSize;i++)
        {array[i-1] = array[i];}
        currentSize--;
        return str;
    }

    /**
     * add the element to the beginning of this array,it is same in two conditions
     * @param str a new car element
     */
    public void add(String str)
    {
        growIfFull();
        //shift left one step
        for(int i = currentSize-1;i >= 0;i--)
        {
            array[i+1] = array[i];
        }
        array[0] = str;
        currentSize++;
    }

    /**
     * remove the element from the end of this array--right
     * @return the element is removed
     */
    public String queRemove()
    {
        if(isEmpty()) throw new NoSuchElementException();
        String str = array[currentSize-1];
        currentSize--;
        return str;
    }

    /**
     * if the array is full,grow it
     */
    public void growIfFull()
    {
        if(currentSize == array.length)
        {
            String[] newArray = new String[2*currentSize];
            for(int i = 0;i < currentSize;i++)
            {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    /**
     * test if there is element or not
     * @return true if there is at least one element,otherwise false.
     */
    public boolean isEmpty()
    {
        return currentSize == 0;
    }

    /**
     * change the capacity of the array and maintain original elements order
     * @param i the capacity number
     */
    public void setStreetCapacity(int i)
    {
        if(i < currentSize) throw new ArrayStoreException();
        String[] newArray = new String[i];
        //for(int k = 0;k < currentSize;k++)
        //{newArray[k] = array[k];}
        //this is an another way to copy array
        System.arraycopy(array,0,newArray,0,currentSize);
        array = newArray;
    }

    /**
     * get the capacity of this array
     * @return int capacity
     */
    public int getCapacity()
    {return array.length;}

    /**
     * check if it contains certain element
     * @param str element
     * @return true if you can find this element in this data structure,otherwise false.
     */
    public boolean contains(String str)
    {
        for(String s:array)
        {
            if(s.equals(str))
                return true;
        }
        return false;
    }

    /**
     * return an iterator to visit all element in this structure
     * @return iterator object
     */
    public Iterator<String> iterator()
    {
        return new MyIterator();
    }

    /**
     * reture the number of current elements
     * @return int the number
     */
    public int getSize(){return currentSize;}

    /**
     * produce an iterator
     */

    class MyIterator implements Iterator<String>
    {
        int index;
        public MyIterator()
        {
            index = -1;
        }
        public boolean hasNext()
        {
            return !isEmpty() && index < currentSize-1;
        }
        public String next()
        {
            if(!hasNext()) throw new IllegalStateException();
            index++;return array[index];
        }
    }
    /** this method to use test
     * @return return a string array
    public String give()
    {return Arrays.toString(array);}
     */
}
