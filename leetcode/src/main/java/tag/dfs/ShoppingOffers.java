package tag.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingOffers {
    
    int min = Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int sum = 0;
        if (!isOffer(needs, special)){
            for (int i = 0; i < needs.size(); i++) {
                sum += needs.get(i) * price.get(i);
            }
            return sum;
        }

        for (List<Integer> offer : special) {
            sum = 0;
            if(isQualify(needs, offer)) {
                sum = sum + offer.get(offer.size() - 1);
                List<Integer> newNeeds = new ArrayList<>();
                for (int i = 0; i < needs.size(); i++) {
                    newNeeds.add(needs.get(i) - offer.get(i));
                }
                sum += shoppingOffers(price, special, newNeeds);
                min = Math.min(min, sum);
            }
        }
        
        return min;
    }

    public boolean isOffer(List<Integer> needs, List<List<Integer>> special) {
        for (List<Integer> offer : special) {
            boolean q = true;
            for (int i = 0; i < needs.size(); i++) {
                if (needs.get(i) < offer.get(i)) {
                    q = false;
                    break;
                }
            }
            if (q) {
                return true;
            }
        }

        return false;
    }
    
    public boolean isQualify(List<Integer> needs, List<Integer> offer) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < offer.get(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        ShoppingOffers shoppingOffers = new ShoppingOffers();
        Integer[] prices = {2,3,4};
        Integer[][] specials = {{1,1,0,4},{2,2,1,9}};
        Integer[] need = {1,2,1};
        List<Integer> price = Arrays.asList(prices);
        List<Integer> needs = Arrays.asList(need);
        List<List<Integer>> special = new ArrayList<>();
        for (Integer[] s : specials) {
            special.add(Arrays.asList(s));
        }
        
        System.out.println(shoppingOffers.shoppingOffers(price, special, needs));
    }
}
