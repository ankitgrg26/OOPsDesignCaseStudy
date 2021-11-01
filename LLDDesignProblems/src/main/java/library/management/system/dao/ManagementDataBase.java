package library.management.system.dao;

import library.management.system.model.Book;
import library.management.system.model.Record;
import library.management.system.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class ManagementDataBase  implements ManagementDataBaseInterface{
    final Map<String, Book> bookMap;
    final Map<String, Record> recordMap;
    final Map<String, User> userMap;

    public ManagementDataBase() {
        bookMap = new HashMap<String, Book>();
        recordMap = new HashMap<String, Record>();
        userMap = new HashMap<String, User>();
    }

    private String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public void addBook(final Book book) {
        bookMap.put(book.getId(), book);
    }

    public void addUser(final User user) {
        userMap.put(user.getUserId(), user);
    }

    public void addRecord(final Record record) {
        recordMap.put(record.getRecordId(), record);
    }

    public Book getBook(String bookId) {
        return this.bookMap.get(bookId);
    }

    public User getUser(String userId) {
        return this.userMap.get(userId);
    }

    public Record geRecord(String recordId) {
        return this.recordMap.get(recordId);
    }
}
