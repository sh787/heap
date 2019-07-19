package a4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.HashMap;

public class Heap<E, P> implements PriorityQueue<E,P>{
	
	/** A node consists of an element E and its priority P. */
	public class Node {
		private E element;
		private P priority;
		
		public Node(E elt, P prt) {
			this.element = elt;
			this.priority = prt;
		}
		
		public E getElement() {
			return this.element;
		}
		
		public void setElement(E elt) {
			this.element = elt;
		}
		
		public P getPriority() {
			return this.priority;
		}
		
		public void setPriority(P prt) {
			this.priority = prt;
		}
	}
	
	/** Fields: size of the Heap and its comparator. */
	private int size;
	private Comparator<P> heapComp;
	
	/** heapArray stores the heap nodes; locMap maps each node to its location */ 
	private ArrayList<Node> heapArray = new ArrayList<Node>();
	private HashMap<E, Integer> locMap = new HashMap<E, Integer>();
	
	/** constructor creates an empty heap with the given comparator */
	public Heap(Comparator<P> c) {
		this.size = 0;
		this.heapComp = c;
	}
	
	/** return the comparator used for ordering priorities */
	@Override
	public Comparator<? super P> comparator() {
		return this.heapComp;
	}
	
	/** Return the number of elements in this.  Runs in O(1) time. */
	@Override
	public int size() {
		return this.size;
	}
	
	/** Returns the left node of the parent from heapArray */
	public Node getLeft(E parent) {
		int leftIndex = 2*(heapArray.indexOf(parent)) + 1;
		return heapArray.get(leftIndex);
	}
	
	/** Returns the right node of the parent from heapArray */
	public Node getRight(E parent) {
		int rightIndex = 2*(heapArray.indexOf(parent)) + 2;
		return heapArray.get(rightIndex);
	}
	
	/** Returns the parent node of the child from heapArray */
	public Node getParent(E child) {
		if (heapArray.indexOf(child)%2 != 0) {
			int parentLeftIndex = (heapArray.indexOf(child) - 1)/2;
			return heapArray.get(parentLeftIndex);
		} else {
			int parentRightIndex = (heapArray.indexOf(child) - 2)/2;
			return heapArray.get(parentRightIndex);
		}
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
		return this.heapArray.get(0).getElement(); //.get elt
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
