package com.liaxi.dell.firstresolver;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FirstResolver extends Activity {

    ContentResolver contentResolver;
    Uri uri = Uri.parse("content://org.crazyit.providers.firstprder");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //获取系统的ContentResolver对象
        contentResolver = getContentResolver();

    }
    public void query(View source)
    {
        //调用ContentResolver的query（）方法
        //实际返回的是该Uri对应的ContentProvider的query（）的返回值
        Cursor c = contentResolver.query(uri,null,"query_where",null,null);
        Toast.makeText(this,"远程ContentProvide返回的Cursor为："+c,Toast.LENGTH_LONG).show();
    }
    public void insert(View source)
    {
        ContentValues values = new ContentValues();
        values.put("name","gbAndroid");
        //调用ContentResslver的insert()方法。
        //实际返回的是该Uri对应的ContentProvider的insert（）的返回值
        Uri newUri = contentResolver.insert(uri,values);
        Toast.makeText(this,"远程ContentProvide新插入记录的Uri为："+newUri,Toast.LENGTH_LONG).show();
    }
    public void update(View source)
    {
        ContentValues values = new ContentValues();
        values.put("name","gbAndroid");
        //调用ContentResolver的update()方法。
        //实际返回的是该Uri对应的ContentProvider的update（）的返回值
        int count = contentResolver.update(uri,values,"update_where",null);
        Toast.makeText(this,"远程ContentProvide更新记录数为："+count,Toast.LENGTH_LONG).show();
    }
    public void delete(View source)
    {
        //调用ContentResolver的delete（）方法
        //实际返回的事该Uri对应的ContentProvider的delete()的返回值
        int count = contentResolver.delete(uri,"delete_where",null);
        Toast.makeText(this,"远程ContentProvide删除记录数为："+count,Toast.LENGTH_LONG).show();
    }
}
