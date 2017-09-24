
public class Minheap {
	private int heapSize;
	private int numElements;
	private Node heapList[];

	/*public static void main(String[] args) {
		
	}*/
	
	public Minheap newHeap() {
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
		
		//if we are inserting the root node no need to continue
		if (parentLoc == -1) {
			return;
		}
		
		Node parent;
		
		while (parentLoc > 0) {
			parent = this.heapList[parentLoc];
			
			if (n.key < parent.key) {
				//n key is smaller
				readyList[parentLoc] = n;
				readyList[nLoc] = parent;
				nLoc = parentLoc;
			} else {
				//parent has smaller key
				break;
			}
			
			parentLoc = getParent(nLoc);
		}
	}
	
	//Resizes the minheap array
	public void reSizeArray() {
		this.heapSize = this.heapSize * 2;
		Node temp[] = new Node[this.heapSize];
		
		for(int i = 0; i < this.numElements; i++) {
			temp[i] = this.heapList[i];
		}
		
		
	}
	
	//Returns the Node at index 1 and removes it from the heap
	public Node heapGetHead() {
		Node rightChild;
		Node leftChild;
		int rightChildLoc = 0, leftChildLoc = 0, nLoc = 0;
		
		//Verifies there are elements in the minheap
		if (this.numElements == 0) {
			return -1;
		}
		
		Node root = this.heapList[1];
		Node n = this.heapList[this.numElements];
		
		this.numElements--;
		
		this.heapList[1] = n;
		
		nLoc = 1;
		rightChildLoc = getRightChild(nLoc);
		leftChildLoc = getLeftChild(nLoc);
		
		while(rightChildLoc > 0 || leftChildLoc > 0) {
			if (rightChildLoc > 0) {
				rightChild = this.heapList[rightChildLoc];
			} else {
				rightChild = this.heapList[0];
				rightChild.key = MAXKEY;
			}
			
			if(leftChildLoc > 0) {
				leftChild = this.heapList[leftChildLoc];
			} else {
				leftChild = this.heapList[0];
				leftChild.key = MAXKEY;
			}
			
			//children are not less than n
			if (n.key < leftChild.key && n.key < rightChild.key) {
				break;
				
			} else if (n.key > leftChild.key && n.key > rightChild.key) {

				//both children are less than n so check which is smaller
				if (leftChild.key > rightChild.key) {
					//swap in the right child
					this.heapList[nLoc] = rightChild;
					this.heapList[rightChildLoc] = n;
					nLoc = rightChildLoc;
				} else {
					//swap in the left child
					this.heapList[nLoc] = leftChild;
					this.heapList[leftChildLoc] = n;
					nLoc = leftChildLoc;
				}
			} else if (n.key > leftChild.key) {
				//swap in the left child
				this.heapList[nLoc] = leftChild;
				this.heapList[leftChildLoc] = n;
				nLoc = leftChildLoc;
				
			} else if (n.key > rightChild.key) {
				//swap in the right child
				this.heapList[nLoc] = rightChild;
				this.heapList[rightChildLoc] = n;
				nLoc = rightChildLoc;
			}
			
			leftChildLoc = getLeftChild(nLoc);
			rightChildLoc = getRightChild(nLoc);
		}
		
		return root;
	}
	
	//Returns the value of the Node at index 1
	public int heapMinKey() {
		if (this.numElements > 0) {
			return this.heapList[1];
		}
		
		return -1;
	}
	
	//Takes the child index in the array
	//Returns the parent index in the array
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
	
	//Takes the parent index in the array
	//Returns the left child index in the array
	public int getLeftChild(int location) {
		if ((2 * location) > this.heapSize) {
			return -1;
		}

		if ((2 * location) > this.numElements) {
			return -1;
		}
		return 2 * location;
	}
	
	//Takes the parent index in the array
	//Returns the right child index in the array
	public int getRightChild(int location) {
		if (((2 * location) + 1) > this.heapSize) {
			return -1;
		}
		
		if ((2 * location + 1) > this.numElements) {
			return -1;
		}
		
		return (2 * location) + 1;
	}
	
	
}
