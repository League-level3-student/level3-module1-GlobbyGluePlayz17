package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<Character> brackets = new Stack<Character>();
		String result = "";
		
		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == '{') {
				char c = b.charAt(i);
				brackets.push(c);
				
			} else if (brackets.empty()) {
				result = "false";
				
			} //else if (!brackets.contains('{') && !brackets.empty()) {
				//result = "false";
				
			 else {
				brackets.pop();
				result = "true";
			}
		}
		
		if (result == "true") {
			return true;
			
		} else {
			return false;
			
		}
		
	}

}