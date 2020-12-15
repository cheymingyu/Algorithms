package app;

import experiment.ExperimentManager;
import experiment.ExperimentManagerForQuickSortWithInsertionSort;
import experiment.ExperimentManagerForQuickSorts;
import experiment.ExperimentManagerForThreeSorts;
import experiment.ListOrder;

public class AppController {
	
	// Private instance variables
	private ExperimentManagerForThreeSorts _managerForThreeSorts;
	private ExperimentManagerForQuickSorts _managerForQuickSorts;
	private ExperimentManagerForQuickSortWithInsertionSort _managerForQuickSortWithInsertionSort;
	
	// Getter & setter
	private ExperimentManagerForThreeSorts managerForThreesorts() {
		return this._managerForThreeSorts;
	}
	private void setManagerForThreeSorts(ExperimentManagerForThreeSorts newExperimentManager) {
		this._managerForThreeSorts = newExperimentManager; 
	}
	
	private ExperimentManagerForQuickSorts managerForQuickSorts() {
		return this._managerForQuickSorts;
	}
	private void setManagerForQuickSorts(ExperimentManagerForQuickSorts newExperimentManager) {
		this._managerForQuickSorts = newExperimentManager; 
	}
	
	private ExperimentManagerForQuickSortWithInsertionSort managerForQuickSortWithInsertionSort() {
		return this._managerForQuickSortWithInsertionSort;
	}
	private void setManagerForQuickSortWithInsertionSort(
			ExperimentManagerForQuickSortWithInsertionSort newExperimentManager) 
	{
		this._managerForQuickSortWithInsertionSort = newExperimentManager;
	}
	
	// Private methods
	private void showTableTitle(ListOrder anOrder) {
		AppView.outputLine("> " + anOrder.orderName() + " �����Ϳ� ���� ����:");
	}
	
	private void showTableHeadForThreeSorts() {
		AppView.outputLine(
				String.format("%8S", " ") +
				String.format("%26s", "<Insertion Sort>") +
				String.format("%26s", "  <Quick Sort>  ") +
				String.format("%26s", "  <Heap Sort>   ")
				);
		AppView.outputLine(
				String.format("%7S", "  ������ ũ��") +
				String.format("%39s", "Measure (Estimate)") +
				String.format("%26s", "Measure (Estimate)") +
				String.format("%26s", "Measure (Estimate)")
				);
	}
	
	private void showTableContentForThreeSorts() {
		for (int iteration = 0;
				iteration < this.managerForThreesorts().parameterSetForMeasurement().numberOfIteration();
				iteration++) 
		{
			int startingSize = this.managerForThreesorts().parameterSetForMeasurement().startingSize();
			int incrementSize = this.managerForThreesorts().parameterSetForMeasurement().incrementSize();
			int sortingSize = startingSize + (incrementSize * iteration);
			AppView.outputLine(
					"[" + String.format("%7d", sortingSize) + "]" +
					String.format("%15d", this.managerForThreesorts().measurementForInsertionSortAt(iteration)) +
					" (" + String.format("%8d", this.managerForThreesorts().estimationForInsertionSortAt(iteration)) + ")" +
					String.format("%15d", this.managerForThreesorts().measurementForQuickSortAt(iteration)) +
					" (" + String.format("%8d", this.managerForThreesorts().estimationForQuickSortAt(iteration)) + ")" +
					String.format("%15d", this.managerForThreesorts().measurementForHeapSortAt(iteration)) +
					" (" + String.format("%8d", this.managerForThreesorts().estimationForHeapSortAt(iteration)) + ")"
			);
		}
	}
	
	private void showResultTableForThreeSorts(ListOrder anOrder) {
		this.showTableTitle(anOrder);
		this.showTableHeadForThreeSorts();
		this.showTableContentForThreeSorts();
		AppView.outputLine("");
	}
	
	private void showTableHeadForQuickSorts() {
		AppView.outputLine(
				String.format("%7S", "  ������ ũ��       ") +
				String.format("%18s", "<Pivot Left>") +
				String.format("%18s", "<Pivot Mid>") +
				String.format("%19s", "<Pivot Median>") +
				String.format("%18s", "<Pivot Random>") +
				String.format("%18s", "<Insertion Sort>")
				);
	}
	
	private void showTableContentForQuickSorts() {
		for (int iteration = 0;
				iteration < this.managerForQuickSorts().parameterSetForMeasurement().numberOfIteration();
				iteration++)
		{
			int startingSize = this.managerForQuickSorts().parameterSetForMeasurement().startingSize();
			int incrementSize = this.managerForQuickSorts().parameterSetForMeasurement().incrementSize();
			int sortingSize = startingSize + (incrementSize * iteration);
			AppView.outputLine(
					"[" + String.format("%7d", sortingSize) + "]" +
					String.format("%16s", this.managerForQuickSorts().
							measurementForQuickSortByPivotLeftAt(iteration)) +
					String.format("%18s", this.managerForQuickSorts().
							measurementForQuickSortByPivotMidAt(iteration)) +
					String.format("%18s", this.managerForQuickSorts().
							measurementForQuickSortByPivotMedianAt(iteration)) +
					String.format("%18s", this.managerForQuickSorts().
							measurementForQuickSortByPivotRandomAt(iteration)) +
					String.format("%18s", this.managerForQuickSorts().
							measurementForQuickSortWithInsertionSortAt(iteration))
					);
		}
	}
	
	private void showResultTableForQuickSorts(ListOrder anOrder) {
		this.showTableTitle(anOrder);
		this.showTableHeadForQuickSorts();
		this.showTableContentForQuickSorts();
		AppView.outputLine("");
	}
	
