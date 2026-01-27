package java02.group1.productcatalogmanagementsystem.service.implement;

import java02.group1.productcatalogmanagementsystem.dto.request.AccountRequest;
import java02.group1.productcatalogmanagementsystem.dto.request.LoginRequest;
import java02.group1.productcatalogmanagementsystem.dto.response.AccountResponse;

public interface AccountServiceImpl {

    AccountResponse register(AccountRequest request);

    AccountResponse login(LoginRequest request);

    void deleteAccount(long accountId);

    AccountResponse getCurrentAccount();

}
