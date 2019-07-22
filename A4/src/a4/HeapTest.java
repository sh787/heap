package a4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import a4.Heap.Node;

class HeapTest {

	@Test
	void testConstructor() {
		Comparator<Integer> c = (int1, int2) -> {return int1 - int2;};
		Heap<Integer,Integer> h = new Heap<Integer,Integer>(c);
		//Node<Integer, Integer> n = new Heap.Node<Integer, Integer>(1, 1);
		System.out.println("Size when constructor is initialized: " + h.size());
		h.add(1, 1);
		System.out.println("Size when one element is added: " + h.size());
		
	}
	
	@Test
	void testSize() {
		Comparator<Integer> c = (int1, int2) -> {return int1 - int2;};
		Heap<Integer,Integer> h = new Heap<Integer,Integer>(c);
		h.add(1, 2);
		System.out.println("TestSize after adding: " + h.size());
		h.add(2, 1);
		System.out.println("TestSize after adding: " + h.size());
		h.add(5, 3);
		h.add(6, 7);
		h.add(93, 23);
		System.out.println("TestSize after adding: " + h.size());
	}
	
	@Test
	void testPoll() {
		Comparator<Integer> c = (int1, int2) -> {return int1 - int2;};
		Heap<Integer,Integer> h = new Heap<Integer,Integer>(c);
		h.add(1, 1);
		System.out.println("testPoll: Element removed: " + h.poll());
		System.out.println("Size after removing: " + h.size());
		h.add(5, 3);
		h.add(6, 7);
		h.add(93, 23);
		System.out.println("Size after adding: " + h.size());
		System.out.println("Element removed: " + h.poll());
		System.out.println("Size after removing: " + h.size());
		System.out.println("Element removed: " + h.poll());
		System.out.println("Size after removing: " + h.size());
		System.out.println("Element removed: " + h.poll());
		System.out.println("Size after removing: " + h.size());
	}
	
	@Test
	void testPeek() {
		Comparator<Integer> c = (int1, int2) -> {return int1 - int2;};
		Heap<Integer,Integer> h = new Heap<Integer,Integer>(c);
		h.add(1, 1);
		System.out.println("First element: " + h.peek());
		System.out.println("Size after peeking: " + h.size());
	}
	
	@Test
	void testAdd() {
		Comparator<Integer> c = (int1, int2) -> {return int1 - int2;};
		Heap<Integer,Integer> h = new Heap<Integer,Integer>(c);
		h.add(1, 2);
		//can they have same priority?
		h.add(5, 3);
		h.add(7, 1);
		System.out.println("Size after adding: " + h.size());
		System.out.println("First element: " + h.peek());
	}
	
	@Test
	void testChangePriority() {
		Comparator<Integer> c = (int1, int2) -> {return int1 - int2;};
		Heap<Integer,Integer> h = new Heap<Integer,Integer>(c);
		h.add(1, 2);
		h.add(5, 3);
		h.add(90, 4);
		System.out.println("changePriority: Size after adding: " + h.size());
		System.out.println("First element: " + h.peek());
		h.changePriority(5, 1);
		System.out.println("changePriority: Size after changing: " + h.size());
		System.out.println("First element: " + h.peek());
		System.out.println("Element removed: " + h.poll());
		System.out.println("Element removed: " + h.poll());
		System.out.println("Element removed: " + h.poll());
	}

}