	private void showTableHeadForQuickSortWithInsertionSort() {
		AppView.output(
				String.format("%7s  ", " ������ ũ��") + 
				String.format("%15s", "<Pivot Random>"));
		int numberOfIteration = 
				this.managerForQuickSortWithInsertionSort().
				parameterSetForMaxSizeOfInsertionSort().
				numberOfIteration();
		for (int iterationOfMaxSize = 0;
				iterationOfMaxSize < numberOfIteration;
				iterationOfMaxSize ++) 
		{
			int startingMaxSize =
					this.managerForQuickSortWithInsertionSort().
					parameterSetForMaxSizeOfInsertionSort().
					startingSize();
			int incrementSizeOfMaxSize = 
					this.managerForQuickSortWithInsertionSort().
					parameterSetForMaxSizeOfInsertionSort().
					incrementSize();
			int maxSortingSize = startingMaxSize + incrementSizeOfMaxSize * iterationOfMaxSize;
			AppView.output(String.format("   <Size%3d>", maxSortingSize));
		}
		AppView.outputLine("");
	}
	
	private void showTableContentForQuickSortWithInsertionSort() {
		int numberOfIteration = 
				this.managerForQuickSortWithInsertionSort().
				parameterSetForMeasurement().
				numberOfIteration();
		for (int iteration = 0; iteration < numberOfIteration; iteration++) {
			int startingSize = this.managerForQuickSortWithInsertionSort().parameterSetForMeasurement().startingSize();
			int incrementSize = this.managerForQuickSortWithInsertionSort().parameterSetForMeasurement().incrementSize();
			int sortingSize = startingSize + (incrementSize * iteration);
			AppView.output("[" + String.format("%7d", sortingSize) + "]");
			AppView.output(
					String.format("%12d", this.managerForQuickSortWithInsertionSort().
							measurementForQuickSortByPivotRandomAt(iteration)));
			int numberOfIterationOfMaxSize = 
					this.managerForQuickSortWithInsertionSort().
					parameterSetForMaxSizeOfInsertionSort().
					numberOfIteration();
			for (int iterationOfMaxSize = 0; iterationOfMaxSize < numberOfIterationOfMaxSize; iterationOfMaxSize++) {
				AppView.output(
						String.format("%12d", this.managerForQuickSortWithInsertionSort().
								measurementForQuickSortWithInsertionSortAt(iterationOfMaxSize, iteration)));
			}
			AppView.outputLine("");
		}
	}
	
	private void showResultTableForQuickSortWithInsertionSort(ListOrder anOrder) {
		this.showTableTitle(anOrder);
		this.showTableHeadForQuickSortWithInsertionSort();
		this.showTableContentForQuickSortWithInsertionSort();
		AppView.outputLine("");
	}
	
	private void measureAndShow(ExperimentManager anExperimentManager, ListOrder anOrder) {
		anExperimentManager.performExperiment(anOrder);
		if (anExperimentManager.getClass().equals(ExperimentManagerForThreeSorts.class)) {
			this.showResultTableForThreeSorts(anOrder);

		}
		else if (anExperimentManager.getClass().equals(ExperimentManagerForQuickSorts.class)) {
			this.showResultTableForQuickSorts(anOrder);
		}
		else {
			this.showResultTableForQuickSortWithInsertionSort(anOrder);
		}
	}
	
	// public method
	public void run() {
		AppView.outputLine("<<< ���� ���� �� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");
		{
			AppView.outputLine(">> 3 ���� ������ ���� ��: ����, ��, �Q <<");
			this.setManagerForThreeSorts(new ExperimentManagerForThreeSorts());
			this.managerForThreesorts().prepareExperiment(null);
		
			this.measureAndShow(this.managerForThreesorts(), ListOrder.Random);
			this.measureAndShow(this.managerForThreesorts(), ListOrder.Ascending);
			this.measureAndShow(this.managerForThreesorts(), ListOrder.Descending); 
		}
		{
			AppView.outputLine(">> 5 ���� �� ������ ���� �� <<");
			this.setManagerForQuickSorts(new ExperimentManagerForQuickSorts());
			this.managerForQuickSorts().prepareExperiment(null);
		 
			this.measureAndShow(this.managerForQuickSorts(), ListOrder.Random);
			this.measureAndShow(this.managerForQuickSorts(), ListOrder.Ascending);
			this.measureAndShow(this.managerForQuickSorts(), ListOrder.Descending);
		}
		{
			AppView.outputLine(">> ���� ������ ����ϴ� �� ������ ����: ���� ������ �����ϴ� ũ�⺰ ������ �� <<");
			this.setManagerForQuickSortWithInsertionSort(new ExperimentManagerForQuickSortWithInsertionSort());
			this.managerForQuickSortWithInsertionSort().prepareExperiment(null);
			
			this.measureAndShow(this.managerForQuickSortWithInsertionSort(), ListOrder.Random);
			
			this.managerForQuickSortWithInsertionSort().parameterSetForMaxSizeOfInsertionSort().setStartingSize(15);
			this.managerForQuickSortWithInsertionSort().parameterSetForMaxSizeOfInsertionSort().setIncrementSize(1);;
			this.managerForQuickSortWithInsertionSort().parameterSetForMaxSizeOfInsertionSort().setNumberOfIteration(11);;
			this.measureAndShow(this.managerForQuickSortWithInsertionSort(), ListOrder.Random);
		}
		AppView.outputLine("<<< ���� ���� �� ���α׷��� �����մϴ� >>>");
	}

}
