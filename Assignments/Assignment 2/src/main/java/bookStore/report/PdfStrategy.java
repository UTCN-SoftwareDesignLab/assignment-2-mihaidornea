package bookStore.report;
import java.io.File;
import java.io.IOException;
import java.util.List;

import bookStore.dto.BookDto;
import bookStore.report.ReportStrategy;
import bookStore.repository.BookRepository;
import bookStore.service.BookService;
import bookStore.service.BookServiceImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;

public class PdfStrategy implements ReportStrategy {

    @Override
    public void createReport(List<BookDto> books) throws IOException {

        File file = new File("D:/assignment-2-mihaidornea/Assignments/Assignment 2/my_doc.pdf");
        PDDocument doc = PDDocument.load(file);
        PDPage page = new PDPage();
        doc.addPage(page);
        //Creating a PDF Document

        PDPageContentStream contentStream = new PDPageContentStream(doc, page);

        //Begin the Content stream
        contentStream.beginText();

        //Setting the font to the Content stream
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 16);

        //Setting the leading
        contentStream.setLeading(14.5f);

        //Setting the position for the line
        contentStream.newLineAtOffset(25, 725);

        //Adding text in the form of string
        for (BookDto bookDto : books) {
            contentStream.showText("Title: " + bookDto.getTitle() + " " + "ISBN: " + bookDto.getIsbn());
            contentStream.newLine();
        }
        //Ending the content stream
        contentStream.endText();

        //Closing the content stream
        contentStream.close();

        //Saving the document
        doc.save(new File("D:/assignment-2-mihaidornea/Assignments/Assignment 2/my_doc.pdf"));

        //Closing the document
        doc.close();

    }
}
