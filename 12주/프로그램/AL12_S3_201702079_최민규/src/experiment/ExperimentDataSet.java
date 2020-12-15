package experiment;

public class ExperimentDataSet {
	
	// Private instance variables
	private int _maxDataSize;
	
	private Integer[] _randomList;
	private Integer[] _ascendingList;
	private Integer[] _descendingList;
	
	// Getters & Setters
	public int maxDataSize() {
		return this._maxDataSize;
	}
	private void setMaxDataSize(int newMaxDataSize) {
		this._maxDataSize = newMaxDataSize;
	}
	
	public Integer[] randomList() {
		return this._randomList;
	}
	private void setRandomList(Integer[] newRandomList) {
		this._randomList = newRandomList;
	}
	
	public Integer[] ascendingList() {
		return this._ascendingList;
	}
	private void setAscendingList(Integer[] newAscendingList) {
		this._ascendingList = newAscendingList;
	}
	
	public Integer[] descendingList() {
		return this._descendingList;
	}
	private void setDescendingList(Integer[] newDescendingList) {
		this._descendingList = newDescendingList;
	}
	
	// Constructor
	public ExperimentDataSet() {
		this.setRandomList(null);
		this.setAscendingList(null);
		this.setDescendingList(null);
	}
	
	public ExperimentDataSet(int givenMaxDataSize) {
		if (! this.generate(givenMaxDataSize)) {
			this.setRandomList(null);
			this.setAscendingList(null);
			this.setDescendingList(null);
		}
	}
	
	// public method
	public boolean generate(int aMaxDataSize) {
		// There are two ways to get a data set:
		// (1) Create a new "ExperimentDataSet" object with an appropriate data size;
		// (2) Call this method directly for the existing "ExperimentDataSet" object
		//     without creating a new "ExperimentDataSet" object.
		// Therefore, this method is used for replacing the existing data set with a new data set.
		if (aMaxDataSize <= 0) {
			// If "aMaxDataSize" is not valid,
			// the current status of this object does not change.
			// And so, this method returns false.
			return false;
		}
		else {
			// "aMaxDataSize" is valid.
			// So, this method generates a new data set, and returns true.
			this.setMaxDataSize(aMaxDataSize);
			this.setRandomList(DataGenerator.randomList(this.maxDataSize()));
			this.setAscendingList(DataGenerator.ascencingList(this.maxDataSize()));
			this.setDescendingList(DataGenerator.descendingList(this.maxDataSize()));
			return true;
		}
	}
	
	public Integer[] listWithOrder(ListOrder anOrder) {
		if (anOrder.equals(ListOrder.Random)) {
			return this.randomList();
		}
		else if (anOrder.equals(ListOrder.Ascending)) {
			return this.ascendingList();
		}
		else if (anOrder.equals(ListOrder.Descending)) {
			return this.descendingList();
		}
		else {
			return null;
		}
	}

}
