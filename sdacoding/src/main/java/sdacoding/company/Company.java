package sdacoding.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import sdacoding.candidate.Candidate;
import sdacoding.candidate.CandidateStatus;
import sdacoding.department.Department;
import sdacoding.department.DepartmentName;
import sdacoding.department.Marketing;
import sdacoding.department.Production;
import sdacoding.exceptions.EvaluationIncapacityException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static sdacoding.candidate.CandidateStatus.ACCEPTED;

public class Company {
	private List<Department> departments = new ArrayList<>();
	private List<Candidate> candidates = new ArrayList<>();
	
	public Company() {
		departments.add(Marketing.getInstance());
		departments.add(Production.getInstance());
	}
	
	public void recruiting() {
		readCandidatesFromJsonFile();
		
		// sort list in descending order
		candidates.sort(new Comparator<Candidate>() {
			@Override
			public int compare(Candidate o1, Candidate o2) {
				if (o1.getLevelOfCompetence() > o2.getLevelOfCompetence()) {
					return -1;
				} else if (o1.getLevelOfCompetence() < o2.getLevelOfCompetence()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		
		// get candidates in marketing and production
		List<Candidate> candidatesInProd = new ArrayList<>();
		List<Candidate> candidatesInMarketing = new ArrayList<>();
		for (Candidate candidate : candidates) {
			if (candidate.getDepartmentName().equals(DepartmentName.MARKETING)) {
				candidatesInMarketing.add(candidate);
			} else if (candidate.getDepartmentName().equals(DepartmentName.PRODUCTION)) {
				candidatesInProd.add(candidate);
			} else {
				throw new EvaluationIncapacityException();
			}
		}
		
		List<Candidate> candidatesAccepted = getFinalCandidatesInMarketing(candidatesInMarketing);
		// todo
		List<Candidate> prodCandidatesAccepted = getFinalCandidatesInProduction(candidatesInProd);
		candidatesAccepted.addAll(prodCandidatesAccepted);
		writeCandidatesToJsonFile(candidatesAccepted);
	}
	
	// todo implement this method similar to marketing case
	private List<Candidate> getFinalCandidatesInProduction(List<Candidate> candidatesInProd) {
		return new ArrayList<>();
	}
	
	private List<Candidate> getFinalCandidatesInMarketing(List<Candidate> candidatesForMarketing) {
		Marketing marketing = Marketing.getInstance();
		List<Candidate> finalCandidates = new ArrayList<>();
		
		if (candidatesForMarketing.isEmpty()) {
			System.out.println("No candidates applied for marketing.");
			return finalCandidates;
		}
		
		for (Candidate c : candidatesForMarketing) {
			CandidateStatus firstResponse = marketing.evaluateBasedOnCompetenceLevel(c);
			c.setStatus(firstResponse);
			if (firstResponse.equals(ACCEPTED)) {
				CandidateStatus finalResponse = marketing.evaluateBasedOnOtherCriteria(c);
				c.setStatus(finalResponse);
				if (finalResponse.equals(ACCEPTED)) {
					finalCandidates.add(c);
				}
			}
		}
		return finalCandidates;
	}
	
	private void writeCandidatesToJsonFile(List<Candidate> candidates) {
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			objectMapper.writeValue(new File("candidati-acceptati.json"), candidates);
		} catch (Exception e) {
			System.out.println("Writing to json file failed.");
		}
	}
	
	private void readCandidatesFromJsonFile() {
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			// cees ce am citit din fisier
			String input = new String(Files.readAllBytes(Paths.get("candidati-initiali.json")));
			// object mapper - din String transforma in Lista de candidati
			this.candidates = objectMapper.readValue(input, objectMapper.getTypeFactory().constructCollectionType(List.class, Candidate.class));
			System.out.println(candidates);
		} catch (IOException e) {
			System.out.println("Reading from file failed");
		}
	}
	
}
