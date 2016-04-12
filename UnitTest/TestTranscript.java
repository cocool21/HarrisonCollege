import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import customTools.ProcessStudentReg;
import model.HcStudentreg;


public class TestTranscript {
	@Test
	   public void test_add() {
		
		System.out.println("Test if list is retrieved") ;
		List<HcStudentreg> list=ProcessStudentReg.getTranscript(3);
		System.out.println("process");
	      assertEquals(list.size(),1) ;
	   }
}
