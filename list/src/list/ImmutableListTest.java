package list;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class ImmutableListTest {
	
	private static final Random RANDOM = new Random();

	@Test
	public void listDecompositionMustBeDualOfListComposition() {
		for (int i = 0; i < 100; i++) {
			Integer head = RANDOM.nextInt(100);
			ImmutableList<Integer> 
				tail = arbitraryList(), 
				composed = tail.prepend(head);
			System.out.println(head + "  " + composed.head);
			System.out.println(tail + "  " + composed.tail);
			assertSame(head, composed.head);
			assertSame(tail, composed.tail);
		
			
		}
	}
	
	
	private static ImmutableList<Integer> arbitraryList(){
		
		return RANDOM.nextBoolean() ? 
				arbitraryList().prepend(RANDOM.nextInt()) : 
					new ImmutableList<Integer>();
	}

}
