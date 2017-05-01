package com.jennifernguyen.app;

public class Application{
	public final String collegeState = "California";
	private double GPA;
	private double GPAScale;
	private Integer SATScore;
	private Integer ACTScore;
	private int felonyCount;
	private Applicant applicant;
	
	public Application(String firstName, String lastName, int age, String applicantState, 
					   double GPA, double GPAScale, Integer SATScore, Integer ACTScore, int felonyCount) {
		this.applicant = new Applicant(firstName, lastName, age, applicantState);
		this.GPA = GPA;
		this.GPAScale = GPAScale;
		this.SATScore = SATScore;
		this.ACTScore = ACTScore;
		this.felonyCount = felonyCount;
	}
	
	public double getGPAPercentile() {
		return GPA/GPAScale;
	}
	
	public boolean isValidInState() {
		if (applicant.getAge() > 16 && applicant.getAge() < 26) {
			return applicant.getApplicantState() == collegeState;
		} else if (applicant.getAge() > 80) {
			return true;
		}
		
		return false;
	}

	public Integer getSATScore() {
		return SATScore;
	}

	public Integer getACTScore() {
		return ACTScore;
	}
	
	public boolean hasSATScore() {
		return SATScore == null ? false : true;
	}
	
	public boolean hasACTScore() {
		return ACTScore == null ? false : true;
	}

	public int getFelonyCount() {
		return felonyCount;
	}

	public Applicant getApplicant() {
		return applicant;
	}
	
}
