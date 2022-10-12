// --== CS400 Project One File Header ==--
// Name: <Gurusharan Kunusoth>
// CSL Username: <gurusharan>
// Email: <kunusoth@wisc.edu email address>
// Lecture #: <004 @4:00pm>
// Notes to Grader: <any optional extra notes to your grader>
/**
 * class uses two generic types
 * 
 * @author Sharan
 *
 * @param <KeyType>   the key for the pair
 * @param <ValueType> the value that is associated with a key in the pair
 */
public class Pair<KeyType, ValueType> {
  private KeyType key; // instance variable for the key
  private ValueType val; // instance variable for the value
  private Pair<KeyType, ValueType> next; // instance variable for the next pair
  private Pair<KeyType, ValueType> prev; // instance variable for the previous pair

  /**
   * constructor
   * 
   * @param key - the key for the pair
   * @param val - the value associated with the key
   */
  public Pair(KeyType key, ValueType val) {
    this.key = key;
    this.val = val;
    this.prev = null;
    this.next = null;
  }

  /**
   * Accessor for a previous pair
   * 
   * @return previous pair instance variable
   */
  public Pair<KeyType, ValueType> getPrev() {
    return this.prev;
  }

  /**
   * Accessor for a next pair
   * 
   * @return next pair instance variable
   */
  public Pair<KeyType, ValueType> getNext() {
    return this.next;
  }

  /**
   * Accessor for key of a pair
   * 
   * @return instance variable for the key of a pair
   */
  public KeyType getKey() {
    return this.key;
  }

  /**
   * Accessor for value of a pair
   * 
   * @return instance variable for the value of a pair
   */
  public ValueType getValue() {
    return this.val;
  }

  /**
   * Mutator previous pair is updated
   * 
   * @param prev -previous pair variable
   */
  public void setPrev(Pair<KeyType, ValueType> prev) {
    this.prev = prev;
  }

  /**
   * Mutator next pair gets updates
   * 
   * @param next - next pair variable
   */
  public void setNext(Pair<KeyType, ValueType> next) {
    this.next = next;
  }

  /**
   * Mutator key of the pair is updated
   * 
   * @param key - key variable of a pair
   */
  public void setKey(KeyType key) {
    this.key = key;
  }

  /**
   * Mutator value of pair is updated
   * 
   * @param val - value variable of a pair
   */
  public void setValue(ValueType val) {
    this.val = val;
  }
}
