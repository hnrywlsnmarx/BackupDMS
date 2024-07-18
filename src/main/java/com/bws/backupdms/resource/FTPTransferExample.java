/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bws.backupdms.resource;

import java.util.Arrays;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author wilson
 */
public class FTPTransferExample {

    public static void main(String[] args) {
        String sourceHost = "172.28.140.200"; // Ganti dengan alamat host sumber
        String sourceUsername = "dms"; // Ganti dengan nama pengguna sumber
        String sourcePassword = "dms@1906"; // Ganti dengan kata sandi sumber
        int port = 21;
        String sourceFolderPath = "D:/storage_file/indexed/112/2023/03/03"; // Ganti dengan path folder sumber di server FTP
        //" + branch_dir + "/" + year + "/" + month + "/" + yesterday

        String destinationHost = "172.28.97.30"; // Ganti dengan alamat host tujuan
        String destinationUsername = "irfan"; // Ganti dengan nama pengguna tujuan
        int portdest = 21;
        String destinationPassword = "bws@dipo28"; // Ganti dengan kata sandi tujuan
        String destinationFolderPath = "/DMS_Backup/112/2023/03/03"; // Ganti dengan path file tujuan di server FTP

        FTPClient sourceFTP = new FTPClient();
        FTPClient destinationFTP = new FTPClient();

        try {
            // Koneksi ke server sumber
            sourceFTP.connect(sourceHost, port);
            int reply = sourceFTP.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                sourceFTP.disconnect();
                System.err.println("Koneksi ke server sumber gagal.");
                return;
            } else {
                System.out.println("sukses source server");
            }
            sourceFTP.login(sourceUsername, sourcePassword);
            sourceFTP.enterLocalPassiveMode();

            // Koneksi ke server tujuan
            destinationFTP.connect(destinationHost, portdest);
            reply = destinationFTP.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                destinationFTP.disconnect();
                System.err.println("Koneksi ke server tujuan gagal.");
                return;
            } else {
                System.out.println("sukses dest server");
            }
            destinationFTP.login(destinationUsername, destinationPassword);
            destinationFTP.enterLocalPassiveMode();
            System.out.println("tes 1");
            // Mendapatkan daftar file dalam folder sumber
            FTPFile[] files = sourceFTP.listFiles(sourceFolderPath);
//            System.out.println("tes 2 = "+Arrays.toString(files));
            System.out.println("tes 2 = " + sourceFolderPath);

            // Loop untuk mentransfer setiap file dari folder sumber ke folder tujuan (FXP)
            for (FTPFile file : files) {
                System.out.println("tes 3");
                if (file.isFile()) {
                    System.out.println("tes 4");
                    String sourceFilePath = sourceFolderPath + "/" + file.getName();
                    String destinationFilePath = destinationFolderPath + "/" + file.getName();
                    boolean success = sourceFTP.retrieveFile(sourceFilePath, destinationFTP.storeFileStream(destinationFilePath));
                    System.out.println("tes 5");
                    if (success) {
                        System.out.println("File " + file.getName() + " berhasil ditransfer antara dua server FTP.");
                        System.out.println("tes 6");
                    } else {
                        System.err.println("Gagal mentransfer file " + file.getName() + " antara dua server FTP.");
                        System.out.println("tes 7");
                    }
                } else {
                    System.out.println("wtf");
                }
            }

            sourceFTP.logout();
            destinationFTP.logout();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sourceFTP.isConnected()) {
                try {
                    sourceFTP.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (destinationFTP.isConnected()) {
                try {
                    destinationFTP.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
