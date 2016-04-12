import static org.junit.Assert.assertEquals;

import org.junit.Test;

import customTools.ProcessStudentReg;

public class TestGrade {
	@Test
	   public void test_add() {
		
		System.out.println("Test grade should not be changed") ;
		ProcessStudentReg.updateGrade(3, 1, "A");
		System.out.println("update");
	      assertEquals(ProcessStudentReg.getRecord(3, 1).getGrade(),"W") ;
	   }
}
