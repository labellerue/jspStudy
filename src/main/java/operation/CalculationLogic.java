package operation;

public class CalculationLogic {
	
	public static void main(String[] args) {
		CalculationLogic logic = new CalculationLogic();
		int start = 1;
		int end = 10;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		if(sumResult == 55)
			System.out.println("정답이예용~");
		else
			System.out.println("오답입니다ㅠㅠ");
		
		
		
		sumResult = logic.sumBetweenTwoNumbers(start+2, end+2);
		
		if(sumResult == 75)
			System.out.println("정답이예용~");
		else
			System.out.println("오답입니다ㅠㅠ");
			
		
	}

	public int sumBetweenTwoNumbers(int start, int end) {
		int min = Math.min(start, end);
		int max = Math.max(start, end);
		int sum = 0;
		while(min <= max){
			sum += min;
			min++;
		}
		return sum;
	}

}
