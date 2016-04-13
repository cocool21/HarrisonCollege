import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;

import model.HcStudent;
import model.HcStudentreg;


public class TestRoster {

	@Test
	public void testGetRoster() {
		
		List<HcStudentreg> roster = null;
		
		roster = getRoster.getStudentRoster(1);
			
				System.out.println("Test if list is retrieved") ;
			
				System.out.println("run");
			
			      assertEquals(roster.size(),1) ;
		 }
}	


