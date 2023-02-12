package HomeWork.TaskBook.Core.Models.FileMod;

import HomeWork.TaskBook.Core.Infrostructure.Taskbook;
/*
Abstract class for working with files
 */
public abstract class WorkWithFiles {

    private String path;

    private Taskbook taskbook;

    WorkWithFiles(String path, Taskbook taskbook) {
        this.path = path;
        this.taskbook = taskbook;
    }

    public Taskbook getTaskbook() {
        return taskbook;
    }

    public String getPath() {
        return path;
    }
}