package org.example.controllers;

import interfaces.IUserRepository;
import org.example.models.Subject;

public class SubjectController {
    private final IUserRepository repository;

    public SubjectController(IUserRepository repository) {
        this.repository = repository;
    }
    public String getOOPGrade(int id) {
        Subject subject = repository.getOOPGrade(id);
        return (subject == null ? "Teacher did't paste grade": subject.toString());
    }

    public String setOOPGrade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setOOPGrade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "ERRORRRRRR");
    }

    public String getCalculus2Grade(int id) {
        Subject subject = repository.getCalculus2Grade(id);
        return (subject == null ? "Subject was not" : subject.toString());
    }
    public String setCalculus2Grade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setCalculus2Grade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "ERRORRRRRR");
    }
    public String setIntroductionToProgramming2Grade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);
        boolean created = repository.setIntroductionToProgramming2Grade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "ERRORRRRRR");
    }
    public String getIntroductionToProgramming2Grade(int id) {
        Subject subject = repository.getIntroductionToProgramming2Grade(id);
        return (subject == null ? "Subject was not" : subject.toString());
    }
    public String setPoliticalScienceGrade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);
        boolean created = repository.setPoliticalScienceGrade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "ERRORRRRRR");
    }
    public String getPoliticalScienceGrade(int id) {
        Subject subject = repository.getPoliticalScienceGrade(id);
        return (subject == null ? "Subject was not" : subject.toString());
    }
    public String setDiscreteMathematicsGrade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setDiscreteMathematicsGrade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "ERRORRRRRR");
    }
    public String getDiscreteMathematicsGrade(int id) {
        Subject subject = repository.getDiscreteMathematicsGrade(id);
        return (subject == null ? "Subject was not" : subject.toString());
    }

}
