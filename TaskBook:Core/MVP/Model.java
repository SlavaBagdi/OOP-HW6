package HomeWork.TaskBook.Core.MVP;

import HomeWork.TaskBook.Core.Infrostructure.Taskbook;
import HomeWork.TaskBook.Core.Models.FileMod.Database;
import HomeWork.TaskBook.Core.Models.FileMod.ExportCSV;
import HomeWork.TaskBook.Core.Models.FileMod.ImportCSV;

public class Model {

    Taskbook currentBook;

    public Model() {
        currentBook = new Taskbook();
    }

    public void setCurrentBook(Taskbook book) {
        this.currentBook = book;
    }

    public void save() {
        Database database = new Database(currentBook);
        database.save();
    }

    public void load() {
        Database database = new Database(currentBook);
        this.currentBook = database.load();
    }

    public void importFromCSV() {
        ImportCSV importCSV = new ImportCSV(currentBook);
        importCSV.importFrom();
    }

    public void exportToCSV() {
        ExportCSV exportCSV = new ExportCSV(currentBook);
        exportCSV.exportTo();
    }

    public Taskbook getCurrentBook() {
        return this.currentBook;
    }

}