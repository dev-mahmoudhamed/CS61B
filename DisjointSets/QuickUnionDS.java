
public class QuickUnionDS implements DisjointSets {

	private int[] parent;

	public QuickUnionDS(int n) {             // Takes θ(n)
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = -7;
		}
	}

	@Override
	public boolean isConnected(int x, int y) {     //Takes O(N)
		return findRoot(x) == findRoot(y);
	}

	@Override
	public void connect(int x, int y) {           //Takes O(N)

		int i = findRoot(x);
		int j = findRoot(y);
		parent[i] = j;
	}

	private int findRoot(int p) {
		int temp = p;
		while (parent[temp] >= 0) {
			temp = parent[temp];
		}
		return temp;
	}
}
