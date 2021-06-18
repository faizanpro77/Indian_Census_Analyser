package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_TYPE = "./src/test/resources/IndiaStateCensusData.txt";
    private static final String DELIMITERS_FILE_PATH = "./src/test/resources/DelimiterFile.csv";
    private static final String HEADER_FILE_PATH = "./src/test/resources/HeaderFile.csv";

    private static final String STATE_CODE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.csv";
    private static final String WRONG_STATE_CSV_FILE_PATH = "./src/main/resources/IndiaStateCode.csv";
    private static final String WRONG_STATE_CSV_TYPE = "./src/test/resources/IndiaStateCode.txt";
    private static final String STATE_CODE_DELIMITER = "./src/test/resources/IndiaStateCodeDelimiter.csv";
    private static final String STATE_CODE_HEADER = "./src/test/resources/IndiaStateCodeHeader.csv";

    @Test
    public void givenIndianCensusCSVFile_shouldReturnsMatchesRecords() throws CensusAnalyserException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
        Assert.assertEquals(29, numOfRecords);
    }

    @Test
    public void givenIndiaCensusData_whenWrongFile_ShouldThrowCustomException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WhenWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_TYPE);
        }catch (CensusAnalyserException e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE,e.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WhenDelimiterIncorrect_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(DELIMITERS_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE, e.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WhenHeaderIncorrect_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(HEADER_FILE_PATH);
        } catch (CensusAnalyserException e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE, e.type);
        }
    }

    //UC_2
    @Test
    public void given_IndianStateCodeCSVFile_ReturnsCorrectRecords() throws CensusAnalyserException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int numOfRecords = censusAnalyser.loadIndiaStateCode(STATE_CODE_CSV_FILE_PATH);
        Assert.assertEquals(37, numOfRecords);
    }

    @Test
    public void givenIndiaCensusData_withWrongFile_ShouldThrowException() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.loadIndiaCensusData(WRONG_STATE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndiaStateCodeData_WhenWrongType_ShouldThrowException() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.loadIndiaStateCode(WRONG_STATE_CSV_TYPE);
        } catch (CensusAnalyserException e){
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE, e.type);
        }
    }

    @Test
    public void givenIndiaStateCodeData_WhenDelimiterIncorrect_ShouldThrowException() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.loadIndiaStateCode(STATE_CODE_DELIMITER);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE, e.type);
        }
    }

    @Test
    public void givenIndiaStateCodeData_WhenHeaderIncorrect_ShouldThrowException() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.loadIndiaStateCode(STATE_CODE_HEADER);
        } catch (CensusAnalyserException e){
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE, e.type);
        }
    }
}