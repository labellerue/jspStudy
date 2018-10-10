package kr.or.ddit.sum;

import static org.junit.Assert.*;
import operation.CalculationLogic;

import org.junit.Test;

public class CalculationLogicTest {

	//1~10까지의 합 구하기
	@Test //이 @test는 필수 없으면 테스트 안돼요!
	public void sumBetweenTwoNumbers() {
		CalculationLogic logic = new CalculationLogic();
		int start = 10;
		int end = 1;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		//맞는지 확인하는 메서드(기대값, 실제값)
		assertEquals(55, sumResult); 
		
	}
	
	@Test
	public void sumBetweenTwoNumbers2() {
		CalculationLogic logic = new CalculationLogic();
		int start = 3;
		int end = 12;
		
		int	sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		assertEquals(75, sumResult);
	}
	

}

























