package com.liaxi.dell.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by dell on 2017/5/2.
 */

public class FirstProvider extends ContentProvider {
    //第一次创建该ContentProvider时调用该方法
    @Override
    public boolean onCreate() {
        System.out.println("===OnCreate方法被调用===");
        return true;
    }

    @Nullable
    @Override
    //实现查询方法，该方法返回查询得到的Cursor
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String where, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
       System.out.println(uri+"===query方法被调用===");
        System.out.println("where参数为："+where);
        return null;
    }

    @Nullable
    @Override
    //该方法的返回值代表了该ContentProvider所提供的MIME类型
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    //实现插入的方法，该方法应该返回新插入的记录的Uri
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        System.out.println(uri+"===insert方法被调用了===");
        System.out.println("values参数为："+values);
        return null;
    }

    @Override
    //实现删除方法，该方法应该返回被删除的记录条数
    public int delete(@NonNull Uri uri, @Nullable String where, @Nullable String[] selectionArgs) {
        System.out.println(uri + "===delste方法被调用===");
        System.out.println("where参数为：" + where);
        return 0;
    }

    @Override
    //实现删除方法，该方法应该返回被更新的记录条数
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String where, @Nullable String[] selectionArgs) {
        System.out.println(uri + "===update方法被调用===");
        System.out.println("where参数为：" + where +",Valuse参数为：" + values);
        return 0;
    }
}
