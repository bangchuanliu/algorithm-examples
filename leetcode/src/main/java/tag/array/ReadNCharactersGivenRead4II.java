package tag.array;

public class ReadNCharactersGivenRead4II {

    char[] buffer = new char[4];
    int buffPtr = 0;
    int bufferCnt = 0;

    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            if (buffPtr == 0) {
                bufferCnt = read4(buffer);
            }

            if (bufferCnt == 0) break;

            while (i < n && buffPtr < bufferCnt) {
                buf[i++] = buffer[buffPtr++];
            }

            if (buffPtr >= bufferCnt) {
                buffPtr = 0;
            }
        }

        return i;
    }

    public int read4(char[] buf) {
        return 0;
    }
}
