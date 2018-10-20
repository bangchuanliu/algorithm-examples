package leetcode.arraystring;

/**
 * 
 * @author bliu13 <liubangchuan1100@gmail.com>
 * @since Jan 17, 2016
 */
public class BulbSwitcher {

	/**
	 * math
	 * 
	 * !!! pass the OJ
	 * 
	 * @param n
	 * @return
	 */
	public int bulbSwitch(int n) {
		if (n <= 0) {
			return 0;
		}

		return (int) Math.sqrt(n);
	}

	
	/**
	 * simulate each step with program
	 * 
	 * !!!! it can't pass OJ, time exceed
	 * 
	 * @param n
	 * @return
	 */
	public int bulbSwitch2(int n) {
		if (n <= 0) {
			return 0;
		}

		boolean[] bulbOn = new boolean[n + 1];
		int round = 1;

		while (round <= n) {
			for (int i = round; i <= n; i += round) {
				bulbOn[i] = !bulbOn[i];
			}
			round++;
		}

		int count = 0;
		for (boolean isOn : bulbOn) {
			if (isOn) {
				count++;
			}
		}
		return count;
	}
}
