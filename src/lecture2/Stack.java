package lecture2;

public interface Stack {
  /**
   * Adds a new item to the top of the stack.
   */
  public void push(Object o)
  throws StackException;

  /**
   * Removes and returns the item at the top of the stack.
   */
  public Object pop()
  throws StackException;

  /**
   * Returns the item at the top of the stack without removal.
   */
  public Object top()
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

