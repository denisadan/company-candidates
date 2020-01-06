package sdacoding.department;

import sdacoding.candidate.Candidate;
import sdacoding.candidate.CandidateStatus;

public class Department implements Evaluator {
	private DepartmentName name;
	private int minLevelOfCompetence;
	private int openPositions;
	
	public Department(DepartmentName name,
					  int minLevelOfCompetence,
					  int openPositions) {
		this.name = name;
		this.minLevelOfCompetence = minLevelOfCompetence;
		this.openPositions = openPositions;
	}
	
	public CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate) {
		return CandidateStatus.AWAITING_RESPONSE;
	}
	
	public CandidateStatus evaluateBasedOnOtherCriteria(Candidate candidate) {
		return CandidateStatus.AWAITING_RESPONSE;
	}
	
	public int getMinLevelOfCompetence() {
		return minLevelOfCompetence;
	}
	
	public int getOpenPositions() {
		return openPositions;
	}
	
}
