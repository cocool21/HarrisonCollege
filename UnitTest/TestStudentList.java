



//Please run tests in order of add,drop,grade,studentlist and transcript.
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import customTools.ProcessStudentReg;
import model.HcStudent;

public class TestStudentList {
	@Test
	   public void test_add() {
		
		System.out.println("Test if list is retrieved") ;
		List<HcStudent> list=ProcessStudentReg.getStudentList(1);
		System.out.println("process");
	      assertEquals(list.size(),1) ;
	   }
}
