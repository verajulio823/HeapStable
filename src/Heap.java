import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Heap<T extends Comparable<T>> {
	
	List<Pair<T,Integer>> heap;
	
	Comparator<T> comparator;
	int size;
		
	public Heap() {
		size=0;
		heap = new ArrayList<>();
		comparator = Comparator.naturalOrder();
		
	}
	
	public void print_heap() {
		for(int i=0; i<heap.size(); i++) {
			
			System.out.println("| i: "+i+ " val: "+heap.get(i).getVal());
		}
	}
	
	public void add(T val) {
		heap.add(size, new Pair<T,Integer>(val,size));
		
		int current = size;
			
			while(heap.get(parent(current)) !=null && heap.get(current).getVal().compareTo(heap.get(parent(current)).getVal())<0) {
				
				swap(current, parent(current));
				current = parent(current);
				
			}
			size++;
	
	}
	
	public T pop() {
		return null;
	}
	public T top() {
		T element_pop = heap.get(0).getVal();
		
		size--;
		heap.set(0,heap.get(size));
        heapify(0);
        return element_pop;
		

	}
	
	public void heapify(int p) {
		
		if (isLeaf(p))
            return;
		
		if (this.comparator.compare( heap.get(p).getVal(), heap.get(childLeft(p)).getVal() ) >=0
	            || this.comparator.compare( heap.get(p).getVal(), heap.get(childRight(p)).getVal() ) >=0 ){
	  
			if(this.comparator.compare( heap.get(childLeft(p)).getVal(), heap.get(childRight(p)).getVal()) ==0){
                
				if(  heap.get(childRight(p)).getIndex() - heap.get(childLeft(p)).getIndex()  >0) {
					swap(p, childLeft(p));
	                heapify(childLeft(p));
				}else {
					swap(p, childRight(p));
	                heapify(childRight(p));	
				}
				
            }else {
            	
                if (this.comparator.compare( heap.get(childLeft(p)).getVal(), heap.get(childRight(p)).getVal()) <0 ){
	                swap(p, childLeft(p));
	                heapify(childLeft(p));
	            }
	            else {
	                swap(p, childRight(p));
	                heapify(childRight(p));
	            }
			
            }
						
				
	     }
        
	}
	
	public boolean isEmpty() {
		if(size==0)
			return true;
		else 
			return false;
	}
	
	int parent(int position) {
		return (position-1)/2;
	}
	
	int childLeft(int position) {
		return (position*2)+1;
	}
	
	int childRight(int position) {
		return (position*2)+2;
	}
	
	void swap(int fpos, int spos)
    {
		Collections.swap(heap, fpos, spos);
    }
	
	boolean isLeaf(int p){
        if (p >= (size / 2) && p <= size)
            return true;
       
        return false;
	}
	
	private class Pair<T, U>{
		 T val;
		 U index;
		 
		 
		 
		public Pair(T val, U index) {
			super();
			this.val = val;
			this.index = index;
		}
		public T getVal() {
			return val;
		}
		public U getIndex() {
			return index;
		}
		 
		 
	}
	
 
	  
}	
