package todolist;

import java.util.ArrayList;

public class Container {
    private String name;
    private ArrayList<Task> taskList;

    public Container(String name) {
        this.name = name;
        this.taskList = new ArrayList<Task>();
    }

    public String getName() {
        return name;
    }

    public void printTasks() {
        if(!(taskList.isEmpty())){
            System.out.print("\n\n=========================================\n" +
                                "||    " + this.name + " these are your tasks:      ||\n" +
                                "=========================================\n");
            for(int i=0; i<taskList.size(); i++){
                System.out.print((i+1) + ". ");
                if(taskList.get(i).isDone()){
                    System.out.print("[X]");
                }
                System.out.print(taskList.get(i).getTaskTitle() + "\n");
            }
            System.out.println("=========================================\n");
        }
        else{
            System.out.println("Your task list is empty, add something :)");
        }
    }

    public boolean changeDoneFlag(int taskNumber){
        if(taskNumber <= taskList.size() && taskNumber > 0){
            taskList.get(taskNumber-1).completion();
            return true;
        }
        System.out.println("todolist.Task number " + (taskNumber) + " doesn't exist.");
        return false;
    }

    public boolean addTask(Task task){
        if ( task != null && !(task.getTaskTitle().equals("")) ) {
            taskList.add(task);
            System.out.println("Added \"" + task.getTaskTitle() + "\" to your task list " + this.name);
            return true;
        }
        System.out.println("Can't reach task - no title or task doesn't exist");
        return false;
    }

    public boolean deleteCompleted(){
        if(taskList != null){
            for(int i=taskList.size()-1; i>=0; i--){
                if(taskList.get(i).isDone()) {
                    System.out.println("todolist.Task no." + (i+1) + " is done, deleting...");
                    taskList.remove(i);
                }
            }
            System.out.println("Successfully deleted completed tasks.");
            return true;
        }
        System.out.println("Failed to delete, task list doesn't exist.");
        return false;
    }

    public boolean removeTask(int taskNumber){
        if(taskList != null && taskNumber <= taskList.size() && taskNumber > 0){
            taskList.remove(taskNumber-1);
            System.out.println("Removed task no." + taskNumber + ".");
            return true;
        }else if (taskNumber == 0){
            System.out.println("0 entered, getting back to menu...");
            return true;
        }
        System.out.println("Failed to remove, check if number is correct or taskList exists.");
        return false;
    }

    public String getHtmlList() {
        String htmlCode = "<ol>\n";
        for (int i = 0; i< taskList.size(); i++){
            htmlCode += "<li>";
            if(taskList.get(i).isDone())
                htmlCode += " [X] ";
            else
                htmlCode += " [ ] ";
            htmlCode += taskList.get(i).getTaskTitle() +"</li>\n";
        }
        return htmlCode;
    }
}
