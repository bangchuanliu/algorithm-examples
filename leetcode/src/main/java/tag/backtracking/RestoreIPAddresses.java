package tag.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public List<String> restoreIpAddresses(String s) {
		List<String> ipList = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return ipList;
		}

		List<List<String>> result = new ArrayList<>();
		List<String> temp = new ArrayList<>();

		restoreIpAddresses(result, temp, s, 4);

		for (List<String> list : result) {
			StringBuilder sb = new StringBuilder();
			for (String ip : list) {
				sb.append(ip).append(".");
			}
			ipList.add(sb.toString().substring(0, sb.length() - 1));
		}

		return ipList;
	}

	public void restoreIpAddresses(List<List<String>> result, List<String> temp, String s, int index) {
		if (s.length() > 3 * index || s.length() < index) {
			return;
		}

		if (s.length() == 0 && temp.size() == 4) {
			result.add(new ArrayList<>(temp));
			return;
		}

		for (int i = 1; i <= s.length(); i++) {
			String str = s.substring(0, i);
			if (str.length() > 3 || (str.length() == 3 && Integer.parseInt(str) > 255)
					|| str.length() > 1 && str.startsWith("0")) {
				break;
			}

			temp.add(s.substring(0, i));
			restoreIpAddresses(result, temp, s.substring(i), index - 1);
			temp.remove(temp.size() - 1);
		}
	}
}
