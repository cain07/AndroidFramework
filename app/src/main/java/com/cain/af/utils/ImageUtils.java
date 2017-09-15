package com.cain.af.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by mac on 17/8/2.
 */

public class ImageUtils {

    /**
     * 得到图片字节流 数组大小   输入流转化为比特流
     * @param inStream s
     * @return s
     * @throws Exception s
     */
    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }
}
