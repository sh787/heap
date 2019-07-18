package a4;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E, P> implements PriorityQueue<E,P>{
	
	/** fields: size of the Heap and its comparator */
	private int size;
	private Comparator<P> heapComp;
	
	/** constructor creates an empty heap with the given comparator */
	public Heap(Comparator<P> c) {
		this.size = 0;
		this.heapComp = c;
	}

	@Override
	public Comparator<? super P> comparator() {
		// TODO Auto-generated method stub
		//return null;
		return this.heapComp;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		//return 0;
		return this.size;
	}

	@Override
	public E poll() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(E e, P p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePriority(E e, P p) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}

}
