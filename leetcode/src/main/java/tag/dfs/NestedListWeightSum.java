package tag.dfs;

import common.NestedInteger;

import java.util.List;

public class NestedListWeightSum {
    
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList , 1);
    }

    public int depthSum(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                sum += nest.getInteger() * level;
            }else {
                sum += depthSum(nest.getList(), level + 1);
            }
        }

        return sum;
    }
}
