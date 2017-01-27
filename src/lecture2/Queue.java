package lecture2;

/*
 * Queue interface implemented with Generics
 */
public interface Queue<E> {
  /**
   * Adds a new item to the tail of the queue.
   */
  public void enQueue(E e)
  throws QueueException;

  /**
   * Removes and returns the item at the head of the queue.
   */
  public E deQueue()
  throws QueueException;

  /**
   * Returns the item at the head of the queue without removal.
   */
  public E head()
  throws QueueException;

  /**
   * Tests to see if the queue is empty.
   */
  public boolean empty();

  /**
   * Removes all items from the queue.
   */
  public void clear();
}
