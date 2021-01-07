
public class VariableTest {

	private static int sNum = 0;
	private int iNum = 0;
	
	public VariableTest () {
		iNum = 5;
	}
	
	public void update (int num) {
		iNum = num;
	}
	
	public void main(String[] args) {
		VariableTest test1 = new VariableTest();
		System.out.println(test1.iNum);
		//System.out.println(iNum);
		System.out.println(sNum);
	}

}