package tag.stackqueue;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String str : strs) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!str.equals(".") && !str.equals("")) {
                stack.push(str);
            }
        }


        if (!stack.isEmpty()) {
            String str = "";
            while (!stack.isEmpty()) {
                str = "/" + stack.pop() + str;
            }
            return str;
        } else {
            return "/";
        }
    }

    public static void main(String[] args) {
        SimplifyPath instance = new SimplifyPath();
        System.out.println(instance.simplifyPath("/"));
        System.out.println(instance.simplifyPath("/home/"));
        System.out.println(instance.simplifyPath("/a/./b/../../c/"));
        System.out.println(instance.simplifyPath("/../"));
        System.out.println(instance.simplifyPath("/home//foo/"));
    }
}
