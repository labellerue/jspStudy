package kr.or.ddit.encrypt.sha;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KISA_SHA256_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void EncryptTest() {
		/***Given***/
		String pass = "brownpass";
		String pass1 = "brownpast";

		/***When***/
		String encrypt = KISA_SHA256.encrypt(pass);
		String encrypt1 = KISA_SHA256.encrypt(pass1);
		System.out.println("encrypt  : " + encrypt);
		System.out.println("encrypt1 : " + encrypt1);
		
		/***Then***/
		assertEquals("f01471c38113db263f9a532d8b6c054af31bf653aeea92d1c284cdd022b9", encrypt);
		
	}

}


























