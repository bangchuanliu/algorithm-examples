package company.google;

import java.util.Arrays;

public class FontSize {

    public int fitScreen(int width, int height, char[] chars, int[] fontSizes) {
        Arrays.sort(fontSizes);
        
        int l = 0;
        int r = fontSizes.length - 1;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            
            if (isFit(width, height, chars, fontSizes[mid])) {
                l = mid;
            }else{
                r = mid - 1;       
            }
        }
        
        return fontSizes[l];
    }
    
    public boolean isFit(int width, int height, char[] chars, int font) {
        int fontWidth = 0;
        int fontHeight = 0;
        
        for (char c : chars) {
            fontWidth += getWidth(c, font);
        }
        
        fontHeight = getHeight(font) * chars.length;
        
        return width * height > fontHeight * fontWidth;
    }
    
    
    public int getHeight(int font) {
        return 0;
    }
    
    public int getWidth(char c, int font) {
        return 0;
    }
}
