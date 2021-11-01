package library.management.system;

import library.management.system.exception.BookIssuedException;

public interface LibraryManagementSystemInterface {
    public void issueBook(String bookId, String userId) throws BookIssuedException;

    public void unIssueBook(String bookId) throws BookIssuedException;
    
}
