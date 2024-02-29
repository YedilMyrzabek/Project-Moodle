package interfaces;

import org.example.models.Subject;

public interface ISubjectRepository {
    Subject getOOPGrade(int id);
    boolean setOOPGrade(Subject subject, int id);
    Subject getCalculus2Grade(int id);
    boolean setCalculus2Grade(Subject subject, int id);
    Subject getIntroductionToProgramming2Grade(int id);
    boolean setIntroductionToProgramming2Grade(Subject subject, int id);
    Subject getPoliticalScienceGrade(int id);
    boolean setPoliticalScienceGrade(Subject subject, int id);
    Subject getDiscreteMathematicsGrade(int id);
    boolean setDiscreteMathematicsGrade(Subject subject, int id);
}
