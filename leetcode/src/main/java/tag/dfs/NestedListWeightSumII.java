package tag.dfs;

import common.NestedInteger;

import java.util.List;

public class NestedListWeightSumII {


    public int depthSumInverse(List<NestedInteger> nestedList) {
        return depthSumInverse(nestedList, depth(nestedList));
    }

    public int depthSumInverse(List<NestedInteger> nestedList, int len) {
        if (nestedList == null) {
            return 0;
        }
        
        int sum = 0;
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                sum += nest.getInteger() * len;
            } else {
                depthSumInverse(nest.getList(), len - 1);
            }
        }

        return sum;
    }

    public int depth(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        int max = 0;
        for (NestedInteger nest : nestedList) {
            max = Math.max(max, depthSumInverse(nest.getList()) + 1);
        }
        return max;
    }
}
