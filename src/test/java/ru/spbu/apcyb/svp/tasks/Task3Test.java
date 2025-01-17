package ru.spbu.apcyb.svp.tasks;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * Тесты для задания 3.
 */
class Task3Test {
  @Test
  void dirNotExists() {
    boolean thrown = false;

    try {
      FileWriter file = new FileWriter("testfile");
      File dir = new File("skgsvlnsxckmvnxclv").getAbsoluteFile();
      Task3.displayDirectoryContents(dir, file);
    } catch (IOException e) {
      thrown = true;
    }

    assertTrue(thrown);
  }

  @Test
  void fileInInexistingFolder() {
    assertThrows(
        FileNotFoundException.class,
        () -> {
          FileWriter file = new FileWriter("ggsgsgsgsdgssdgs");
          File dir = new File("/afaf/afaf").getAbsoluteFile();
          Task3.displayDirectoryContents(dir, file);
        }
    );
  }

  @Test
  void normalRun() throws IOException {
    FileWriter file = new FileWriter("testfile");
    File dir = new File(".").getAbsoluteFile();
    Task3.displayDirectoryContents(dir, file);
  }

}
