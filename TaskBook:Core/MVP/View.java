package HomeWork.TaskBook.Core.MVP;

import HomeWork.TaskBook.Core.Enums.Priorities;

public interface View {

    void showMessage(String message);

    String getTaskText();

    void setTaskText(String value);

    Priorities getPriority();

    void setPriority(String value);

    String getDeadline();

    void setDeadline(String value);

    String getAuthor();

    void setAuthor(String value);

    void setCreateDate(String value);

    void printMenu();


}