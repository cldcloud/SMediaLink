package com.acukanov.sml.utils;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.Fragment;

public class PermissionsUtils {

    @TargetApi(Build.VERSION_CODES.M)
    public static void requestPermissionsSafely(Activity activity, Fragment fragment, String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (fragment != null) {
                fragment.requestPermissions(permissions, requestCode);
            } else {
                activity.requestPermissions(permissions, requestCode);
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public static boolean hasPermission(Activity activity, String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                activity.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }
}
