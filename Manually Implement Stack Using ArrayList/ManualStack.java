import java.util.ArrayList;
import java.util.List;

public class ManualStack {

	private List<Object> stack = new ArrayList<Object>();

	public Boolean isEmpty() {
		if(stack.isEmpty()) {
			return true;
		}
		else
			return false;
	}
	
	public void push(Object value) {
		stack.add(value);
	}

	public Object pop() {
		Object value = null;

		if (stack.isEmpty()) {
			System.out.println("The Stack Is Empty");
		} else {
			int top = stack.size();
			value = stack.get(top - 1);
			stack.remove(top - 1);
		}
		return value;
	}

	public static void main(String[] args) {
		ManualStack manualStack = new ManualStack();
		
		manualStack.push("ABCD");
		manualStack.push(2020);
		manualStack.push(10.590);
		
		while(!manualStack.isEmpty()) {
			System.out.println(""+manualStack.pop());
		}
	}
}
