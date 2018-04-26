package bookStore.report;

import bookStore.dto.BookDto;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvStrategy implements ReportStrategy{

    @Override
    public void createReport(List<BookDto> books) throws IOException {
        PrintWriter pw = new PrintWriter(new File("D:/assignment-2-mihaidornea/Assignments/Assignment 2/my_doc.csv"));
        StringBuilder stringBuilder = new StringBuilder();

        for (BookDto bookDto : books){

            stringBuilder
                    .append(bookDto.getTitle())
                    .append(",")
                    .append(bookDto.getIsbn())
                    .append(",");

            pw.write(stringBuilder.toString());
            pw.close();

        }

    }
}
