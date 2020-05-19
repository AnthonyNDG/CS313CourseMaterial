import java.util.ArrayList;
import java.util.List;

public class PQ {
    int data[];
    int size;
    int capacity;

    PQ(int capacity){
        this.capacity = capacity;
        size = 0;
        data = new int[capacity];
    }

    PQ(){
        capacity = 1000;
        size = 0;
        data = new int[capacity];
    }

    PQ(List<Integer> data) throws IllegalAccessException{
        capacity = data.size() > 1000 ? data.size() : 1000;
        size = data.size();
        heapify(data);
    }

    public void insert(int dahta){
        //Insert the new data into the PQ, ensure the heap maintains heap order/shape
        //fill in
    	if(size == capacity ) {
    		System.out.println("PQ is full");
    		return;
    	}
    	data[size++] = dahta;
    	bubbleUp(size-1);
    	size++;
    }

    public void remove(){
        //Removes the root or the node with the highest priority
    	//fill in
        if(size<=0) {
        	System.out.println(" The list is full ");
        	return;
        }
        else {
        	size--;
        	data[0]=data[size];
        	bubbleDown(0);
        }
    }

    public int poll(){
        
    	if(size>0) return data[0];
    	//Returns the node with the highest priority. This method should NOT remove that node
        //fill in
    	return -1;
    }
    
    private void bubbleUp(int n) {
        if (n <= 0)
           return; // at root
        int dn = data[n];
        int dp = data[(n - 1) / 2]; // parent data
        if (dn>=dp)
           return; // no problems
        swapData(n, (n - 1) / 2);
        bubbleUp((n - 1) / 2);
     }

    private void bubbleDown(int n) {
        if (2 * n + 1 >= size)
           return; // at leaf
        int dn = data[n];
        int dl = data[2 * n + 1]; // left child
        int dr = dl;
        if (2 * n + 2 < size)
           dr = data[2 * n + 2]; // right child
        if (dn<dl && dn<dr)
           return; // no problems
        if (dr<dl ) {
           swapData(n, 2 * n + 2);
           bubbleDown(2 * n + 2);
        } else {
           swapData(n, 2 * n + 1);
           bubbleDown(2 * n + 1);
        }
     }
    
    private void swapData(int a, int b) {
		// TODO Auto-generated method stub
    	int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
	}

	private void heapify(List<Integer> list) throws IllegalAccessException{
        //implement the heapify method that will build a PQ given a list of data
		
		data=new int[capacity];
		size=0;
		for(int i=0;i<list.get(i);i++) {
			insert(list.get(i));
		}
		
	}
    

    public List<Integer> toSortedList(){
        //this method will return a list of all the integers in the priority queue in sorted order (Max Heap)
        //this method will remove all the data from the pq
    	List<Integer> answer = new ArrayList<Integer>();
    	while(size>=1) {
    		answer.add(poll());
    		remove();
    	}
    	return answer;
    }

}
