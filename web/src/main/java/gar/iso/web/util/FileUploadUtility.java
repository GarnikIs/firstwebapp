package gar.iso.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Gor on 11/26/2017.
 */
public class FileUploadUtility {

//    private static final String ABS_PATH = "G:\\IntellIj\\onlineshopping\\web\\src\\main\\webapp\\assets\\images\\";
    private static final String ABS_PATH = "/var/lib/tomcat8/webapps/web/assets/images/";
    private static String REAL_PATH = "";
    private static final Logger log = LoggerFactory.getLogger(FileUploadUtility.class);

    public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
//        Get the real path
        REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images");
        log.info(REAL_PATH);

//        If directories does not exist, create directory
        if (!new File(ABS_PATH).exists()) {
            new File(ABS_PATH).mkdirs();
        }
        if (!new File(REAL_PATH).exists()) {
            new File(REAL_PATH).mkdirs();
        }

        try {
//            server upload
            file.transferTo(new File(REAL_PATH + code + ".jpg"));
//            project directory upload
            file.transferTo(new File(ABS_PATH + code + ".jpg"));
        } catch(IOException e) {
            e.printStackTrace();

        }
    }
}
