package tag.greedy;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas == null || cost == null || gas.length == 0 || cost.length == 0){
			return -1;
		}
		int total = 0;
		int sumRemaining = 0;
		int start = 0;
		for(int i = 0;i<gas.length;i++){
			int remain = gas[i] - cost[i];
			if(sumRemaining >= 0){
				sumRemaining += remain;
			}else{
				sumRemaining = remain;
				start = i;
			}
			total += remain;
		}
		if(total >=0){
			return start;
		}
		return -1;
	}
	
	public static void main(String[] args){
		GasStation instance = new GasStation();
		int[] gas = {99,98,97,100};
		int[] cost = {100,100,100,97};
		System.out.println(instance.canCompleteCircuit(gas, cost));
	}
	
}
