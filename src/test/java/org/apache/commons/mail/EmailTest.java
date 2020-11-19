package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Date;

import javax.mail.internet.MimeMultipart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
	
	private static final String[] TEST_EMAILS = { "ab@bc.org", "abawdasdwas@dfaxcasdweda.com", "asdwasd@asdawid.net" };	// Sample set of emails
	private static final String[] EMPTY_LIST = {};	// Empty set of emails
	
	private EmailConcrete email;	// Email object to test
	
	// Setup the email object before running any test
	@Before
	public void setupEmailTest() throws Exception {
		email = new EmailConcrete();
	}
	
	// Test the addBcc method
	@Test
	public void testAddBcc() throws Exception {
		email.addBcc(TEST_EMAILS);	// Add the three email dataset
		
		assertEquals(3, email.getBccAddresses().size());	// Check if the count == 3
	}
	
	// Test the exception caught on an empty list
	@Test(expected = EmailException.class)
	public void testAddBccException() throws Exception {
		email.addBcc(EMPTY_LIST);	// Add no emails
		
		fail();	// Fail the test
	}
	
	// Not really necessary to tear down anything
	@After
	public void tearDownEmailTest() throws Exception {
		
	}
}
