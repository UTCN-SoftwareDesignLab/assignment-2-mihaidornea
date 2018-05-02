package bookStore.report;

import bookStore.dto.BookDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface ReportStrategy {

    InputStream createReport(List<BookDto> books) throws IOException;

}
