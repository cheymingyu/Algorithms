package app;

import experiment.ExperimentManager;
import experiment.ExperimentManagerForQuickSorts;
import experiment.ExperimentManagerForThreeSorts;
import experiment.ListOrder;

public class AppController {
	
	// Private instance variables
	private ExperimentManagerForThreeSorts _managerForThreeSorts;
	private ExperimentManagerForQuickSorts _managerForQuickSorts;
	
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
	
	// Private methods
	private void showTableTitle(ListOrder anOrder) {
		AppView.outputLine("> " + anOrder.orderName() + " 데이터에 대한 측정:");
	}
	
	private void showTableHeadForThreeSorts() {
		AppView.outputLine(
				String.format("%8S", " ") +
				String.format("%26s", "<Insertion Sort>") +
				String.format("%26s", "  <Quick Sort>  ") +
				String.format("%26s", "  <Heap Sort>   ")
				);
		AppView.outputLine(
				String.format("%7S", "  데이터 크기") +
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
				String.format("%7S", "  데이터 크기       ") +
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
	
	private void measureAndShow(ExperimentManager anExperimentManager, ListOrder anOrder) {
		anExperimentManager.performExperiment(anOrder);
		if (anExperimentManager.getClass().equals(ExperimentManagerForThreeSorts.class)) {
			this.showResultTableForThreeSorts(anOrder);

		}
		else if (anExperimentManager.getClass().equals(ExperimentManagerForQuickSorts.class)) {
			this.showResultTableForQuickSorts(anOrder);
		}
	}
	
	// public method
	public void run() {
		AppView.outputLine("<<< 정렬 성능 비교 프로그램을 시작합니다 >>>");
		AppView.outputLine("");
		{
			AppView.outputLine(">> 3 가지 정렬의 성능 비교: 삽입, 퀵, 힢 <<");
			this.setManagerForThreeSorts(new ExperimentManagerForThreeSorts());
			this.managerForThreesorts().prepareExperiment(null);
			
			this.measureAndShow(this.managerForThreesorts(), ListOrder.Random);
			this.measureAndShow(this.managerForThreesorts(), ListOrder.Ascending);
			this.measureAndShow(this.managerForThreesorts(), ListOrder.Descending);
		}
		{
			AppView.outputLine(">> 5 가지 퀵 정렬의 성능 비교 <<");
			this.setManagerForQuickSorts(new ExperimentManagerForQuickSorts());
			this.managerForQuickSorts().prepareExperiment(null);
			
			this.measureAndShow(this.managerForQuickSorts(), ListOrder.Random);
			this.measureAndShow(this.managerForQuickSorts(), ListOrder.Ascending);
			this.measureAndShow(this.managerForQuickSorts(), ListOrder.Descending);

		}
		AppView.outputLine("<<< 정렬 성능 비교 프로그램을 종료합니다 >>>");
	}

}
