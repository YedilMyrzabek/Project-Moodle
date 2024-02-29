package org.example.resources;
import org.example.controllers.LoginController;
import org.example.controllers.SubjectController;
import org.example.controllers.UserController;

import java.util.*;

public class MyApplication {
    private final UserController controller;
    private final LoginController loginController;
    private final SubjectController subjectController;
    Scanner sc;
    public MyApplication(UserController controller, LoginController loginController, SubjectController subjectController) {
        this.controller = controller;
        this.loginController = loginController;
        this.subjectController = subjectController;
        sc = new Scanner(System.in);
    }
    public void start() {
        System.out.println("Welcome to University");

        while (true) {
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Administration");
            System.out.print("Enter option(1-3): ");
            try {
                int optioin = sc.nextInt();
                if (optioin == 1) {
                    System.out.println("1. Login");
                    System.out.println("2. Register");
                    System.out.print("Enter option(1-2): ");
                    int optioin2 = sc.nextInt();
                    if (optioin2 == 1) {
                        Log();
                    }else if(optioin2 == 2){
                        Reg();
                    }else {
                        break;
                    }
                } else if (optioin == 2) {
                    System.out.println("Login");
                    LogForTeacher();
                } else if (optioin == 3) {
                    LogForAdmin();
                }
                else {
                    break;
                }
                System.out.println("***************************************"+"\n");
            }catch (InputMismatchException e){
                System.out.println("Input must be integer");
            } catch (Exception e) {
                System.out.println("If you forget your nickname or password,\nPlease contact with Yedil Myrzabek or Akerke Sugirbek");
            }
        }
    }
    public void administration(){
        System.out.println("Welcome to Administration");

        while (true) {
            System.out.println("1. Get All Students");
            System.out.println("2. Get Student by ID");
            System.out.println("3. Write Student's Data");
            System.out.println("4. Delete Student ");
            System.out.println("0. Exit");

            try {
                int optioin = sc.nextInt();

                if (optioin == 1) {
                    getAllUsersMenu();
                } else if (optioin == 2) {
                    getUserByIdMenu();
                } else if (optioin == 3) {
                    createUserMenu();
                } else if (optioin == 4) {
                    deleteStudentById();
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Error in Adminstration()");;
            }
        }
    }

    public void Nextstart() {
        System.out.println("Welcome to University");

        while (true) {
            System.out.println("Main menu");
            System.out.println("1. Dashboard");
            System.out.println("2. Get All Logins");
            System.out.println("3. Get Student by ID");
            System.out.println("0. Exit");

            try {
                int optioin = sc.nextInt();

                if (optioin == 1) {
                    getDashboard();
                } else if (optioin == 2) {
                    getAllLoginsMenu();
                } else if (optioin == 3) {
                    getUserByIdMenu();
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Error in NextStart()");;
            }
        }
    }

    public void getDashboard(){
        while (true) {
            System.out.println("Dashboard menu");
            System.out.println("1. Object-Oriented Programming");
            System.out.println("2. Introduction to Programming 2");
            System.out.println("3. Political Science");
            System.out.println("4. Discrete Mathematics");
            System.out.println("5. Calculus 2");
            System.out.println("0. Exit");

            try {
                int optioin = sc.nextInt();

                if (optioin == 1) {
                    setOOPGrade();
                } else if (optioin == 5) {
                    setCalculus2Grade();
                } else if (optioin == 2) {
                    setIntroductionToProgramming2Grade();
                } else if (optioin == 3) {
                    setPoliticalScienceGrade();
                } else if (optioin == 4) {
                    setDiscreteMathematicsGrade();
                } else {
                    break;
                }
            } catch (InputMismatchException in) {
                System.out.println("Input must be an integer");
                sc.nextLine();
            }
        }
    }
    public void getDashboardForStudent(int id){
        while (true) {
            System.out.println("Dashboard menu");
            System.out.println("1. Calculate GPA");
            System.out.println("2. Object-Oriented Programming");
            System.out.println("3. Introduction to Programming 2");
            System.out.println("4. Political Science");
            System.out.println("5. Discrete Mathematics");
            System.out.println("6. Calculus 2");
            System.out.println("0. Exit");

            try {
                int optioin = sc.nextInt();

                if (optioin == 1) {
                    GPA();
                } else if (optioin == 2) {
                    getOOPGrade(id);
                } else if (optioin == 6) {
                    getCalculus2Grade(id);
                } else if (optioin == 3) {
                    getIntroductionToProgramming2Grade(id);
                } else if (optioin == 4) {
                    getPoliticalScienceGrade(id);
                } else if (optioin == 5 ) {
                    getDiscreteMathematicsGrade(id);
                } else {
                    break;
                }
            } catch (InputMismatchException in) {
                System.out.println("Input must be an integer");
                sc.nextLine();
            }
        }
    }
    public void getOOPGrade(int id){
        String response = subjectController.getOOPGrade(id);
        System.out.println(response);
    }
    public void setOOPGrade( ){
        System.out.println("Student ID");
        int id = sc.nextInt();

        System.out.println("Midterm grade");
        int midka = sc.nextInt();
        System.out.println("Endterm grade");
        int endka = sc.nextInt();
        System.out.println("Final grade");
        int fin = sc.nextInt();

        String responce = subjectController.setOOPGrade(id,midka,endka,fin);
        System.out.println(responce);
    }
    public void getCalculus2Grade(int id){
        String response =subjectController.getCalculus2Grade(id);
        System.out.println(response);
    }
    public void setCalculus2Grade(){
        System.out.println("Student ID");
        int id = sc.nextInt();
        System.out.println("Midterm grade");
        int midka = sc.nextInt();
        System.out.println("Endterm grade");
        int endka = sc.nextInt();
        System.out.println("Final grade");
        int fin = sc.nextInt();

        String responce = subjectController.setCalculus2Grade(id,midka,endka,fin);
        System.out.println(responce);
    }
    public void setIntroductionToProgramming2Grade(){
        System.out.println("Student ID");
        int id = sc.nextInt();
        System.out.println("Midterm grade");
        int midka = sc.nextInt();
        System.out.println("Endterm grade");
        int endka = sc.nextInt();
        System.out.println("Final grade");
        int fin = sc.nextInt();

        String responce = subjectController.setIntroductionToProgramming2Grade(id,midka,endka,fin);
        System.out.println(responce);
    }
    public void getIntroductionToProgramming2Grade(int id){
        String response =subjectController.getIntroductionToProgramming2Grade(id);
        System.out.println(response);
    }
    public void setPoliticalScienceGrade(){
        System.out.println("Student ID");
        int id = sc.nextInt();
        System.out.println("Midterm grade");
        int midka = sc.nextInt();
        System.out.println("Endterm grade");
        int endka = sc.nextInt();
        System.out.println("Final grade");
        int fin = sc.nextInt();

        String responce = subjectController.setPoliticalScienceGrade(id,midka,endka,fin);
        System.out.println(responce);
    }
    public void getPoliticalScienceGrade(int id){
        String response =subjectController.getPoliticalScienceGrade(id);
        System.out.println(response);
    }
    public void setDiscreteMathematicsGrade(){
        System.out.println("Student ID");
        int id = sc.nextInt();
        System.out.println("Midterm grade");
        int midka = sc.nextInt();
        System.out.println("Endterm grade");
        int endka = sc.nextInt();
        System.out.println("Final grade");
        int fin = sc.nextInt();

        String responce = subjectController.setDiscreteMathematicsGrade(id,midka,endka,fin);
        System.out.println(responce);
    }
    public void getDiscreteMathematicsGrade(int id){
        String response =subjectController.getDiscreteMathematicsGrade(id);
        System.out.println(response);
    }
    public void LogForTeacher() {
        System.out.println("User name: ");
        String userName = sc.next();
        System.out.println("Password: ");
        String userPassword = sc.next();

        boolean responce = loginController.loginForTeacher(userName, userPassword);
        if (responce) {
            Nextstart();
        }else {
            System.out.println("Invalid Name or Password");
        }
    }
    public void LogForAdmin(){
        System.out.println("User name: ");
        String userName = sc.next();
        System.out.println("Password: ");
        String userPassword = sc.next();

        boolean responce = loginController.loginForAdmin(userName, userPassword);
        if (responce) {
            administration();
        }else {
            System.out.println("Invalid Name or Password");
        }
    }

    public void getAllUsersMenu() {
        String response = controller.getAllUsers();
        System.out.println(response);
    }
    public void getAllLoginsMenu(){
        String responce = controller.getAllLogin();
        System.out.println(responce);
    }

    public void getUserByIdMenu() {
        System.out.println("Please enter id");
        int id = sc.nextInt();
        String response = controller.getUser(id);
        System.out.println(response);
    }

    public void createUserMenu() {
        System.out.println("Student's ID");
        int id = sc.nextInt();
        System.out.println("Student's name: ");
        String studentName = sc.next();
        System.out.println("Student's surname: ");
        String studentSurname = sc.next();
        System.out.println("Please enter gender (male/female)");
        String studentGender = sc.next();
        System.out.println("Student's Address: ");
        String studentAddress = sc.next();
        System.out.println("Student's Email: ");
        String studentEmail = sc.next();
        System.out.println("Student's Phone: ");
        String studentPhone = sc.next();


        String response = controller.createStudent(id, studentName, studentSurname, studentGender, studentAddress, studentEmail, studentPhone);
        System.out.println(response);
    }
    public void deleteStudentById(){
        System.out.println("Student's ID: ");
        int studentID = sc.nextInt();

        String responce = loginController.deleteStudentById(studentID);
        System.out.println(responce);
    }

    public void Log() {
        System.out.println("Nickname: ");
        String userName = sc.next();
        System.out.println("Password: ");
        String userPassword = sc.next();

        int id = Integer.parseInt(userPassword);

        boolean responce = loginController.login(userName, userPassword);

        if (!responce) {
            System.out.println("Yedil Myrzabek");
        }else {
            getDashboardForStudent(id);
        }


    }
    public void Reg() {
        System.out.println("Create nickname: ");
        String userName = sc.next();
        System.out.println("Create password: ");
        String userPassword = sc.next();

        boolean testReg = loginController.testReg(userName,userPassword);
        if(testReg) {
            System.out.println("User already exists");
            System.out.println("Change nickname or password");
        }else {
            String responce = loginController.register(userName, userPassword);
            System.out.println(responce);
        }

    }
    public void GPA() {
        System.out.print("Number of courses: ");
        int num = sc.nextInt();
        sc.nextLine();

        Map<String, Double> gradePoint = new HashMap<>();
        gradePoint.put("A", 4.0);
        gradePoint.put("A-", 3.67);
        gradePoint.put("B+", 3.33);
        gradePoint.put("B", 3.0);
        gradePoint.put("B-", 2.67);
        gradePoint.put("C+", 2.33);
        gradePoint.put("C", 2.0);
        gradePoint.put("C-", 1.67);
        gradePoint.put("D+", 1.33);
        gradePoint.put("D", 1.0);
        gradePoint.put("F", 0.0);

        double total = 0.0;
        for (int i = 0; i < num; i++) {
            System.out.print("Enter grade for course " + (i + 1) + " (Write like that: A, B+): ");
            String grade = sc.nextLine().toUpperCase();
            Double points = gradePoint.get(grade);
            if (points != null) {
                total += points;
            } else {
                System.out.println("Invalid grade. Please use a example grade format.");
                i--;
            }
        }

        double gpa = total / num;
        System.out.printf("Your GPA is: "+ gpa+"\n");
    }
}

