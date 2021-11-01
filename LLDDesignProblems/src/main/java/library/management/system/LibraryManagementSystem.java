package library.management.system;

import library.management.system.dao.ManagementDataBaseInterface;
import library.management.system.exception.BookIssuedException;
import library.management.system.model.Book;
import library.management.system.model.Record;

import java.util.UUID;

public class LibraryManagementSystem implements LibraryManagementSystemInterface {

    ManagementDataBaseInterface ManagementDataBase;

    public LibraryManagementSystem(ManagementDataBaseInterface ManagementDataBase) {
        this.ManagementDataBase = ManagementDataBase;
    }

    public void issueBook(String bookId, String userId) throws BookIssuedException {
        Record record = Record.builder()
                .recordId(UUID.randomUUID().toString())
                .bookId(bookId)
                .userId(userId)
                .startDate(System.currentTimeMillis())
                .build();
        //ManagementDataBase.getBook(bookId).addRecord(record.getRecordId());
        ManagementDataBase.getUser(userId).issueBook(record.getRecordId());
        ManagementDataBase.addRecord(record);
    }


    public void unIssueBook(String bookId) throws BookIssuedException {
        Book book = ManagementDataBase.getBook(bookId);
        //String recordId = book.getCurrentRecord();
       // Record record = ManagementDataBase.geRecord(recordId);
       // if (record.getEndDate() == 0) {
       //     throw new BookIssuedException("book is already returned id: " + bookId);
       // }
       // record.setEndDate(System.currentTimeMillis());
        //book.unIssueBook();
    }
}
