package tag.queue;

public class TaskSchedulerII {
    
    private int LeastIntervalKeepOrder(char[] tasks, int n)
    {
        int result = 0;
        int[] nextPos = new int[26];

        for(int i = 0; i < tasks.length; i++)
        {
            int cur = tasks[i] - 'A';
            result = Math.max(result, nextPos[cur]) + 1;
            nextPos[cur] = result + n;
        }

        return result;
    }
    
    public static void main(String[] args) {
        TaskSchedulerII taskSchedulerII = new TaskSchedulerII();
        char[] tasks = {'A'};
        char[] tasks2 = {'A','A'};
        char[] tasks3 = {'A','B'};
        char[] tasks4 = {'A','A','B'};
        char[] tasks5 = {'A','B','A'};
        System.out.println(taskSchedulerII.LeastIntervalKeepOrder(tasks, 2));
        System.out.println(taskSchedulerII.LeastIntervalKeepOrder(tasks2, 2));
        System.out.println(taskSchedulerII.LeastIntervalKeepOrder(tasks3, 2));
        System.out.println(taskSchedulerII.LeastIntervalKeepOrder(tasks4, 2));
        System.out.println(taskSchedulerII.LeastIntervalKeepOrder(tasks5, 2));
    }
}
