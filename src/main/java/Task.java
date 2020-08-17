
public class Task {

    //@@author Damith C. Rajapakse
    //Reused from https://nus-cs2103-ay2021s1.github.io/website/schedule/week2/project.html with minor modifications
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    private String getStatusIcon() {
        //return tick or X symbols
        return (isDone ? "\u2713" : "\u2718");
    }
    //@@author

    public void markAsDone() {
        if (this.isDone) {
            System.out.println("This task has already been marked!");
        } else {
            this.isDone = true;
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(this);
        }
    }


    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

}