package sdacoding.candidate;

import sdacoding.department.DepartmentName;

public class Candidate {
	private String name;
	private int levelOfCompetence;
	private CandidateStatus status;
	private DepartmentName departmentName;
	
	public Candidate() {
	}
	
	public Candidate(String name) {
		this.name = name;
	}
	
	public Candidate(String name,
					 int levelOfCompetence,
					 DepartmentName departmentName) {
		this.name = name;
		this.levelOfCompetence = levelOfCompetence;
		this.status = CandidateStatus.AWAITING_RESPONSE;
		this.departmentName = departmentName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLevelOfCompetence() {
		return levelOfCompetence;
	}
	
	public void setLevelOfCompetence(int levelOfCompetence) {
		this.levelOfCompetence = levelOfCompetence;
	}
	
	public CandidateStatus getStatus() {
		return status;
	}
	
	public void setStatus(CandidateStatus status) {
		this.status = status;
	}
	
	public DepartmentName getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(DepartmentName departmentName) {
		this.departmentName = departmentName;
	}
	
	@Override
	public String toString() {
		return "\nCandidate{" +
				"name='" + name + '\'' +
				", levelOfCompetence=" + levelOfCompetence +
				", status=" + status +
				", departmentName=" + departmentName +
				'}';
	}
}


