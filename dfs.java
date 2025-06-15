package codes;
import java.util.*;

public class dfs {
	public boolean dfs_traversal(ArrayList<Integer> adj[],boolean visited[],int start) {
		boolean result=true;
		for(int i:adj[start]) {
			if(!visited[i]) {
				visited[i]=true;
				result=dfs_traversal(adj,visited,i);
			}
			else {
				return false;
			}
		}
		
		
		
		return result;
		
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int l=prerequisites.length;
		ArrayList <Integer>[] adj1= new ArrayList[l];
		int[] indegree = new int[l];
		
		for(int[] pair : prerequisites) {
			int course = pair[0];
            int prerequisite = pair[1];
            if (adj1[prerequisite] == null) {
                adj1[prerequisite] = new ArrayList<>();
            }
            adj1[prerequisite].add(course);
            indegree[course]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
		
		boolean visited[]=new boolean[numCourses];
        boolean result=false;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
		    result=dfs_traversal(adj1, visited, current);
		    visited[current]=true;
        }
        
        for(boolean i:visited){
            if(!i)
                return false;
        }
        
        for(ArrayList <Integer> i:adj1)
            for (int j:i){
                System.out.print(j+" ");
            System.out.println();
        }
        
		return result;
        
    }
	public static void main(String[] args) {
		
		
		
		
	}

}
