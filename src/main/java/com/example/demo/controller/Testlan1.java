package com.example.demo.controller;

import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.util.*;

public class Testlan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;

        while (check) {
            System.out.print("Nhập chuỗi cần mã hóa: ");
            String inputString = scanner.nextLine();
            byte[] byteArray = Base64.getEncoder().encode(inputString.getBytes());
            String encodedString = new String(byteArray);

            String decodedStringFromBytes = new String(Base64.getDecoder().decode(byteArray));
            String decodedStringFromString = new String(Base64.getDecoder().decode(encodedString));

            System.out.println("Mã hóa thành mảng byte: " + byteArrayToHexString(byteArray));
            System.out.println("Mã hóa thành chuỗi đã được mã hóa: " + encodedString);
            System.out.println("Giải mã từ mảng byte thành chuỗi gốc: " + decodedStringFromBytes);
            System.out.println("Giải mã từ chuỗi đã được mã hóa thành chuỗi gốc: " + decodedStringFromString+"\n");

            System.out.print("Bạn có muốn tiếp tục nhap 1 de tiep tuc 0 ket thuc ? ");
            Integer continueInput = scanner.nextInt();
            if (!continueInput.equals(1)) {
                check = false;
            }
        }

        scanner.close();
    }

    public static String byteArrayToHexString(byte[] byteArray) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : byteArray) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }
}
