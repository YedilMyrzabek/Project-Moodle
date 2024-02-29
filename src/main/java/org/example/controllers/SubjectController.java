package org.example.controllers;

import interfaces.ISubjectRepository;
import org.example.models.Subject;

public class SubjectController {
    private final ISubjectRepository repository;

    public SubjectController(ISubjectRepository repository) {
        this.repository = repository;
    }
    public String getOOPGrade(int id) {
        Subject subject = repository.getOOPGrade(id);
        return (subject == null ? "Teacher did't paste grade": subject.toString());
    }

    public String setOOPGrade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setOOPGrade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "Error with service");
    }

    public String getCalculus2Grade(int id) {
        Subject subject = repository.getCalculus2Grade(id);
        return (subject == null ? "Teacher did't paste grade" : subject.toString());
    }

    public String setCalculus2Grade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setCalculus2Grade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "Error with service");
    }

    public String setIntroductionToProgramming2Grade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setIntroductionToProgramming2Grade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "Error with service");
    }

    public String getIntroductionToProgramming2Grade(int id) {
        Subject subject = repository.getIntroductionToProgramming2Grade(id);
        return (subject == null ? "Teacher did't paste grade" : subject.toString());
    }

    public String setPoliticalScienceGrade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setPoliticalScienceGrade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "Error with service");
    }

    public String getPoliticalScienceGrade(int id) {
        Subject subject = repository.getPoliticalScienceGrade(id);
        return (subject == null ? "Teacher did't paste grade" : subject.toString());
    }

    public String setDiscreteMathematicsGrade(int id, int mid, int end, int fin) {
        Subject subject = new Subject(mid, end, fin);

        boolean created = repository.setDiscreteMathematicsGrade(subject, id);
        return (created ? "Subject Details Inserted Successfully" : "Error with service");
    }

    public String getDiscreteMathematicsGrade(int id) {
        Subject subject = repository.getDiscreteMathematicsGrade(id);
        return (subject == null ? "Teacher did't paste grade" : subject.toString());
    }

}
