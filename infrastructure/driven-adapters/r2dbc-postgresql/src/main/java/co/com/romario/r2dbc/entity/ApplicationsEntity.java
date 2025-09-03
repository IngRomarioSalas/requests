package co.com.romario.r2dbc.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import co.com.romario.model.applications.LoanType;
import co.com.romario.model.applications.StatusRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table("applications")
public class ApplicationsEntity {

    @Id
    private UUID id;

    @Column("document_number")
    private String documentNumber;

    @Column("amount")
    private Double amount;

    @Column("deadline")
    private Integer deadline;

    @Column("loan_type")
    private LoanType loanType;

    @Column("status")
    private StatusRequest status;

}
