package bookStore.service;

import bookStore.dto.BookDto;
import bookStore.report.ReportStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface ReportService{

    InputStream generateReport(List<BookDto> bookDtoList) throws IOException;
    void setReportStrategy(ReportStrategy reportStrategy);

}