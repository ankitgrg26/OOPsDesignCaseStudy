package library.management.system.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class Record {
    String recordId;
    String bookId;
    String userId;
    long startDate;
    long endDate;
}
