package tag.array;

public class ReadNCharactersGivenRead4 {

    public int read(char[] buf, int n) {
        int i = 0;
        char[] buffer = new char[4];
        while (i < n) {
            int count = read4(buffer);

            if (count == 0) {
                break;
            }
            int k = 0;
            while (i < n && k < count) {
                buf[i++] = buffer[k++];
            }
        }

        return i;
    }

    public int read4(char[] buf) {
        return 0;
    }
}
