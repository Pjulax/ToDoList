package todolist;

import todolist.javamail.JavaMailUtil;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Container myTaskList = new Container("Lista Zadan");
    public static void main(String[] args) throws Exception {
        int w = 0;
        boolean workFlag = true;

        //-------------TESTING DATA-----------------------
        myTaskList.addTask(new Task("Miec cos"));
        myTaskList.addTask(new Task("Wyslac maila"));
        myTaskList.addTask(new Task("Zrobic task liste z wysylaniem maili"));
        myTaskList.addTask(new Task("Pojsc spac"));
        myTaskList.addTask(new Task("Nie spac do rana"));

        //--------------TESTING DATA END------------------

        while(workFlag) {
            helloBuddy();
            System.out.print("Enter choice: ");
            w = in.nextInt();
            in.nextLine();
            switch (w) {
                case 1:
                    printTasks();
                    break;
                case 2:
                    changeState();
                    break;
                case 3:
                    addTask();
                    break;
                case 4:
                    deleteCompleted();
                    break;
                case 5:
                    removeTask();
                    break;
                case 6:
                    sendMail();
                    break;
                case 7:
                    workFlag = false;
                    System.out.println("Program is going to close. Good bye :)");
                    break;
            }
        }
    }

    private static void helloBuddy(){
        System.out.print("\n=========================================\n" +
                            "||    Hello " + myTaskList.getName() + " it is our menu:      ||\n" +
                            "=========================================\n" +
                            "1. Print your tasks\n" +
                            "2. Change your tasks state\n" +
                            "3. Add new task\n" +
                            "4. Delete all completed tasks\n" +
                            "5. Remove one task\n" +
                            "6. Send on email\n" +
                            "7. End program\n" +
                            "=========================================\n\n");
    }

    private static void printTasks(){
        myTaskList.printTasks();
    }

    private static void changeState(){
        printTasks();
        System.out.print("Choose which task you want to mark: ");
        int taskNumber = in.nextInt();
        in.nextLine();
        myTaskList.changeDoneFlag(taskNumber);
    }

    private static void addTask(){
        System.out.println("Now you are adding new task.");
        System.out.print("Enter tasks title: ");
        String taskTitle = in.nextLine();
        Task newTask = new Task(taskTitle);
        myTaskList.addTask(newTask);
    }

    private static void deleteCompleted(){
        myTaskList.deleteCompleted();
    }

    private static void removeTask(){
        printTasks();
        System.out.println("Choose which task you want to remove\n( 0 - if you want to get back to menu): ");
        int choose = in.nextInt();
        in.nextLine();
        myTaskList.removeTask(choose);
    }

    private static void sendMail(){
        System.out.println("Enter recipient e-mail:\n");
        String recipient = in.nextLine();
        String htmlCode = "";

        htmlCode = htmlCode + "<h3>" + myTaskList.getName() + "</h3>";
        htmlCode = htmlCode + myTaskList.getHtmlList();
        htmlCode = htmlCode + "</ol>";

        JavaMailUtil.sendMail(recipient, htmlCode);
    }

}
