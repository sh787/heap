package a4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

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
		//test 1: Heap<Integer, Integer> h, basic tests
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
		//test 1: Heap<Integer, Integer> h, basic tests
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
		//test 1: Heap<Integer, Integer> h, basic tests
		Comparator<Integer> c = (int1, int2) -> {return int1 - int2;};
		Heap<Integer,Integer> h = new Heap<Integer,Integer>(c);
		h.add(1, 1);
		System.out.println("First element: " + h.peek());
		System.out.println("Size after peeking: " + h.size());
	}
	
	@Test
	void testAdd() {
		//test 1: Heap<Integer, Integer> h, basic tests
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
		//test 1: Heap<Integer, Integer> h, basic tests
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
		System.out.println("changePriority: Size after changing: " + h.size());
		//test 2: Heap<Character, Integer> h2, basic tests
		Comparator<Character> c2 = (char1, char2) -> {return char1 - char2;};
		Heap<Character,Integer> h2 = new Heap<Character,Integer>(c);
		h2.add('a', 0);
		h2.add('b', 1);
		h2.add('c', 2);
		h2.add('d', 3);
		h2.add('e', 4);
		h2.add('f', 5);
		h2.add('g', 6);
		h2.add('h', 7);
		h2.add('i', 8);
		System.out.println("changePriority: Size h2 after adding: " + h2.size());
		h2.add('j', 8);
		h2.add('k', 8);
		System.out.println("changePriority: Size h2 after adding: " + h2.size());
		System.out.println("First element: " + h2.peek());
		System.out.println("Element removed: " + h2.poll());
		System.out.println("Element removed: " + h2.poll());
		System.out.println("Element removed: " + h2.poll());
	}

}
