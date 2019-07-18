package a4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.HashMap;

public class Heap<E, P> implements PriorityQueue<E,P>{
	
	/** fields: size of the Heap and its comparator */
	private int size;
	private Comparator<P> heapComp;
	private ArrayList<E> heapArray = new ArrayList<E>();
	private HashMap<E, Integer> locMap = new HashMap<E, Integer>();
	
	/** constructor creates an empty heap with the given comparator */
	public Heap(Comparator<P> c) {
		this.size = 0;
		this.heapComp = c;
	}
	
	/** return the comparator used for ordering priorities */
	@Override
	public Comparator<? super P> comparator() {
		// TODO Auto-generated method stub
		//return null;
		return this.heapComp;
	}
	
	/** Return the number of elements in this.  Runs in O(1) time. */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		//return 0;
		return this.size;
	}
	
	/**
	 * Remove and return the largest element of this, according to comparator()
	 * Runs in O(log n) time.
	 * 
	 * @throws NoSuchElementException if this is empty 
	 */
	@Override
	public E poll() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Return the largest element of this, according to comparator().
	 * Runs in O(1) time.
	 * 
	 * @throws NoSuchElementException if this is empty.
	 */
	@Override
	public E peek() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Add the element e with priority p to this.  Runs in O(log n + a) time,
	 * where a is the time it takes to append an element to an ArrayList of size
	 * n.
	 * 
	 * @throws IllegalArgumentException if this already contains an element that
	 *                                  is equal to e (according to .equals())
	 */
	@Override
	public void add(E e, P p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Change the priority associated with e to p.
	 *
	 * @throws NoSuchElementException if this does not contain e.
	 */
	@Override
	public void changePriority(E e, P p) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}

}
