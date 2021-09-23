
public class QuickFindDS implements DisjointSets {

	private int[] setNumber;

	public QuickFindDS(int n) {          //Takes θ(N)
		setNumber = new int[n];
		for (int i = 0; i < n; i++) {
			setNumber[i] = i;
		}
	}

	
	@Override
	public boolean isConnected(int x, int y) {   	// Takes θ(1) 

		return setNumber[x] == setNumber[y];
	}

	@Override
	public void connect(int x, int y) {  	// Takes θ(N) 

		if (isConnected(x, y)) {
			return;
		}

		int xSetNumber = setNumber[x];
		int ySetNumber = setNumber[y];

		for (int i = 0; i < setNumber.length; i++) {
			if (setNumber[i] == xSetNumber) {
				setNumber[i] = ySetNumber;
			}
		}
	}
}
