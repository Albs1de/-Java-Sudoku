import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class DateUnitTest {

	Date testee;
	
	@Before
	public void setUp() throws Exception {
		testee = new Date(20, 12, 2018);
	}

	@Test
	public void testDateDefault() {
		Date testDate = new Date();
		
		assertEquals("Falsches Default-Datum", "01.01.2000", testDate.toString());
	}
    
    
	@Test
	public void testIsBeforeSameYear() {
		Date testDate = new Date(1, 5, 2018);
		
		assertTrue("Fehler in isBefore", testDate.isBefore(testee));
	}
	
	@Test
	public void testIsBeforeDifferentYear() {
		Date testDate = new Date(28, 12, 2017);
		
		assertTrue("Fehler in isBefore", testDate.isBefore(testee));
	}

	@Test
	public void testSetDateInvalidMonth() {
		Date testDate = new Date();

		boolean result = testDate.setDate(1, 13, 2021);
		assertFalse("Fehler in setDate", result);
		assertEquals("Fehler in setDate: Datum verändert", "01.01.2000", testDate.toString());

	}

	@Test
	public void testSetDateNormal() {
		Date testDate = new Date();

		boolean result = testDate.setDate(7, 1, 2021);
		assertTrue("Fehler in setDate", result);
		assertEquals("Fehler in setDate: Datum verändert", "07.01.2021", testDate.toString());

	}
    
   

}
