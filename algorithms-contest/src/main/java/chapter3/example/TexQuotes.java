package chapter3.example;

public class TexQuotes {
    
    public static String textQuotes(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '"') {
                sb.append(flag ? "''" : "``");
                flag = !flag;
            }else {
                sb.append(chars[i]);
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(textQuotes("\"to be or not to be\", quote \" that is a question\""));
    }
}
