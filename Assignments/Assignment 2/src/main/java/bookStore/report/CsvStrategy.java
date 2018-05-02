package bookStore.report;

import bookStore.dto.BookDto;

import java.io.*;
import java.util.List;

public class CsvStrategy implements ReportStrategy{

    @Override
    public InputStream createReport(List<BookDto> books) throws IOException {
        File file = new File("D:/assignment-2-mihaidornea/Assignments/Assignment 2/my_doc.csv");
        PrintWriter pw = new PrintWriter(file);
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
        InputStream inputStream = new FileInputStream(file);
        return inputStream;
    }
}
