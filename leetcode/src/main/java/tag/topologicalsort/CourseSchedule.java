package tag.topologicalsort;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author bliu13 Dec 24, 2015
 */
public class CourseSchedule {
	/**
	 * BFS
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		Queue<Integer> courses = new LinkedList<>();
		int[] degrees = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			degrees[prerequisites[i][0]]++;
		}

		for (int i = 0; i < degrees.length; i++) {
			if (degrees[i] == 0) {
				courses.offer(i);
			}
		}

		int numsOfVetex = courses.size();

		while (!courses.isEmpty()) {
			int course = courses.poll();

			for (int i = 0; i < prerequisites.length; i++) {
				if (prerequisites[i][1] == course) {
					degrees[prerequisites[i][0]]--;

					if (degrees[prerequisites[i][0]] == 0) {
						courses.offer(prerequisites[i][0]);
						numsOfVetex++;
					}
				}
			}

		}

		return numsOfVetex == numCourses;
	}

	/**
	 * DFS
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish2(int numCourses, int[][] prerequisites) {

		if (numCourses <= 0 || prerequisites == null) {
			return false;
		}

		int[] degrees = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			degrees[prerequisites[i][0]]++;
		}

		Set<Integer> vetexs = new HashSet<>();

		for (int i = 0; i < degrees.length; i++) {
			if (degrees[i] == 0 && !vetexs.contains(i)) {
				vetexs.add(i);
				canFinish(prerequisites, degrees, vetexs, i);
			}
		}

		return vetexs.size() == numCourses;
	}

	public void canFinish(int[][] prerequisites, int[] degrees, Set<Integer> vetexs, int vetex) {
		for (int i = 0; i < prerequisites.length; i++) {
			if (prerequisites[i][1] == vetex) {
				degrees[prerequisites[i][0]]--;
				if (degrees[prerequisites[i][0]] == 0) {
					vetexs.add(prerequisites[i][0]);
					canFinish(prerequisites, degrees, vetexs, prerequisites[i][0]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = {{1,0}};
		
		CourseSchedule instance = new CourseSchedule();
		instance.canFinish2(numCourses, prerequisites);
	}
}
