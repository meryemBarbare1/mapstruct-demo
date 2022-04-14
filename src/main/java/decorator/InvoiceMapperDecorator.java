package decorator;


import dto.InvoiceDto;
import entity.Invoice;
import lombok.Setter;
import mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Setter
public abstract class InvoiceMapperDecorator implements InvoiceMapper {

    @Autowired
    @Qualifier("delegate")
    private InvoiceMapper delegate;


    @Override
    public InvoiceDto invoiceToInvoiceDtoWithLink(Invoice invoice) {
        InvoiceDto dto = delegate.invoiceToInvoiceDtoWithLink(invoice);

        dto.setDownloadLink(invoice.getId() + " downloadInvoice");
        dto.setViewLink(invoice.getId() + " viewInvoice");
        return dto;
    }

}
