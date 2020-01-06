package sdacoding.company;

import sdacoding.candidate.Candidate;
import sdacoding.department.Department;
import sdacoding.department.DepartmentName;
import sdacoding.department.Marketing;
import sdacoding.department.Production;
import sdacoding.exceptions.EvaluationIncapacityException;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private List<Department> departments = new ArrayList<>();
	private List<Candidate> candidates = new ArrayList<>();
	
	
	public void recruiting() {
		Marketing marketing = new Marketing();
		Production production = new Production();
		for (Candidate c : candidates) {
			if (c.getDepartmentName().equals(DepartmentName.MARKETING)) {
				marketing.evaluate(c);
			} else if (c.getDepartmentName().equals(DepartmentName.PRODUCTION)) {
				production.evaluate(c);
			} else {
				throw new EvaluationIncapacityException();
			}
		}
	}
	
	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
}
