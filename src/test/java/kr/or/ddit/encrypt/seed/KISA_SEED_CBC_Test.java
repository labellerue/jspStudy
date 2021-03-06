package kr.or.ddit.encrypt.seed;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KISA_SEED_CBC_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	/**
	* Method : EncryptTest
	* 작성자 : sohyoung
	* 변경이력 :
	* Method 설명 : seed encrypt 암호화
	*/
	@Test
	public void EncryptTest() {
		/***Given***/
		String pass = "brownpass";

		/***When***/
		String encrypt = KISA_SEED_CBC.Encrypt(pass);
		String decrypt = KISA_SEED_CBC.Decrypt(encrypt); //복호화
		
		/***Then***/
		assertEquals("5207bbf01d00451c23800ae909470f26", encrypt);
		assertEquals(pass, decrypt);


		
	}

}

























