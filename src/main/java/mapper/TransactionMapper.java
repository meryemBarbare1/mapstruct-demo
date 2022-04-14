package mapper;

import dto.TransactionDto;
import entity.Transaction;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Mapper
public abstract class TransactionMapper {

    public TransactionDto toTransactionDTO(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setUuid(transaction.getUuid());
        transactionDto.setTotalInCents(transaction.getTotal()
                .multiply(new BigDecimal("100")).longValue());
        return transactionDto;
    }

    public abstract List<TransactionDto> toTransactionDTO(
            Collection<Transaction> transactions);
}
