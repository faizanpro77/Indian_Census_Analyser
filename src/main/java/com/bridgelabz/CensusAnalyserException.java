package com.bridgelabz;

class CensusAnalyserException extends Exception {

    enum ExceptionType {
        UNABLE_TO_PARSE, CENSUS_FILE_PROBLEM, HEADERS_INVALID, NOT_A_CSV_TYPE
    }

    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}