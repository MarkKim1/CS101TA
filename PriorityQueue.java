import java.util.ArrayList;

/**
 * Custom min-heap priority queue for HuffmanNode, with lexicographical
 * tie-breaking.
 */
public class PriorityQueue {
    public ArrayList<HuffmanNode> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(HuffmanNode node) {
        // TODO: Implement insertion into min-heap with tie-breaking.
        heap.add(node);

        int index = heap.size() - 1;
        while (index > 0 && heap.get((index - 1) / 2).compare(heap.get(index))) {
            HuffmanNode temp = heap.get(index);
            heap.set(index, heap.get((index - 1) / 2));
            heap.set((index - 1) / 2, temp);
            index = (index - 1) / 2;
        }
    }

    public HuffmanNode extractMin() {
        // TODO: Implement extraction of minimum node with tie-breaking.
        if (heap.isEmpty())
            return null;
        HuffmanNode min = heap.get(0);
        int last = heap.size() - 1;
        heap.set(0, heap.get(last));
        heap.remove(last);

        // Shift down
        int i = 0;
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < heap.size() && heap.get(smallest).compare(heap.get(left)))
                smallest = left;
            if (right < heap.size() && heap.get(smallest).compare(heap.get(right)))
                smallest = right;

            if (smallest == i)
                break;

            HuffmanNode temp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, temp);
            i = smallest;
        }
        return min;
    }

    public boolean isEmpty() {
        // TODO: Implement check if queue is empty.
        return heap.isEmpty();
    }

    public int size() {
        // TODO: Implement size functionality.
        return heap.size();
    }

    // You may add private helper methods for heapify and comparison if needed
}
