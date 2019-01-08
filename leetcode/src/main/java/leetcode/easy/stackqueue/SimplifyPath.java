package leetcode.easy.stackqueue;

import java.util.Stack;

public class SimplifyPath {

	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return path;
		}

		Stack<String> stack = new Stack<>();

		int i = 0;
		int start = 0;
		while (i < path.length()) {
			while (i < path.length() && path.charAt(i) == '/') {
				i++;
			}

			if (i == path.length()) {
				break;
			}
			start = i;

			while (i < path.length() && path.charAt(i) != '/') {
				i++;
			}
			String temp = path.substring(start, i);

			if (temp.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (!temp.equals(".")) {
				stack.push(temp);
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
