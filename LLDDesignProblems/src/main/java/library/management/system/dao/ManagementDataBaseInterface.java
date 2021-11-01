package library.management.system.dao;

import library.management.system.model.Book;
import library.management.system.model.Record;
import library.management.system.model.User;

public interface ManagementDataBaseInterface {

    public void addBook(Book book);
    public void addUser(User user);
    public void addRecord(Record record) ;
    public Book getBook(String bookId);
    public User getUser(String userId);
    public Record geRecord(String recordId);
}

