package org.example;

import interfaces.IUserRepository;

import java.sql.ResultSet;
import java.util.*;

public class MyApplication {
    private final UserController controller;
    Scanner sc;

    public MyApplication(UserController controller) {
        this.controller = controller;
        sc = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to University");

        while (true) {
            System.out.println("1. Login\n2. Register");
            System.out.print("Enter option(1-2): ");
            System.out.println();
            try {
                int optioin = sc.nextInt();
                if (optioin == 1) {
                    Log();
                } else if (optioin == 2) {
                    Reg();
                } else {
                    break;
                }
            } catch (InputMismatchException in) {
                System.out.println("Input must be an integer");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("***************************************");
        }
    }

    public void Nextstart() {
        System.out.println("Welcome to University");

        while (true) {
            System.out.println("Main menu");
            System.out.println("1. Get All Users");
            System.out.println("2. Get User by ID");
            System.out.println("3. Create Student");
            System.out.println("4. Calculate GPA");
            System.out.println("5. Delete Student By ID");
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
                    GPA();
                } else if(optioin == 5){
                    deleteStudentById();
                } else {
                    break;
                }
            } catch (InputMismatchException in) {
                System.out.println("Input must be an integer");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("***************************************");
        }
    }

    public void getAllUsersMenu() {
        String response = controller.getAllUsers();
        System.out.println(response);
    }

    public void getUserByIdMenu() {
        System.out.println("Please enter id");
        int id = sc.nextInt();
        String response = controller.getUser(id);
        System.out.println(response);
    }

    public void createUserMenu() {
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

        String response = controller.createStudent(studentName, studentSurname, studentGender, studentAddress, studentEmail, studentPhone);
        System.out.println(response);
    }
    public void deleteStudentById(){
        System.out.println("Student's ID: ");
        int studentID = sc.nextInt();

        String responce = controller.deleteStudentById(studentID);
        System.out.println(responce);
    }

    public void Log() {
        System.out.println("User name: ");
        String userName = sc.next();
        System.out.println("Password: ");
        String userPassword = sc.next();

        String responce = controller.login(userName, userPassword);
        if (responce.equals("a")) {
            Nextstart();
        }
    }

    public void Reg() {
        System.out.println("User name: ");
        String userName = sc.next();
        System.out.println("Password: ");
        String userPassword = sc.next();

        String responce = controller.register(userName, userPassword);
        System.out.println(responce);
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
