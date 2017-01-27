package lecture2;

/*
 * Same implementation as the Stack interface but here we use generics instead for improved
 * type checking.
 */
public interface StackGeneric<E> {
  /**
   * Adds a new item to the top of the stack.
   */
  public void push(E e)
  throws StackException;

  /**
   * Removes and returns the item at the top of the stack.
   */
  public E pop()
  throws StackException;

  /**
   * Returns the item at the top of the stack without removal.
   */
  public E top()
  throws StackException;

  /**
   * Tests to see if the stack is empty.
   */
  public boolean empty();

  /**
   * Removes all items from the stack.
   */
  public void clear();
}

