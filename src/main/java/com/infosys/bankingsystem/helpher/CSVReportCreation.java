package com.infosys.bankingsystem.helpher;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;

public class CSVReportCreation {

    public static void twoacount(Integer fac, Integer toacc, double amt,
                                 Double balance, String dw, String status) {

        String fileName = "BankReport.csv";

        try {
            boolean exists = new File(fileName).exists();
            PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));

            if (!exists) {
                pw.println("Date & Time,Account,Type,Amount,Balance,Status");
            }

            String dt = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

            String account;
            String type;

            if (toacc != null && dw == null) {
                account = fac + "->" + toacc;
                type = "Transfer";
            } else {
                account = String.valueOf(fac);
                type = dw;
            }

            pw.println(dt + "," + account + "," + type + "," + amt + "," + balance + "," + status);
            pw.close();

            System.out.println("Transaction added to BankReport.csv");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
