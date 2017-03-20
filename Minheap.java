
public class Minheap {
	private int heapSize;
	private int numElements;
	private Node heapList[];

	/*public static void main(String[] args) {
		
	}*/
	
	public void newHeap() {
		this.heapSize = 20;
		this.numElements = 0;
		this.heapList = new Node[20];
	}
	
	public void heapinsert(int value, int key) {
		//Verifies that there is room inside the heap
		if (this.numElements + 1 == this.heapSize) {
			reSizeArray();
		}
		
		Node n = new Node(value, key);
		this.numElements++;
		
		this.heapList[this.numElements] = n;
		int nLoc = this.numElements;
		
		int parentLoc = getParent(nLoc);
	}
	
	public void reSizeArray() {
		this.heapSize = this.heapSize * 2;
		Node temp[] = new Node[this.heapSize];
		
		for(int i = 0; i < this.numElements; i++) {
			temp[i] = this.heapList[i];
		}
		
		
	}
	
	public int getParent(int location) {
		if(location == 1 || location == 0) {
			return -1;
		}
		
		if (location % 2 != 0) {
			return (location - 1) / 2;
		} else {
			return location / 2;
		}	
	}
	
	
}

