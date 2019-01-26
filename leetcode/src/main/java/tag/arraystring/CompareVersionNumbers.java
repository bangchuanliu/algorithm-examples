package tag.arraystring;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            return 0;
        }
        
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        
        int index1 = 0;
        int index2 = 0;
        
        while (index1 < versions1.length && index2 < versions2.length) {
            if (Integer.parseInt(versions1[index1]) > Integer.parseInt(versions2[index2])) {
                return 1;
            } else if (Integer.parseInt(versions1[index1]) < Integer.parseInt(versions2[index2])) {
                return -1;
            }
            index1++;
            index2++;
        }
        
        while (index1 < versions1.length) {
            if (Integer.parseInt(versions1[index1]) != 0) {
                return 1;
            }
            index1++;
        }
        
        while (index2 < versions2.length) {
            if (Integer.parseInt(versions2[index2]) != 0) {
                return -1;
            }
            index2++;
        }
        
        return 0;
    }
}
