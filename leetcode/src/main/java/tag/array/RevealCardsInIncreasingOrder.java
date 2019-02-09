package tag.array;

import java.util.Arrays;
import java.util.LinkedList;

public class RevealCardsInIncreasingOrder {
    
    public int[] deckRevealedIncreasing(int[] deck) {
        int len = deck.length;
        LinkedList<Integer> index = new LinkedList<>();
        for (int i =0 ;i < deck.length; i++) {
            index.add(i);
        }
        int[] result = new int[len];
        Arrays.sort(deck);
        for (Integer num : deck) {
            int i = index.pollFirst();
            result[i] = num;
            if (!index.isEmpty()) {
                index.add(index.pollFirst());
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {17,13,11,2,3,5,7};
        RevealCardsInIncreasingOrder instance = new RevealCardsInIncreasingOrder();
        System.out.println(Arrays.toString(instance.deckRevealedIncreasing(nums)));
    }
}
