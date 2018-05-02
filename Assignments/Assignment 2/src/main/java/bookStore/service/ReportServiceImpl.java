package bookStore.service;

import bookStore.dto.BookDto;
import bookStore.report.ReportStrategy;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private ReportStrategy reportStrategy;

    public void setReportStrategy(ReportStrategy reportStrategy) {
        this.reportStrategy = reportStrategy;
    }

    public InputStream generateReport(List<BookDto> bookDtoList) throws IOException {
        return reportStrategy.createReport(bookDtoList);
    }

}
