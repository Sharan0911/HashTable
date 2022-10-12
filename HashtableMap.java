// --== CS400 Project One File Header ==--
// Name: <Gurusharan Kunusoth>
// CSL Username: <gurusharan>
// Email: <kunusoth@wisc.edu email address>
// Lecture #: <004 @4:00pm>
// Notes to Grader: <any optional extra notes to your grader>
import java.util.Arrays;

import java.util.NoSuchElementException;


/**
 * Hashing table is implemented using two generic type values
 * 
 * @author Sharan
 *
 * @param <KeyType>   the key of the pair
 * @param <ValueType> the value that is related to the key
 */
public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
  private Pair<KeyType, ValueType>[] hashtable;
  private int capacity;
  private int size;

  /**
   * constructor which creates a new hastable object
   * 
   * @param capacity - the capacity of the hashtable
   */
  @SuppressWarnings("unchecked")
  public HashtableMap(int capacity) {
    this.capacity = capacity;
    this.hashtable = new Pair[capacity];
  }

  /**
   * this constructor uses the same capacity
   */
  @SuppressWarnings("unchecked")
  public HashtableMap() { // with capacity = 20
    this.capacity = 20;
    this.hashtable = new Pair[20];
  }

  /**
   * Assds key-vaalue pairs
   * 
   * @param key   - the key of the pair
   * @param value - the value related to the key
   * @return true if a pair is added. False, otherwise.
   */
  @Override
  public boolean put(KeyType key, ValueType value) {
    Pair<KeyType, ValueType> currentPair = new Pair<KeyType, ValueType>(key, value);
    // checks if pair is in the array. If it is, exist falkse

    if (containsKey(key)) {
      return false;
    }
    // calculates the index where the pair is to be added
    int index = Math.abs(key.hashCode() % capacity);
    // if no pair at a particular index exists, increase the size and add the pair.
    if (hashtable[index] == null) {
      hashtable[index] = currentPair;
      size++;
      return true;
    } else {
      Pair<KeyType, ValueType> newpair = hashtable[index];

      while (newpair.getNext() != null) {
        newpair = newpair.getNext();
      }
      newpair.setNext(currentPair);
      size++;
    }

    // doubling method is called when the load factor is greater than or equal to 0.75
    if ((double) size / (double) capacity >= 0.75) {
      doubling();
    }
    return true;
  }

  /**
   * gets value of the pair with the help of key
   * 
   * @param key   - the key of the pair
   * @param value - the value associated with the key
   * @return the value of the key-value pair
   * @throws NoSuchElementException - when you use a key that does not exist in the array of
   *                                key-value pairs
   */
  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    for (int i = 0; i < hashtable.length; i++) {
      if (hashtable[i] != null) {
        Pair<KeyType, ValueType> currentPair = hashtable[i];
        // if currentpair matches pparameter, return value nwith key
        while (currentPair != null) {
          if (currentPair.getKey().equals(key)) {
            return currentPair.getValue();
          }
          // set currentpair to next in the array
          currentPair = currentPair.getNext();
        }
      }
    }
    // exception is thrown when theres pair with the key
    throw new NoSuchElementException("There does not exist key-value pair for that key.");
  }

  /**
   * size of the hashtable si returned
   * 
   * @returns size of the hashtable
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * checks whether arraay had pair with guiven param
   * 
   * @param key - the key of the pair
   * @return true if a pair with the key exists in the array, false otherwise
   */
  @Override
  public boolean containsKey(KeyType key) {
    for (int i = 0; i < hashtable.length; i++) {
      if (hashtable[i] != null) {
        Pair<KeyType, ValueType> currentPair = hashtable[i];
        // if key of current pair matches to the parameter key, true is returned.
        while (currentPair != null) {
          if (currentPair.getKey().equals(key)) {
            return true;
          }
          // set currentpair to next pair
          currentPair = currentPair.getNext();
        }
      }
    }
    return false;
  }

  /**
   * A pair from the array is removed with this method
   * 
   * @param key - the key of the pair
   * @return the value of the key-value pair that is removed and null if nothing is removed
   */
  @Override
  public ValueType remove(KeyType key) {
    for (int i = 0; i < hashtable.length; i++) {
      Pair<KeyType, ValueType> prevPair = null;

      if (hashtable[i] != null) {
        Pair<KeyType, ValueType> currentPair = hashtable[i];
        // if key of currentpair matches with param key, decrease sizes and returns value
        while (currentPair != null) {
          if (currentPair.getKey().equals(key)) {

            size--;
            // if prev pair aint null, se next pair to currentpair
            if (prevPair != null) {
              prevPair.setNext(currentPair.getNext());
            } else {
              hashtable[i] = currentPair.getNext();
            }
            return currentPair.getValue();
          }
          // prevpair is updated
          prevPair = currentPair;
          currentPair = currentPair.getNext();
        }
      }
    }
    return null;
  }

  /**
   * all pairs in arrays are removed size is decreased each time a pair is removed
   */
  @Override
  public void clear() {
    for (int i = 0; i < hashtable.length; i++) {
      while (hashtable[i] != null) {
        hashtable[i] = null;
        size--;
      }
    }
  }

  /**
   * This private helper method updates the hashtable array by doubling its capacity
   */
  private void doubling() {
    // capacity is doubled
    this.capacity = capacity * 2;
    // copies contents of array
    hashtable = Arrays.copyOf(duplicate(), capacity);
  }

  /**
   * helper methos which creates a copy of array
   * 
   * @return copies values
   */
  private Pair<KeyType, ValueType>[] duplicate() {
    Pair<KeyType, ValueType> copy[] = hashtable.clone();
    return copy;
  }
}
