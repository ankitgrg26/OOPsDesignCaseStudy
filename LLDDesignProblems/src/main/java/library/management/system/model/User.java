package library.management.system.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class User {
    String userId;
    String name;
    String address;
    String age;
    UserType UserType;
    List<String> bookRecords;
    double securityDeposit;

    public void issueBook(String record) {
        bookRecords.add(record);
    }
}
