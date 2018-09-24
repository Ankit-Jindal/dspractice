import com.ankit.practice.tree.MaxHeap;

public class MaxHeapTest {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();

        heap.add(2);
        heap.add(20);
        heap.add(22);
        heap.add(11);

        System.out.println("Root : " + heap.peek());

        heap.add(12);
        heap.add(9);
        System.out.println("Root : " + heap.peek());
        heap.add(7);
        heap.add(32);
        heap.add(22);
        heap.add(28);

        heap.add(42);
        heap.add(52);
        heap.add(43);
        heap.add(29);

        System.out.println("Root : " + heap.peek());
        System.out.println("Root was : " + heap.poll());
        System.out.println("Root is : " + heap.peek());
        heap.add(3);


        int[] array = {2,12,1,112,11, 25,13, 122, 231, 14, 69, 96};

        MaxHeap heap1 = new MaxHeap();
        for ( int elem: array ) {
            heap1.add(elem);
        }

        int n = 16;

        int kthLarg = -1;
        for(int i = 1 ; i <= n ; i++) {
            kthLarg = heap1.poll();
            System.out.print( kthLarg + ", ");
        }
        System.out.println(n + "th largest elem is " + kthLarg);
    }
}
