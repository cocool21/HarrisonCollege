import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import model.HcStudentreg;
import customTools.ProcessStudentReg;

//Please run tests in order of add,drop,grade,studentlist and transcript.
public class TestAdd {
	@Test
	   public void test_add() {
		
		System.out.println("Test if list is added") ;
		ProcessStudentReg.addClass(3, 1);
		System.out.println("add");
	      assertEquals(ProcessStudentReg.getRecord(3, 1).getRegid(),1) ;
	   }
}
