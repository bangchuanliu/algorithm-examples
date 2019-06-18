package other;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Util {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Util util = new Util();
        
        String str = "中";
        
        this.getClass().isLocalClass()
        
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        byte[] bytes2 = str.getBytes(Charset.forName("ISO8859-1"));

        System.out.println(DatatypeConverter.printHexBinary(bytes2));
        System.out.println(new String(new byte[]{(byte)0x3f}, "ISO-8859-1"));

        String item = new String(new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad }, "ISO-8859-1");
        System.out.println(item);
    }
}


