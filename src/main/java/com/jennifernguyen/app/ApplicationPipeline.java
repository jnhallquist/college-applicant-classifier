package com.jennifernguyen.app;

public class ApplicationPipeline {
    public static String process(Application application) {
        String isInstantlyRejected = instantReject(application);

        if (isInstantlyRejected.length() == 0) {
            if (instantAccept(application)) {
                return "Candidate is instantly accepted.";
            } else {
                return "Candidate requires further review.";
            }
        }

        return isInstantlyRejected;
    }

    private static String instantReject(Application application) {
        StringBuilder errors = new StringBuilder();

        if (application.getFelonyCount() > 0) {
            errors.append("Applicant has 1 or more felonies committed during past 5 years.\n");
        }

        if (application.getGPAPercentile() < 0.7) {
            errors.append("Applicant GPA is less than 70%.\n");
        }

        if (!application.getApplicant().hasValidAge()) {
            errors.append("Applicant claims negative age.\n");
        }

        if (!application.getApplicant().hasValidName()) {
            errors.append("Applicant name is not capitalized properly.\n");
        }

        return errors.length() > 0 ? errors.toString() : "";
    }

    private static boolean instantAccept(Application application) {		
        if ((application.hasSATScore() && application.getSATScore() > 1920) ||
                (application.hasACTScore() && application.getACTScore() > 27)) {
            if (application.isValidInState() && application.getGPAPercentile() >= 0.9) {
                return true;
            }
        }

        return false;
    }
}
