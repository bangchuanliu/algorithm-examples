package tag.dfs;

import common.NestedInteger;

import java.util.List;

public class NestedListWeightSumII {
    
    int sum = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        depthSumInverse(nestedList, depth(nestedList));
        return sum;
    }

    public void depthSumInverse(List<NestedInteger> nestedList, int len) {
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                sum += nest.getInteger() * len;
            } else {
                depthSumInverse(nest.getList(), len-1);
            }
        }
    }

    public int depth(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        int max = 0;
        for (NestedInteger nest : nestedList) {
            max = Math.max(max,depthSumInverse(nest.getList()) + 1);
        }
        return max;
    }
}
