package com.BadaBazaar.Exception;

import com.gaian.services_error.error.CommonErrors;
import org.springframework.http.HttpStatus;
import com.gaian.services_error.error.Error;

public class CustomerError extends CommonErrors {

    // 500 Internal server error.
    public static final Error VUE_SERVICE_UNAVAILABLE =
            new Error(HttpStatus.INTERNAL_SERVER_ERROR, 500000, "Unable to process the CUSTOMER.",
                    "Kindly try again after some time or contact the support team ");

    // 404 not found
    public static final Error CUSTOMER_NOT_FOUND = new Error(HttpStatus.NOT_FOUND, 404000,
            "CUSTOMER not found.", "Please create a CUSTOMER first.");

    // 401 Unauthorized
    public static final Error ACCESS_VIOLATION =
            new Error(HttpStatus.UNAUTHORIZED, 401000, "Tenant is not autorized to access the CUSTOMER.",
                    "Please request for read/write or execute access to the CUSTOMER owner.");

    public static final Error AQ_ACCESS_VIOLATION =
            new Error(HttpStatus.UNAUTHORIZED, 401001, "Tenant is not autorized to access the aq.",
                    "Please request for read/write or execute access to the aq owner.");

    public static final Error GROUP_ACCESS_VIOLATION =
            new Error(HttpStatus.UNAUTHORIZED, 401002, "Tenant is not autorized to access the group.",
                    "Please request for read/write or execute access to the group owner.");

    public static final Error TENANT_NOT_FOUND = new Error(HttpStatus.NOT_FOUND, 404000,
            "TenantId not found.", "TenantId must not be null or empty.");

    public static final Error SUBTENANTID_NOT_FOUND = new Error(HttpStatus.NOT_FOUND, 404001,
            "SubTenantId not found.", "SubTenantId must not be null or empty.");

    public static final Error TRANSACTIONID_NOT_FOUND = new Error(HttpStatus.NOT_FOUND, 404002,
            "TransactionId not found.", "TransactionId must not be null or empty.");

    public static final Error INVALID_URL = new Error(HttpStatus.NOT_FOUND, 404003,
            "Url must not be null or empty", "Url must not be null or empty");


    // 400 Bad request
    public static final Error INVALID_PROCESS_DATA = new Error(HttpStatus.BAD_REQUEST, 400000,
            "Process data must be either JSONString or XMLString", "Please validate the process Request");

    public static final Error INVALID_METHOD_FOR_URLBYKEY = new Error(HttpStatus.BAD_REQUEST, 400001,
            "Method must be either POST, GET or OTHER", "Please correct the method value.");
}
