package com.example.sample.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;


/**
 * Bank account model class
 */
@Entity(name = "bank_account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@ApiModel(description = "Bank account model")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "getBankAccountsByUserId",
                procedureName = "[dbo].[getBankAccountsByUserId]",
                parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "UserId")})
})
public class BankAccount {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    @ApiModelProperty(notes = "User unique id")
    private Long userId;

    @Column(name = "account_number")
    @ApiModelProperty(notes = "Bank account number")
    private String accountNumber;

    @Column(name = "currency")
    @ApiModelProperty(notes = "Bank account currency")
    private Currency currency;

    @Column(name = "balance")
    @ApiModelProperty(notes = "Bank account balance")
    private Double balance;

    @Column(name = "last_withdrawal")
    @ApiModelProperty(notes = "Bank account last withdrawal time")
    private Date lastWithdrawal;
}
