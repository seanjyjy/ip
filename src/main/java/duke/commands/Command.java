package duke.commands;

import duke.exception.InvalidFormatDateException;
import duke.exception.InvalidFormatDeadlineException;
import duke.exception.InvalidFormatEventException;
import duke.exception.UnknownCommandException;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

public class Command {
    
    private static final String KEYWORD_ERR = "Sorry something went wrong. duke.Duke crashed X.X";
    
    private boolean isExit = false;
    protected String[] inputArr;
    
    Command(String[] inputArr) {
        this.inputArr = inputArr;
    }
    
    public boolean getExitStatus() {
        return isExit;
    }
    
    public void setExitStatus(boolean status) {
        isExit = status;
    }

    public static void printErr() {
        System.out.println(KEYWORD_ERR);
    }

    public void printNumTask(TaskList tasks) {
        System.out.print(String.format("Now you have %d tasks in the list.\n", tasks.size()));
    }
    
    public void execute(TaskList tasks, Ui ui, Storage storage) throws
            UnknownCommandException, InvalidFormatDeadlineException, InvalidFormatEventException,
            InvalidFormatDateException {
        throw new UnknownCommandException();
    }
    
}