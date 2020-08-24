package chapter6;

public class BrokenKeyboard {
    public static void main(String[] args) {
        String s = "This_is_a_[beiju]_text";
        String s2 = "[[]][][]Happy birthday to Silicon Valley";

        System.out.println(beijuText(s));
        System.out.println(beijuText(s2));

        brokenKeyboard(s);
        brokenKeyboard(s2);
    }

    public static String beijuText(String s) {
        ListNode head = new ListNode('h');
        ListNode p = head;
        ListNode tail = head;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                p = head;
            } else if (c == ']') {
                p = tail;
            } else {
                ListNode node = new ListNode(c);
                node.next = p.next;
                p.next = node;
                p = p.next;
                if (tail.next == p) {
                    tail = p;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (head.next != null) {
            sb.append(head.next.c);
            head = head.next;
        }

        return sb.toString();
    }

    public static void brokenKeyboard(String s) {
        int[] next = new int[1000];
        int cur = 0;
        int last = 0;
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == '['){
                cur = 0;
            }else if (chars[i] == ']'){
                cur = last;
            }else {
                next[i] = next[cur];
                next[cur] = i;
                if (cur == last){
                    last = i;
                }
                cur = i;
            }
        }
        
        for (int i = next[0]; i != 0; i = next[i]){
            System.out.print(chars[i]);
        }
        System.out.println();
    }
}

class ListNode {
    Character c;
    ListNode next;

    ListNode(Character c) {
        this.c = c;
    }
}
