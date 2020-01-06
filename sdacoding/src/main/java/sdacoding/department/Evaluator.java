package sdacoding.department;

import sdacoding.candidate.Candidate;
import sdacoding.candidate.CandidateStatus;

public interface Evaluator {
	CandidateStatus evaluateBasedOnCompetenceLevel(Candidate candidate);
	CandidateStatus evaluateBasedOnOtherCriteria(Candidate candidate);
}
