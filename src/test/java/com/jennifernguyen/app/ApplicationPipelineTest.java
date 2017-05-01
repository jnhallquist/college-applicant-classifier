package com.jennifernguyen.app;

import junit.framework.TestCase;

public class ApplicationPipelineTest extends TestCase {
	public void testIsInstantReject() {
		// Felony count > 0
		Application isInstantReject1 = new Application("Jane", "Smith", 17, "California", 3.6, 4.0, 1920, 27, 1);
		// GPA < 0.7
		Application isInstantReject2 = new Application("Jane", "Smith", 17, "California", 1.6, 4.0, 1920, 27, 0);
		// Negative age
		Application isInstantReject3 = new Application("Jane", "Smith", -3, "California", 3.6, 4.0, 1920, 27, 0);
		// invalid name
		Application isInstantReject4 = new Application("Jane", "smith", 17, "California", 3.6, 4.0, 1920, 27, 0);
		//GPA < 0.7 and invalid name
		Application isInstantReject5 = new Application("Jane", "smith", 17, "California", 1.6, 4.0, 1920, 27, 0);
		
		assertEquals ( ApplicationPipeline.process(isInstantReject1), 
					   "Applicant has 1 or more felonies committed during past 5 years.\n" 
					 );
		assertEquals ( ApplicationPipeline.process(isInstantReject2), "Applicant GPA is less than 70%.\n" );
		assertEquals ( ApplicationPipeline.process(isInstantReject3), "Applicant claims negative age.\n" );
		assertEquals ( ApplicationPipeline.process(isInstantReject4), "Applicant name is not capitalized properly.\n" );
		assertEquals ( ApplicationPipeline.process(isInstantReject5), 
						"Applicant GPA is less than 70%.\nApplicant name is not capitalized properly.\n" 
					 );
	}
	
	public void testIsNotInstantReject() {
		Application isNotInstantReject = new Application("Jane", "Smith", 17, "California", 3.6, 4.0, 1920, 27, 0);
		
		assertEquals ( ApplicationPipeline.process(isNotInstantReject), "Candidate requires further review." );
	}
	
	public void testIsprocess() {
		// No ACT submitted
		Application isInstantAccept = new Application("Jane", "Smith", 17, "California", 4.0, 4.0, 2000, null, 0);
		// Is out-of-state, no ACT 
		Application isInstantAccept2 = new Application("Jane", "Smith", 83, "Wyoming", 4.0, 4.0, 2000, null, 0);
		// Both ACT and SAT submitted
		Application isInstantAccept3 = new Application("Jane", "Smith", 17, "California", 4.0, 4.0, 2000, 30, 0);
		// Is out-of-state, no SAT
		Application isInstantAccept4 = new Application("Jane", "Smith", 83, "Wyoming", 4.0, 4.0, null, 30, 0);
		
		assertEquals ( ApplicationPipeline.process(isInstantAccept), "Candidate is instantly accepted." );
		assertEquals ( ApplicationPipeline.process(isInstantAccept2), "Candidate is instantly accepted." );
		assertEquals ( ApplicationPipeline.process(isInstantAccept3), "Candidate is instantly accepted." );
		assertEquals ( ApplicationPipeline.process(isInstantAccept4), "Candidate is instantly accepted." );
	}
	
	public void testIsNotInstantAccept() {
		// ACT too low
		Application isNotInstantAccept = new Application("Jane", "Smith", 17, "California", 4.0, 4.0, 1820, 25, 0);
		// GPA too low
		Application isNotInstantAccept2 = new Application("Jane", "Smith", 17, "California", 3.8, 5.0, 2020, null, 0);
		// 17 years old but not in California
		Application isNotInstantAccept3 = new Application("Jane", "Smith", 17, "Wyoming", 4.8, 5.0, 2020, null, 0);
		// SAT too low
		Application isNotInstantAccept4 = new Application("Jane", "Smith", 17, "California", 4.8, 5.0, 1750, null, 0);
		// No ACT or SAT
		Application isNotInstantAccept5 = new Application("Jane", "Smith", 17, "California", 4.8, 5.0, null, null, 0);
		
		assertEquals ( ApplicationPipeline.process(isNotInstantAccept), "Candidate requires further review." );
		assertEquals ( ApplicationPipeline.process(isNotInstantAccept2), "Candidate requires further review." );
		assertEquals ( ApplicationPipeline.process(isNotInstantAccept3), "Candidate requires further review." );
		assertEquals ( ApplicationPipeline.process(isNotInstantAccept4), "Candidate requires further review." );
		assertEquals ( ApplicationPipeline.process(isNotInstantAccept5), "Candidate requires further review." );
	}
}
