
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class Custom implements Comparator<Custom>, Comparable<Custom>{
    public int dist=0, index;
    public Custom(int dist, int index){
        this.dist = dist;
        this.index = index;
    }
    public int compare(Custom a, Custom b){
        return b.dist - a.dist;
    }
    public int compareTo(Custom b){
        return b.dist - this.dist;
    }

    @Override
    public String toString() {
        return "Custom{" +
                "dist=" + dist +
                ", index=" + index +
                '}';
    }
    
    public String get() {
    	return this.toString();
    }
}

public class Main {

    public static void main(String[] args) {
    	Heap<Custom> heap = new Heap<Custom>();

        int[] values = new int[]{8, 5, 2, 9, 5, 6, 3, 5};
        for (int i =0; i < values.length; i++) {
            heap.add(new Custom(values[i],  i ));
        }
       
        while(!heap.isEmpty()) {
            Custom top = heap.top();
           System.out.println(top.get());
        } 
         // (9, 3), .... (5, 1), .... (5, 4) ... stable

          // (9, 3), .... (5, 4), .... (5, 1) ... no-stable 
    }
}