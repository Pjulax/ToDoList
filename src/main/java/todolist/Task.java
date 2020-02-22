package todolist;

public class Task {
    private String taskTitle;
    private boolean isDone;

    public Task(String taskTitle) {
        this.taskTitle = taskTitle;
        this.isDone = false;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public boolean isDone() {
        return isDone;
    }

    public void completion(){
        if(isDone){
            System.out.println("This task is already done");
        }
        else{
            isDone = true;
            System.out.println("todolist.Task is flagged as done");
        }
    }
}
