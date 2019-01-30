package tag.topologicalsort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author bliu13 Dec 25, 2015
 */
public class CourseScheduleII {
	
	
	/**
	 * BFS
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {

		Queue<Integer> courses = new LinkedList<>();
		int[] degrees = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			degrees[prerequisites[i][0]]++;
		}

		int[] courseOrder = new int[numCourses];
		int index = 0;
		
		for (int i = 0; i < degrees.length; i++) {
			if (degrees[i] == 0) {
				courses.offer(i);
				courseOrder[index++] = i;
			}
		}

		while (!courses.isEmpty()) {
			int course = courses.poll();

			for (int i = 0; i < prerequisites.length; i++) {
				if (prerequisites[i][1] == course) {
					degrees[prerequisites[i][0]]--;

					if (degrees[prerequisites[i][0]] == 0) {
						courses.offer(prerequisites[i][0]);
						courseOrder[index++] = prerequisites[i][0];
					}
				}
			}

		}

		return index == numCourses ? courseOrder : new int[0];
	}
}
