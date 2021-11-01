package library.management.system.model;

import library.management.system.exception.BookIssuedException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Book {
    String name;
    String version;
    String author;
    String id;
    int count;

    public Book(String name, String author, String id, int count) {
        this.name = name;
        this.author = author;
        this.count = count;
    }
/*
    public void addRecord(String id) throws BookIssuedException {
        if (isIssued) {
            throw new BookIssuedException("This book is already issue id:" + id);
        }
        records.add(id);
        isIssued = true;
    }

    public void unIssueBook() {
        this.isIssued = false;
    }

    public String getCurrentRecord() throws BookIssuedException {
        if(!isIssued || records.size() == 0) {
            throw new BookIssuedException("This book is not issued id: "+id);
        }

        return records.get(records.size()-1);
    }

 */

}
