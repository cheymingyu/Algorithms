package experiment;

public class ParameterSetForMeasurement extends ParameterSetForIteration {
	// Constants for parameters
	
	private static final int DEFAULT_NUMBER_OF_REPETITION_OF_SINGLE_SORT = 1;
	
	// Instance Variables
	private int _numberOfRepetitionOfSingleSort;
	
	// getters & setters
	public int numberOfRepetitionOfSingleSort() {
		return this._numberOfRepetitionOfSingleSort;
	}
	public void setNumberOfRepetitionOfSingleSort(int newNumberOfRepetitionOfSingleSort) {
		this._numberOfRepetitionOfSingleSort = newNumberOfRepetitionOfSingleSort;
	}
	
	// Constructors
	public ParameterSetForMeasurement() {
		super();
		this.setNumberOfRepetitionOfSingleSort(DEFAULT_NUMBER_OF_REPETITION_OF_SINGLE_SORT);
	}
	public ParameterSetForMeasurement(
			int givenStartingSize,
			int givenNumberOfIteration,
			int givenIncrementSize,
			int givenNumberOfRepetitionOfSingleSort)
	{
		super(givenStartingSize, givenNumberOfIteration, givenIncrementSize);
		this.setNumberOfRepetitionOfSingleSort(givenNumberOfRepetitionOfSingleSort);
	}

}
