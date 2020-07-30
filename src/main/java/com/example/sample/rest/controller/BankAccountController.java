package com.example.sample.rest.controller;

import com.example.sample.config.SwaggerConfig;
import com.example.sample.model.BankAccount;
import com.example.sample.service.ApiEndpoints;
import com.example.sample.service.BankAccountService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Provides methods for
 * - user bank accounts
 * - etc...
 */
@Api(value = "Account Controller")
@RestController
public class BankAccountController {

    private final BankAccountService accountService;

    @Autowired
    public BankAccountController(BankAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Endpoint to retrieve all user's bank accounts from database
     *
     * @param userId - target user id
     * @return bank accounts list
     */
    @ApiOperation(value = "${BankAccountController.getAllAccountsByUserId.value}",
            response = BankAccount.class,
            responseContainer = "List",
            notes = "${BankAccountController.getAllAccountsByUserId.notes}",
            authorizations = {@Authorization(value = SwaggerConfig.TOKEN_TYPE)})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @ApiImplicitParams(
            @ApiImplicitParam(name = "userId",
                    value = "${BankAccountController.getAllAccountsByUserId.userId}",
                    required = true, dataType = "String")
    )
    @ResponseBody
    @GetMapping(ApiEndpoints.accounts)
    public List<BankAccount> getAllAccountsByUserId(@RequestParam long userId) {
        return accountService.findByUserId(userId);
    }
}
