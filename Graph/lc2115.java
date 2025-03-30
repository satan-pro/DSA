import java.util.*;
class lc2115
{
	public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
		HashMap<String, ArrayList<String>> adj = new HashMap<>();
		HashMap<String, Integer> outdegree = new HashMap<>();
		HashSet<String> stock = new HashSet<>();
		Queue<String> q = new LinkedList<>();

    // Initialize outdegree for all recipes
		for (String recipe : recipes) {
			outdegree.put(recipe, 0);
		}

    // Build adjacency list and outdegree map
		for (int i = 0; i < recipes.length; i++) {
			for (String ing : ingredients.get(i)) {
				adj.putIfAbsent(ing, new ArrayList<>());
				adj.get(ing).add(recipes[i]);
				outdegree.put(recipes[i], outdegree.getOrDefault(recipes[i], 0) + 1);
			}
		}

    // Add initial supplies to the queue and stock set
		for (String s : supplies) {
			q.offer(s);
			stock.add(s);
		}

		List<String> ans = new ArrayList<>();

		while (!q.isEmpty()) {
			String currMeal = q.poll();

        // Process neighbors in the adjacency list
			if (adj.containsKey(currMeal)) {
				for (String s : adj.get(currMeal)) {
					int deg = outdegree.get(s);
					if (deg == 1) {
						q.offer(s);
					}
					outdegree.put(s, deg - 1);
				}
			}

        // Add valid recipes to the answer
			if (Arrays.asList(recipes).contains(currMeal)) {
				ans.add(currMeal);
				stock.add(currMeal);
			}
		}

		return ans;
	}
}