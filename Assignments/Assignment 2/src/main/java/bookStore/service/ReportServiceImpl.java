package bookStore.service;

import bookStore.dto.BookDto;
import bookStore.report.ReportStrategy;
import org.springframework.stereotype.Service;
import sun.util.resources.Bundles;

import java.io.IOException;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private ReportStrategy reportStrategy;

    public void setReportStrategy(ReportStrategy reportStrategy) {
        this.reportStrategy = reportStrategy;
    }

    public void generateReport(List<BookDto> bookDtoList) throws IOException {
        reportStrategy.createReport(bookDtoList);
    }

}
