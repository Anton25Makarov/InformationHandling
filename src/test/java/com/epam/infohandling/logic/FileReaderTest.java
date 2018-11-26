package com.epam.infohandling.logic;

import com.epam.infohandling.exception.ReadFileException;
import org.junit.Assert;
import org.junit.Test;

public class FileReaderTest {
    private static final String FILE_PATH = "src/test/resources/test.txt";
    private static final String NOT_EXISTING_FILE_PATH = "src/test/resources/testNotExist.txt";
    private static final String EXPECTED_STRING = "On no twenty spring of in esteem spirit likely estate. " +
            "Continue new you declared differed learning bringing honoured. " +
            "At mean mind so upon they rent am walk. " +
            "Shortly am waiting inhabit smiling he chiefly of in. " +
            "Lain tore time gone him his dear sure. " +
            "Fat decisively estimating affronting assistance not. " +
            "Resolve pursuit regular so calling me. " +
            "West he plan girl been my then up no.";

    private FileReader fileReader = new FileReader();

    @Test
    public void shouldReadDataFromFileToString() throws ReadFileException {
        // given

        // when
        String actualString = fileReader.readFile(FILE_PATH);

        // then
        Assert.assertEquals(actualString, EXPECTED_STRING);
    }

    @Test(expected = ReadFileException.class)
    public void shouldThrowReadFileExceptionWhenFileIsNotExist() throws ReadFileException {
        String actualString = fileReader.readFile(NOT_EXISTING_FILE_PATH);
    }
}