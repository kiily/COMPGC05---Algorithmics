package lecture3;

/**
 * Implementation of Sequence ADT.
 *
 * This class is an implementation of the Sequence using an Array as
 * the underlying data structure. The capacity is limited and
 * therefore must be specified in the constructor. Overflow can occur
 * when the array becomes full.
 */
public class SequenceArray<E> implements Sequence<E> {
  // Array containing the sequence.
  protected E[] objectArray;

  // Index of tail of sequence.
  protected int sequenceTail;

  // Index of head of sequence.
  protected int sequenceHead;

  // Number of items in the sequence.
  protected int sequenceSize;

  /**
   * Constructs a sequence with maximum capacity of 50 items.
   */
  public SequenceArray() {
    @SuppressWarnings("unchecked")
    E[] o = (E[]) new Object[50];
    objectArray = o;
    sequenceHead = 0;
    sequenceTail = 0;
    sequenceSize = 0;
  }

  /**
   * Constructs a sequence with specified maximum capacity.
   */
  public SequenceArray(int size) {
    @SuppressWarnings("unchecked")
    E[] o = (E[]) new Object[50];
    objectArray = o;
    sequenceHead = 0;
    sequenceTail = 0;
    sequenceSize = 0;
  }

  /**
   * Adds a new item at a specified position in the sequence.
   */
  public void insert(E o, int index)
  throws SequenceException {
    // First check that the array is not full.
    if (sequenceSize == objectArray.length) {
      throw new SequenceException("Sequence overflow");
    }

    // Even though the index goes from 0 to sequenceSize-1, we may
    // want to add an element at the end of the sequence, so index
    // is allowed to be equal to sequenceSize.
    else if (index >= 0 && sequenceSize >= index) {

      // Move all elements further along the sequence
      // forward one cell.

      for (int i=sequenceSize-1; i >= index; i--) {
        int oldIndex =
          (sequenceHead + i) % objectArray.length;
        int newIndex = (oldIndex + 1) % objectArray.length;
        objectArray[newIndex] = objectArray[oldIndex];
      }

      // Add the new element

      int arrayIndex =
        (sequenceHead + index) % objectArray.length;
      objectArray[arrayIndex] = o;

      // Update size and tail index.

      sequenceSize += 1;
      sequenceTail =
        (sequenceTail + 1) % objectArray.length;
    } else {
      throw new SequenceException(
              "Indexed element is out of range");
    }
  }

  /**
   * Adds a new item at the start of the sequence.
   */
  public void insertFirst(E o)
  throws SequenceException {
    if (sequenceSize < objectArray.length) {

      // Note here that we need to ensure the array index is
      // positive by adding objectArray.length before
      // applying the modulo operator.

      sequenceHead =
        (objectArray.length + sequenceHead -
         1) % objectArray.length;
      objectArray[sequenceHead] = o;
      sequenceSize += 1;
    } else {
      throw new SequenceException("Sequence Overflow");
    }
  }

  /**
   * Adds a new item at the end of the sequence.
   */
  public void insertLast(E o)
  throws SequenceException {
    if (sequenceSize < objectArray.length) {
      objectArray[sequenceTail] = o;
      sequenceTail =
        (sequenceTail + 1) % objectArray.length;
      sequenceSize += 1;
    } else {
      throw new SequenceException("Sequence Overflow");
    }
  }

  /**
   * Removes the item at the specified position in the sequence.
   */
  public void delete(int index)
  throws SequenceException {
    if (index >= 0 && sequenceSize > index) {

      // Move all elements further along the sequence
      // back one cell.

      for (int i=index+1; i < sequenceSize; i++) {
        int oldIndex =
          (sequenceHead + i) % objectArray.length;
        int newIndex =
          (objectArray.length + oldIndex -
           1) % objectArray.length;
        objectArray[newIndex] = objectArray[oldIndex];
      }

      // Update size and tail index.

      sequenceSize -= 1;
      sequenceTail =
        (objectArray.length + sequenceTail -
         1) % objectArray.length;
    } else {
      throw new SequenceException(
              "Indexed element is out of range");
    }
  }

  /**
   * Removes the item at the start of the sequence.
   */
  public void deleteFirst()
  throws SequenceException {
    if (sequenceSize != 0) {
      sequenceSize -= 1;
      sequenceHead =
        (sequenceHead + 1) % objectArray.length;
    } else {
      throw new SequenceException("Sequence Underflow");
    }
  }

  /**
   * Removes the item at the end of the sequence.
   */
  public void deleteLast()
  throws SequenceException {
    if (sequenceSize != 0) {
      sequenceSize -= 1;
      sequenceTail =
        (objectArray.length + sequenceTail -
         1) % objectArray.length;
    } else {
      throw new SequenceException("Sequence Underflow");
    }
  }

  /**
   * Returns the item at the specified position in the sequence.
   */
  public E element(int index)
  throws SequenceException {
    if (index >= 0 && sequenceSize > index) {
      return objectArray[(sequenceHead +
                          index) % objectArray.length];
    } else {
      throw new SequenceException(
              "Indexed element is out of range");
    }
  }

  /**
   * Returns the item at the start of the sequence.
   */
  public E first()
  throws SequenceException {
    if (sequenceSize != 0) {
      return objectArray[sequenceHead];
    } else {
      throw new SequenceException("Sequence Underflow");
    }
  }

  /**
   * Returns the item at the end of the sequence.
   */
  public E last()
  throws SequenceException {
    if (sequenceSize != 0) {
      return objectArray[(objectArray.length +
                          sequenceTail -
                          1) % objectArray.length];
    } else {
      throw new SequenceException("Sequence Underflow");
    }
  }

  /**
   * Returns the number of items in the sequence.
   */
  public int size() {
    return sequenceSize;
  }

  /**
   * Tests whether there are any items in the sequence.
   */
  public boolean empty() {
    return sequenceSize == 0;
  }

  /**
   * Empties the sequence.
   */
  public void clear() {
    sequenceTail = 0;
    sequenceHead = 0;
    sequenceSize = 0;
  }
}
