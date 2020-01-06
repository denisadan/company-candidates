package sdacoding.department;

import sdacoding.candidate.Candidate;
import sdacoding.candidate.CandidateStatus;

import static sdacoding.department.DepartmentName.PRODUCTION;

public class Production extends Department {
	private static Production instance = new Production();
	
	private Production() {
		super(PRODUCTION, 8, 3);
	}
	
	public static Production getInstance() {
		return instance;
	}
	
	public CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate) {
		return CandidateStatus.AWAITING_RESPONSE;
	}
}
