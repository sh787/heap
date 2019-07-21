package a4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Heap<E, P> implements PriorityQueue<E,P>{
	
	/** A node consists of an element E and its priority P. */
	private class Node {
		private E element;
		private P priority;
		
		private Node(E elt, P prt) {
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
	private List<Node> heapArray = new ArrayList<Node>();
	private Map<E, Integer> location;
	
	/** constructor creates an empty heap with the given comparator */
	public Heap(Comparator<P> c) {
		this.size = 0;
		this.heapComp = c;
		this.location = new HashMap<E, Integer>();
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
		int leftIndex = 2*location.get(parent) + 1;
		
		if (leftIndex < this.size) {
			return heapArray.get(leftIndex);
		} else {
			return null;
		}
		
	}
	
	/** Returns the right node of the parent from heapArray */
	public Node getRight(E parent) {
		int rightIndex = 2*location.get(parent) + 2;
		
		if (rightIndex < this.size) {
			return heapArray.get(rightIndex);
		} else {
			return null;
		}
		
	}
	
	/** Returns the parent node of the child from heapArray */
	public Node getParent(E child) {
		if (location.get(child)%2 != 0) {
			int parentLeftIndex = (location.get(child) - 1)/2;
			if (parentLeftIndex >= 0) {
				return heapArray.get(parentLeftIndex);
			} else {
				return null;
			}
		} else {
			int parentRightIndex = (location.get(child) - 2)/2;
			if (parentRightIndex >= 0) {
				return heapArray.get(parentRightIndex);
			} else {
				return null;
			}
		}
	}
	
	/** Helper function that can be used to swap nodes in the heap if two nodes are known */
	private void swapNode(Node n1, Node n2) {
		int indexOf1 = heapArray.indexOf(n1);
		int indexOf2 = heapArray.indexOf(n2);
		
		Node temp = heapArray.get(indexOf1);
		
		heapArray.set(indexOf1, heapArray.get(indexOf2));
		heapArray.set(indexOf2, temp);
		
		//update index in location map
		location.put(n1.getElement(), indexOf2);
		location.put(n2.getElement(), indexOf1);
	}
	
	/** Helper function that can be used to swap nodes in the heap if two nodes' indexes are known */
	private void swapIndex(int indexOf1, int indexOf2) {
		
		Node temp = heapArray.get(indexOf1);
		
		heapArray.set(indexOf1, heapArray.get(indexOf2));
		heapArray.set(indexOf2, temp);
		
		//update index in location map
		
		location.put(heapArray.get(indexOf2).getElement(), indexOf1);
		location.put(temp.getElement(), indexOf2);
	}
	
	/**
	 * Remove and return the largest element of this, according to comparator()
	 * Runs in O(log n) time.
	 * 
	 * @throws NoSuchElementException if this is empty 
	 */
	@Override
	public E poll() throws NoSuchElementException {
		
		if (this.size == 0) {
			throw new NoSuchElementException();
		}
		
		// Save largest element.
		Node first = heapArray.get(0);
		
		// Set first element (root) in heap to temporarily be the last element (last leaf).
		swapIndex(0, heapArray.size()-1);
		heapArray.remove(heapArray.size()-1);
		
		// Swap root with its children if they are ranked before in priority.
		// Choose the highest ranking in priority (lower Priority value) to swap.
		swapLargerChild(first);
		
		// Decrement size, update location Map
		this.size --;
		
		// Return element of root.
		return first.getElement();
	}
	
	/** Helper function which swaps Node n with the lower priority value of its two children */
	public void swapLargerChild(Node n) {
		// Remember to update location map
		P nPriority = n.getPriority();
		P leftPriority = getLeft(n.getElement()).getPriority();
		P rightPriority = getRight(n.getElement()).getPriority();
		
		if (heapComp.compare(leftPriority, rightPriority) > 0 ) {
			if (heapComp.compare(nPriority, rightPriority) > 0) {
				swapNode(n, getRight(n.getElement()));
				swapLargerChild(n);
			}
		} 	else if (heapComp.compare(leftPriority, rightPriority) < 0 ) {
			if (heapComp.compare(n.getPriority(), leftPriority) > 0) {
				swapNode(n, getRight(n.getElement()));
				swapLargerChild(n);
			}
		} 
	}
	
	/**
	 * Return the largest element of this, according to comparator().
	 * Runs in O(1) time.
	 * 
	 * @throws NoSuchElementException if this is empty.
	 */
	@Override
	public E peek() throws NoSuchElementException {
		if (this.size == 0) {
			throw new NoSuchElementException();
		}
		
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
		if (location.containsKey(e)) {
			throw new IllegalArgumentException();
		}
		
		// generate new node with e, p
		Node addition = new Node(e, p);
		
		// append new node to the end of heapArray
		heapArray.add(addition);
		
		// increment size
		this.size ++;
		
		// swap with parent until invariant is restored.
		swapWithParent(addition);
		
	}
	
	/** Helper function that swaps Node n with its parent if n is higher ranking (lower value) in priority. */
	public void swapWithParent(Node n) {
		// Remember to update location map
		if (heapComp.compare(n.getPriority(), getParent(n.getElement()).getPriority()) >= 0 ) {
			swapNode(n, getParent(n.getElement()));	
			swapWithParent(n);
		} 
	}

	/**
	 * Change the priority associated with e to p.
	 *
	 * @throws NoSuchElementException if this does not contain e.
	 */
	@Override
	public void changePriority(E e, P p) throws NoSuchElementException {
		// get node with E e from heapArray using location Map
		
		// set priority
		
		// swap and update location Map if necessary
		
	}

}
