package com.technath.einventory.util;

import org.slf4j.Logger;

import static java.lang.String.join;

public final class LoggingUtil {

    public static final String API_DOMAIN_BASE = "api_domain={} api_name={} api_method={} message={}";
    public static final String INVENTORY = "inventory";
    public static final String SUPPLIER = "supplier";
    public static final String PRODUCT = "product";

    public static final String SALE_DETAILS_API = "Sale Details API";
    public static final String START = "START";
    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";
    public static final String ADD_SUPPLIER = "addSupplier";

    public static String withErrorMessage(String type, Exception e) {
        return withErrorMessage(type, e.getLocalizedMessage());
    }

    public static String withErrorMessage(String type, String s) {
        return join("\"", type, " ", s, "\"");
    }

    public static String log(String loggable) {
        return join("\"", loggable, "\"");
    }


//    public static void logError(String apiName, Throwable e, String transactionId, Logger logger) {
//        logger.error(API_DOMAIN_LOG_VENDOR, log(INVENTORY), log(FRAUDORDERREVIEW), log(PROCESS_EVALUATION),
//                withErrorMessage("Request to ".concat(apiName), e.getLocalizedMessage()), log(transactionId), log(apiName), log(ERROR));
//    }
//
//    public static void logSuccess(String apiName, String transactionId, Logger logger) {
//        logger.info(API_DOMAIN_LOG_VENDOR, log(TNS), log(FRAUDORDERREVIEW), log(PROCESS_EVALUATION),
//                log("Request to ".concat(apiName)), log(transactionId), log(apiName), log(SUCCESS));
//    }
}
