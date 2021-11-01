package Decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestDecorator {


    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("input.json");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
    }
}
