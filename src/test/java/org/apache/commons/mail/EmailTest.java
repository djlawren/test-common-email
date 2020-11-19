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
	
	// Test the add list of emails to CC
	@Test
	public void testAddCc() throws Exception {
		email.addCc(TEST_EMAILS);	// Add list of emails to CC
		
		assertEquals(3, email.getCcAddresses().size());	// Check if the count == 3
	}
	
	// Test the exception on empty list
	@Test(expected = EmailException.class)
	public void testAddCcException() throws Exception {
		email.addCc(EMPTY_LIST);	// Give it no emails
		
		fail();	// Fail the test
	}

	// Test the correct usage for add header
	@Test
	public void testAddHeader() throws Exception {
		email.addHeader("Key", "Value");	// Give temp values 
		
		assertEquals(1, email.getHeaders().size());	// Check if there are one headers
	}
	
	// Test the exception on no key given
	@Test(expected = IllegalArgumentException.class)
	public void testAddHeaderEmptyKey() throws Exception {
		email.addHeader("", "Value");	// Give value but no key
		
		fail();	// Fail the test
	}
	
	// Test the exception on no value given
	@Test(expected = IllegalArgumentException.class)
	public void testAddHeaderEmptyValue() throws Exception {
		email.addHeader("Key", "");	// Give key but no value
		
		fail();	// Fail the test
	}

	// Test the addReplyTo method
	@Test
	public void testAddReplyTo() throws Exception {
		email.addReplyTo("abc@acb.org", "Hello world", "");	// Add one reply to
		
		assertEquals(1, email.getReplyList().size());	// Check if there is one in the list
	}

	// Not really necessary to tear down anything
	@After
	public void tearDownEmailTest() throws Exception {
		
	}
}
