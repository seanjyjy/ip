package duke.task;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Class that simulates the task that user has inputted.
 */

public class Task {
    private static final String TASK_MARKED_BEFORE = "This task has already been marked!";
    private static final String TASK_MARKED = "Nice! I've marked this task as done:";
    private static final String TASK_REMINDER_ON = "The reminder of this task %s, has been activated";
    private static final String TASK_REMINDER_OFF = "The reminder of this task %s, has been deactivated";
    protected String description;
    protected boolean isDone;
    protected boolean isReminderOn;
    protected int priority;
    protected LocalDateTime dueDate;
    /**
     * Creates a task object the containing details of the task.
     *
     * @param description Details of the task.
     * @param priority Integer value denoting the priority of the task.
     */
    public Task(String description, int priority) {
        this.description = description;
        this.isDone = false;
        this.isReminderOn = false;
        this.priority = priority;
    }
    
    /**
     * Creates a task object the containing details of the task.
     *
     * @param description Details of the task.
     * @param priority Integer value denoting the priority of the task.
     * @param dueDate LocalDateTime object denoting the due date of the task.
     */
    public Task(String description, int priority, LocalDateTime dueDate) {
        this.dueDate = dueDate;
        this.description = description;
        this.priority = priority;
    }

    /**
     * Creates a task object the containing details of the task.
     *
     * @param description Details of the task.
     * @param isDone Boolean value of whether a task is completed.
     * @param isReminderOn Boolean value of whether this task needs a reminder.
     * @param priority Integer value denoting the priority of the task.
     */
    public Task(String description, boolean isDone, boolean isReminderOn, int priority) {
        this.isDone = isDone;
        this.description = description;
        this.isReminderOn = isReminderOn;
        this.priority = priority;
    }

    /**
     * Creates a task object the containing details of the task.
     *
     * @param description Details of the task.
     * @param isDone Boolean value of whether a task is completed.
     * @param isReminderOn Boolean value of whether this task needs a reminder.
     * @param priority Integer value denoting the priority of the task.
     * @param dueDate LocalDateTime object denoting the due date of the task.
     */
    public Task(String description, boolean isDone, boolean isReminderOn, int priority, LocalDateTime dueDate) {
        this.isDone = isDone;
        this.description = description;
        this.isReminderOn = isReminderOn;
        this.priority = priority;
        this.dueDate = dueDate;
    }
    
    /**
     * Displays a cross if task is not done, a tick otherwise.
     *
     * @return Byte encoding strings of the symbols tick or X.
     */
    private String getStatusIcon() {
        return (isDone ? "\u2714" : "\u2718");
    }

    /**
     * Marks the task as completed.
     */
    public String markAsDone() {
        if (this.isDone) {
            return TASK_MARKED_BEFORE;
        } else {
            this.isDone = true;
            return TASK_MARKED + "\n" + this.toString();
        }
    }

    /**
     * Set the status of reminder option.
     *
     * @param status boolean value denote the status of reminder option.
     */
    public String setReminder(boolean status) {
        isReminderOn = status;
        if (status) {
            return String.format(TASK_REMINDER_ON, description);
        } else {
            return String.format(TASK_REMINDER_OFF, description);
        }
    }
    
    /**
     * Returns a proper styling to be recorded into CSV.
     *
     * @return A format to be recorded into CSV.
     */
    public String formatStyling() {
        return String.format(",%s,%d,%d\n", description, getTaskStatus(), getReminderStatus());
    }

    /**
     * If a task has a reminder on, return 1 else 0.
     *
     * @return An integer coded for the reminder status of the task.
     */
    public int getReminderStatus() {
        return isReminderOn ? 1 : 0;
    }
    
    /**
     * If a task is completed, return 1 else 0.
     *
     * @return An integer coded for the completed status of the task.
     */
    public int getTaskStatus() {
        return isDone ? 1 : 0;
    }
    /**
     * Retrieves the details of the task.
     *
     * @return A string representing the details of the task.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Retrieves the priority of the task.
     *
     * @return Integer representing the priority of the task.
     */
    public int getPriority() {
        return priority;
    }
    /**
     * Retrieves the due date of the task.
     *
     * @return A LocalDateTime object representing the due date.
     */
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
