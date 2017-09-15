package com.cain.af.utils;

import android.Manifest;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;


import com.cain.af.MainApp;
import com.cain.af.config.SPConstants;

import java.io.File;

/**
 * Created by mac on 17/8/21.
 */

public class SDCardUtils {

    private SDCardUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 判断SDCard是否可用
     *
     * @return
     */
    public static boolean isSDCardEnable() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);

    }

    /**
     * 获取SD卡路径
     *
     * @return
     */
    public static String getSDCardPath()
    {
        return Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator;
    }

    protected static String[] needPermissions = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    public static String getDbPath(){
        String path = "asmg.db";
        boolean cp = MPermissionUtils.checkPermissions(MainApp.getInstance(),needPermissions);
        if (SPUtils.getBoolean(SPConstants.REQUEST_PERMISSIONS_SD,false) && cp){
            return getSDCardDb();
        }
        LogUtils.e("db path ->"+path);
        return path;
    }

    public static String getSDCardDb(){
        String DATA_PATH = SDCardUtils.getSDCardPath() + "/asmg/data/" + "asmg.db";
        File f_ = new File(DATA_PATH);
        if (!f_.getParentFile().exists()) {
            Log.e("DBService", "文件夹不存在，新建一个");
            f_.getParentFile().mkdirs();
        }
        return DATA_PATH;
    }

    /**
     * 获取SD卡的剩余容量 单位byte
     *
     * @return
     */
    public static long getSDCardAllSize() {
        if (isSDCardEnable()) {
            StatFs stat = new StatFs(getSDCardPath());
            // 获取空闲的数据块的数量
            long availableBlocks = (long) stat.getAvailableBlocks() - 4;
            // 获取单个数据块的大小（byte）
            long freeBlocks = stat.getAvailableBlocks();
            return freeBlocks * availableBlocks;
        }
        return 0;
    }

    /**
     * 获取指定路径所在空间的剩余可用容量字节数，单位byte
     *
     * @param filePath
     * @return 容量字节 SDCard可用空间，内部存储可用空间
     */
    public static long getFreeBytes(String filePath) {
        // 如果是sd卡的下的路径，则获取sd卡可用容量
        if (filePath.startsWith(getSDCardPath())) {
            filePath = getSDCardPath();
        } else {// 如果是内部存储的路径，则获取内存存储的可用容量
            filePath = Environment.getDataDirectory().getAbsolutePath();
        }
        StatFs stat = new StatFs(filePath);
        long availableBlocks = (long) stat.getAvailableBlocks() - 4;
        return stat.getBlockSize() * availableBlocks;
    }

    /**
     * 获取系统存储路径
     *
     * @return
     */
    public static String getRootDirectoryPath() {
        return Environment.getRootDirectory().getAbsolutePath();
    }

}
