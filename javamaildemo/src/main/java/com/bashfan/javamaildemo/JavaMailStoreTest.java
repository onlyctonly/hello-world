package com.bashfan.javamaildemo;




import org.apache.commons.lang.StringUtils;

import javax.mail.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JavaMailStoreTest {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.host", "smtp.exmail.qq.com");

        Session session = Session.getDefaultInstance(properties);

        Store store = session.getStore("imap");
        store.connect("imap.exmail.qq.com","info@cgw.gr","password");

        Folder folder = store.getFolder("其他文件夹/新民传版");
        folder.open(Folder.READ_ONLY);
        Message[] messages = folder.getMessages();

        Message messages1 = messages[0];

        Multipart multipart = (Multipart) messages1.getContent();
        List<File> attachments = new ArrayList<File>();

        for (int i = 0; i < multipart.getCount(); i++) {
            BodyPart bodyPart = multipart.getBodyPart(i);
            if(!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition()) &&
                    StringUtils.isBlank(bodyPart.getFileName())) {
                continue; // dealing with attachments only
            }
            InputStream is = bodyPart.getInputStream();
            File f = new File(bodyPart.getFileName());
            FileOutputStream fos = new FileOutputStream(f);
            byte[] buf = new byte[4096];
            int bytesRead;
            while((bytesRead = is.read(buf))!=-1) {
                fos.write(buf, 0, bytesRead);
            }
            fos.close();
            attachments.add(f);
        }


        folder.close();

//        Folder[] folders = store.getDefaultFolder().list();
//        for (Folder folder : folders) {
//            System.out.println(folder.getFullName());
//        }
        store.close();
    }


}
