package sdacoding;

import sdacoding.candidate.Candidate;
import sdacoding.company.Company;
import sdacoding.department.DepartmentName;

import java.util.ArrayList;
import java.util.List;

public class TestCandidate {
	public static void main(String[] args) {
		Candidate c1 = new Candidate("Popescu", 10, DepartmentName.MARKETING);
		Candidate c2 = new Candidate();
		Candidate c3 = new Candidate("Ionescu");
		Company company = new Company();
		
		List<Candidate> candidates = new ArrayList<>();
		candidates.add(c1);
		candidates.add(c2);
		candidates.add(c3);
		company.setCandidates(candidates);
		System.out.println(candidates);
		company.recruiting();
		System.out.println(candidates);
	}
}
