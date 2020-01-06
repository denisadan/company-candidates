package sdacoding.department;

import sdacoding.candidate.Candidate;
import sdacoding.candidate.CandidateStatus;

import static sdacoding.candidate.CandidateStatus.ACCEPTED;
import static sdacoding.candidate.CandidateStatus.REJECTED;
import static sdacoding.candidate.Gender.F;
import static sdacoding.candidate.Gender.M;

public class Marketing extends Department {
	private static Marketing instance = new Marketing();
	private int maximNoOfOpenPositionsForMales = getOpenPositions() * 40 / 100;
	private int maximNoOfOpenPositionsForFemales = getOpenPositions() * 60 / 100;
	
	private Marketing() {
		super(DepartmentName.MARKETING, 5, 10);
	}
	
	public static Marketing getInstance() {
		return instance;
	}
	
	@Override
	public CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate) {
		if (candidate.getLevelOfCompetence() < this.getMinLevelOfCompetence()) {
			return CandidateStatus.REJECTED;
		} else {
			return CandidateStatus.ACCEPTED;
		}
	}
	
	@Override
	public CandidateStatus evaluateBasedOnOtherCriteria(Candidate candidate) {
		if (candidate.getGender().equals(M) && maximNoOfOpenPositionsForMales > 0) {
			maximNoOfOpenPositionsForMales = maximNoOfOpenPositionsForMales - 1;
			return ACCEPTED;
		} else if (candidate.getGender().equals(F) && maximNoOfOpenPositionsForFemales > 0) {
			maximNoOfOpenPositionsForFemales = maximNoOfOpenPositionsForFemales - 1;
			return ACCEPTED;
		}
		return REJECTED;
	}
	
}
