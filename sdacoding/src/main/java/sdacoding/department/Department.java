package sdacoding.department;


import sdacoding.candidate.Candidate;
import sdacoding.candidate.CandidateStatus;

public class Department implements Evaluator {
	private DepartmentName name;
	private int minLevelOfCompetence;
	
	public Department() {
	}
	
	public Department(DepartmentName name,
					  int minLevelOfCompetence) {
		this.name = name;
		this.minLevelOfCompetence = minLevelOfCompetence;
	}
	
	@Override
	public void evaluate(Candidate candidate) {
		if (candidate.getLevelOfCompetence() > this.minLevelOfCompetence){
			candidate.setStatus(CandidateStatus.ACCEPTED);
		} else {
			candidate.setStatus(CandidateStatus.REJECTED);
		}
	}
}
