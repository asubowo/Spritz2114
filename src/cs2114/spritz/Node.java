package cs2114.spritz;

/**
 * This is the node class pulled from an old assignment
 * @param <E> the element type stored in the node
 *
 * @author  Andrew Subowo (asubowo)
 * @author Meghan Hamannwright Meghankh
 * @author Cory Howard (arch518)
 * @version 2.28.2014
 */
public class Node<E>
{
    //~ Fields ................................................................

    // The data element stored in the node.
    private E data;

    // The next node in the sequence.
    private Node<E> next;

    // The previous node in the sequence.
    private Node<E> previous;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Node with the specified data.
     *
     * @param data the data for the node
     */
    public Node(E data)
    {
        this.data = data;
    }

    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Gets the data in the node.
     *
     * @return the data in the node
     */
    public E data()
    {
        return data;
    }

    // ----------------------------------------------------------
    /**
     * Sets the data in the node.
     *
     * @param newData the new data to put in the node
     */
    public void setData(E newData)
    {
        data = newData;
    }


    // ----------------------------------------------------------
    /**
     * Gets the node that follows this one in the sequence.
     *
     * @return the node that follows this one in the sequence
     */
    public Node<E> next()
    {
        return next;
    }


    // ----------------------------------------------------------
    /**
     * Gets the node that precedes this one in the sequence.
     *
     * @return the node that precedes this one in the sequence
     */
    public Node<E> previous()
    {
        return previous;
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Joins this node to the specified node so that the one passed as a
     * parameter follows this node. In other words, writing {@code A.join(B)}
     * would create the linkage A <-> B.
     * </p><p>
     * This method should throw an IllegalStateException if this node already
     * has another node following it, or if {@code newNext} already has another
     * node preceding it. In this case, it's up to the user to call
     * {@link #split()} to sever the connection between the nodes before they
     * can join them to something else.
     * </p><p>
     * It is acceptable for {@code newNext} to be null if this node's next
     * reference is already null. This situation should not throw an exception.
     * </p><p>
     * After connecting the nodes, the method should return {@code this}, which
     * allows users to nest multiple calls to join to create longer chains,
     * like {@code A.join(B.join(C))}.
     * </p>
     *
     * @param newNext the node that should follow this one
     * @return this node
     *
     * @throws IllegalStateException if there is already a node following this
     *     node or if there is already a node preceding {@code newNext}
     */
    public Node<E> join(Node<E> newNext)
    {

        if (this.next != null)
        {
            throw new IllegalStateException("There is a node already next.");
        }

        else if (newNext != null && newNext.previous != null) {
            throw new IllegalStateException("Node b already has a previous.");
        }

        else {
            this.next = newNext;
            if (newNext != null) {
                newNext.previous = this;
            }
            return this;
        }
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Splits this node from its follower and then returns the follower.
     * </p><p>
     * It is acceptable for this method to be called on a node that has a null
     * follower. In that case, the method simply does nothing and returns null.
     * </p><p>
     * There are no circumstances under which this method should throw an
     * exception.
     * </p>
     *
     * @return the node that followed this node before they were split
     */
    public Node<E> split()
    {

        if (this.next == null) {
            return null;
        }

        else {
            this.next.previous = null;
            Node<E> temp = this.next;
            this.next = null;
            return temp;
        }
    }
}
