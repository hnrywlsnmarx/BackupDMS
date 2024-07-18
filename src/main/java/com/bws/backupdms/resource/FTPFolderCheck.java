/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bws.backupdms.resource;

/**
 *
 * @author wilson
 */
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;

public class FTPFolderCheck {

    public static void main(String[] args) {
        String server = "172.28.97.30";
        int port = 21;
        String username = "irfan";
        String password = "bws@dipo28";
//        String remoteDirectory = "/DMS_Backup/to/remote/folder"; // Ganti dengan path folder remote yang ingin Anda periksa
        String remoteDirectory = "/DMS_Backup/to/remote/folder"; // Ganti dengan path folder remote yang ingin Anda periksa

        FTPClient ftpClient = new FTPClient();

        try {
            ftpClient.connect(server, port);
            boolean loginSuccess = ftpClient.login(username, password);

            if (loginSuccess) {
                // Periksa apakah direktori tersedia
                boolean directoryExists = ftpClient.changeWorkingDirectory(remoteDirectory);

                if (directoryExists) {
                    System.out.println("Direktori tersedia.");
                } else {
                    System.out.println("Direktori tidak tersedia.");
                }

                ftpClient.logout();
            } else {
                System.out.println("Gagal login ke server FTP.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
