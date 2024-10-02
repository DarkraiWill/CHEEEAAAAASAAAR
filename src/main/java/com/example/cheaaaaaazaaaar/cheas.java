package com.example.cheaaaaaazaaaar;

import java.io.*;

public class cheas {
    static void encryptFile(String filePath, int shiftKey) {
        try {
            File inputFile = new File(filePath);
            if (!inputFile.exists()) {
                System.out.println("File not found: " + filePath);
                return;
            }

            File outputFile = new File(filePath.replace(".txt", "_encrypted.txt"));
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(encryptText(line, shiftKey));
                writer.newLine();
            }

            reader.close();
            writer.close();
            System.out.println("Encryption complete. Output file: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }

    static void decryptFile(String filePath, int shiftKey) {
        try {
            File inputFile = new File(filePath);
            if (!inputFile.exists()) {
                System.out.println("File not found: " + filePath);
                return;
            }

            File outputFile = new File(filePath.replace(".txt", "_decrypted.txt"));
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(decryptText(line, shiftKey));
                writer.newLine();
            }

            reader.close();
            writer.close();
            System.out.println("Decryption complete. Output file: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }

    private static String encryptText(String text, int shiftKey) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encryptedText.append(shiftChar(c, shiftKey));
        }
        return encryptedText.toString();
    }

    private static String decryptText(String text, int shiftKey) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            decryptedText.append(shiftChar(c, 26 - shiftKey));
        }
        return decryptedText.toString();
    }

    private static char shiftChar(char c, int shift) {
        if (Character.isUpperCase(c)) {
            return Cheazar.UPPERCASE_ALPHABET[(c - 'A' + shift) % 26];
        } else if (Character.isLowerCase(c)) {
            return Cheazar.LOWERCASE_ALPHABET[(c - 'a' + shift) % 26];
        } else {
            return c;
        }
    }

    static int getValidShiftKey(int key) {
        if (key < 1 || key > 25) {
            System.out.println("Invalid shift key. Using default key of 3.");
            return 3;
        }
        return key;
    }

    public class Cheazar{
        private static final char[] UPPERCASE_ALPHABET = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        private static final char[] LOWERCASE_ALPHABET = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    }
}
