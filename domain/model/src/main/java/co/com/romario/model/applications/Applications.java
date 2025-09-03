package co.com.romario.model.applications;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Applications {
    private UUID id;
    private String documentNumber;
    private Double amount;
    private Integer deadline;
    private LoanType loanType;
    private StatusRequest status;
}
