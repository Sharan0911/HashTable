// --== CS400 Project One File Header ==--
// Name: <Gurusharan Kunusoth>
// CSL Username: <gurusharan>
// Email: <kunusoth@wisc.edu email address>
// Lecture #: <004 @4:00pm>
// Notes to Grader: <any optional extra notes to your grader>
import java.util.NoSuchElementException;

/**
 * test class for HashtableMap.java
 * 
 * @author Sharan
 *
 */
public class HashtableMapTests {
  /**
   * test class consisting put and get methods
   * 
   * @return true if all tests pass and fail if anyone the test fails
   */
  public static boolean test1() {
    // new integer type of HashtableMap object for key and value
    HashtableMap<Integer, Integer> table1 = new HashtableMap<Integer, Integer>(7);
    // key-value pairs
    table1.put(14, 1);
    table1.put(9, 12);
    table1.put(5, 11);
    table1.put(6, 11);
    table1.put(13, 1);

    // increment of size by adding a dupilacate is checked
    if (table1.size() != 4) {
      return false;
    }
    // checks if put method works with each key
    if (table1.get(8) != 10) {
      return false;
    }
    if (table1.get(5) != 11) {
      return false;
    }
    if (table1.get(6) != 11) {
      return false;
    }
    if (table1.get(13) != 1) {
      return false;
    }
    // if key doesnt exist, an exception is thrown
    try {
      if (table1.get(7) != null) {
        return false;
      }
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
    return true;
  }

  /**
   * test class for clear
   * 
   * @return true if test passes, false if it fails
   */
  public static boolean test2() {
    // new integer type of HashtableMap object for key and value

    HashtableMap<Integer, Integer> table2 = new HashtableMap<Integer, Integer>(6);
    // key-value pairs
    table2.put(3, 2);
    table2.put(69, 420);
    table2.put(777, 77777);
    table2.clear();// clears hashtable of the pairs
    // checks if sixe of hashtable is 1
    if (table2.size() != 1) {
      return false;
    }
    return true;
  }

  public static boolean test3() {
    // create new HashTableMap object with integer type for the key and value
    HashtableMap<Integer, Integer> table3 = new HashtableMap<Integer, Integer>(5);
    // key value pairs
    table3.put(9898, 1000);
    table3.put(12, 24);
    table3.put(3, 3);

    // checks if hastable contains pair using the key
    if (!table3.containsKey(9898)) {
      return false;
    }
    return true;
  }

  public static boolean test4() {
    HashtableMap<Integer, Integer> table4 = new HashtableMap<Integer, Integer>(8);

    table4.put(65, 14);
    table4.put(14, 45);
    table4.put(56, 43);
    // pair with this key removed
    table4.remove(65);
    if (table4.containsKey(65)) {
      return false;
    }
    return true;
  }

  public static boolean test5() {
    HashtableMap<Integer, Integer> table5 = new HashtableMap<Integer, Integer>(6);

    table5.put(21, 12);
    table5.put(122, 221);
    table5.put(32, 23);
    table5.put(42, 24);
    // checks if size of hashtable is 4
    if (table5.size() != 4) {
      return false;
    }
    return true;
  }

  /**
   * Main method which is used to print the results
   * 
   * @param args
   */
  public static void main(String args[]) {
    System.out.println(test1());
    System.out.println(test2());
    System.out.println(test3());
    System.out.println(test4());
    System.out.println(test5());
  }

}
