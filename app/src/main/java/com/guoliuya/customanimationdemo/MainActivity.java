package com.guoliuya.customanimationdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import javax.annotation.Resource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static android.R.attr.action;

import com.google.gson.Gson;
import com.guoliuya.customanimationdemo.bean.AnimationBean;
import com.guoliuya.customanimationdemo.view.CommonAnimationView;

public class MainActivity extends AppCompatActivity {
    private CommonAnimationView mCommonAnimationView;
    private File[] files;
    //从自己的服务器上下载下来的动画图片的路径
    private String path = Environment.getExternalStorageDirectory().getPath() + "/guoliuya/gift";
    //"img"+i+".png"
    //一定要跟上传动画图片的ui商量好，图片的命名必须是／img1.png,img2.png,img3.png.........
    //下面会循环用到

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCommonAnimationView = (CommonAnimationView) findViewById(R.id.myView);
        File file = new File(path);
        if(file!=null&&file.listFiles()!=null&&file.listFiles().length>0){
            //添加资源
            setResource();
            //启动动画
            mCommonAnimationView.beginAnimation();
        }else{
            Toast.makeText(this,"请先下载动画图片资源",Toast.LENGTH_SHORT).show();
        }
    }
    private void setResource() {
        Resource resource = getResource(new File(path));
        //        String fromAssets = FileUtil.readFileToString(action.getAnimResDir().getAbsoluteFile() + File.separator + "androidAnimation.json");
        String fromAssets = getFromAssets("androidAnimation.json");
        AnimationBean animationBean = new Gson().fromJson(fromAssets, AnimationBean.class);
        mCommonAnimationView.setBitMap(resource.bitmaps, animationBean,new File(path));
    }

    private Resource getResource(File animationDir) {
        Resource resource = new Resource();
        int length = animationDir.listFiles().length;
        files = new File[length];
        resource.bitmaps = new Bitmap[length];
        for(int i = 0 ;i<length-3;i++){
            files[i] = new File(animationDir.getAbsoluteFile() + File.separator + "img"+i+".png");
            resource.bitmaps[i] = BitmapFactory.decodeFile(files[i].getAbsolutePath());
        }
        return resource;
    }

    public class Resource {
        public Bitmap[] bitmaps;
    }
    public String getFromAssets(String fileName){
        try {
            InputStreamReader inputReader = new InputStreamReader(getAssets().open(fileName) );
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line="";
            String Result="";
            while((line = bufReader.readLine()) != null){
                if(line.trim().equals(""))
                    continue;
                Result += line + "\r\n";
            }
            return Result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
