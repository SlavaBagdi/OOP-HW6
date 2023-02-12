package HomeWork.TaskBook.Core.Models.FileMod;

import HomeWork.TaskBook.Core.Infrostructure.Taskbook;

public interface IDatabase {

    void save();

    Taskbook load();
}