
public class Node {
	private int value;
	private int key;
	
	//Constructor
	public Node(int value, int key) {
		this.value = value;
		this.key = key;
	}
	
	//Get Methods
	public int getValue() {
		return this.value;
	}
	
	public int getKey() {
		return key;
	}
	
	//Set Methods
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
}
