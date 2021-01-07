
public class ReversibleArray<T> {
	private T[] array;
	private int count;
	
	public ReversibleArray(T[] array) {
		this.array = array;
		count = array.length;
	}
	
	public String toString() {
		String format = ", ";
		String result = "";
		for (int i=0; i<(count-1); i++) {
			result = result + array[i]+ format;
		}
		result = result + array[count-1];
		return result;
	}
	public void reverse() {
		int remainder = count % 2;

		if (remainder == 1) {
			int effectiveCount = (count-1)/2;
			for (int i = 0; i < effectiveCount; i++) {
				T temp = array[i];
				array[i] = array[count-1-i];
				array[count-1-i] = temp;
			}
		} else {
			int effectiveCount = count/2;
			for (int i =0; i < effectiveCount; i++) {
				T temp = array[i];
				array[i] = array[count-1-i];
				array[count-1-i] = temp;
			}
		}
	}

}
