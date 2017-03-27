package com.guoliuya.customanimationdemo.view;

import java.io.File;
import java.lang.ref.SoftReference;
import java.util.List;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.guoliuya.customanimationdemo.R;
import com.guoliuya.customanimationdemo.bean.AnimationBean;


/**
 * Created by guoliuya on 16/7/19.
 * 分开执行，所有动画按照时间顺序执行
 */
public class CommonAnimationView extends FrameLayout {
    private Bitmap[] mBitmap;
    private ImageView[] mImageView;
    private AnimationBean animationBean;
    private File file;
    private FrameLayout mParentView;
    private boolean runOneTime;
    private MyHandler mHandler;

    protected static class MyHandler extends Handler {
        private SoftReference<CommonAnimationView> softReference;

        public MyHandler(CommonAnimationView allChannelGiftAnimation) {
            softReference = new SoftReference<CommonAnimationView>(allChannelGiftAnimation);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            final CommonAnimationView allChannelGiftAnimation = softReference.get();
            if (allChannelGiftAnimation == null) {
                return;
            }
            switch (msg.what) {

            }

        }
    }

    public CommonAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CommonAnimationView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        mHandler = new MyHandler(this);
        mParentView = (FrameLayout) LayoutInflater.from(context)
                .inflate(R.layout.custom_parent_view, null);
        addView(mParentView);
    }

    public void setBitMap(Bitmap[] resource, AnimationBean animationBean, File file) {
        this.mBitmap = resource;
        this.animationBean = animationBean;
        this.file = file;
        mImageView = new ImageView[resource.length];
        for (int i = 0; i < resource.length; i++) {
            mImageView[i] = new ImageView(getContext());
            mParentView.addView(mImageView[i]);
            mImageView[i].setVisibility(View.INVISIBLE);
            //            mImageView[i].setImageBitmap(resource.bitmaps[i]);
        }
    }

    public void beginAnimation() {
        List<AnimationBean.DataEntity> data = animationBean.getData();
        for (int i = 0; i < data.size(); i++) {
            String absolutePath = file.listFiles()[i + 3].getAbsolutePath();
            String imageName = data.get(i).getImageName();
            if (file.listFiles()[i + 3].getAbsolutePath().contains(data.get(i).getImageName())) {
                List<AnimationBean.DataEntity.AnimationEntity> animation = data.get(i).getAnimation();
                int width = percentConvertPx(data.get(i).getWidth());
                int height = percentConvertPy(data.get(i).getHeight());
                //                mImageView[i].setVisibility(View.GONE);
                //设置每张图片的初始位置
                for (int j = 0; j < animation.size(); j++) {
                    if (animation.get(j).getAnimType().equals("translate")) {
                        int startTranslateX = percentConvertPx(animation.get(j).getStartTranslateX());
                        int startTranslateY = percentConvertPy(animation.get(j).getStartTranslateY());
                        int endTranslateX = percentConvertPx(animation.get(j).getEndTranslateX());
                        int endTranslateY = percentConvertPy(animation.get(j).getEndTranslateY());
                        int duration = animation.get(j).getDuration();
                        int startTime = animation.get(j).getStartAnimationTime();
                        double pivotX = animation.get(j).getPivotX();
                        double pivotY = animation.get(j).getPivotY();
                        postDelayed(
                                new myTranslateThread(data.get(i).getLocationX(), data.get(i).getLocationY(),
                                        startTranslateX, startTranslateY, endTranslateX, endTranslateY,
                                        mImageView[i], duration, mBitmap[i], width, height, (float) pivotX,
                                        (float) pivotY), startTime);
                    } else if (animation.get(j).getAnimType().equals("scale")) {
                        double startScaleS = animation.get(j).getStartScaleS();
                        double endScaleS = animation.get(j).getEndScaleS();
                        double startScaleSy = animation.get(j).getStartScaleSy();
                        double endScaleSy = animation.get(j).getEndScaleSy();
                        int duration = animation.get(j).getDuration();
                        int startTime = animation.get(j).getStartAnimationTime();
                        double pivotX = animation.get(j).getPivotX();
                        double pivotY = animation.get(j).getPivotY();
                        postDelayed(new myScaleThread(data.get(i).getLocationX(), data.get(i).getLocationY(),
                                startScaleS, endScaleS, startScaleSy, endScaleSy, mImageView[i], duration,
                                mBitmap[i], width, height, (float) pivotX, (float) pivotY), startTime);
                    } else if (animation.get(j).getAnimType().equals("alpha")) {
                        double startAlphaA = animation.get(j).getStartAlphaA();
                        double endAlphaA = animation.get(j).getEndAlphaA();
                        int duration = animation.get(j).getDuration();
                        int startTime = animation.get(j).getStartAnimationTime();
                        double pivotX = animation.get(j).getPivotX();
                        double pivotY = animation.get(j).getPivotY();
                        postDelayed(new myAlphaThread(data.get(i).getLocationX(), data.get(i).getLocationY(),
                                        startAlphaA, endAlphaA, mImageView[i], duration, mBitmap[i], width, height,
                                        (float) pivotX, (float) pivotY),
                                startTime);
                    } else if (animation.get(j).getAnimType().equals("rotation")) {
                        double startRotationX = animation.get(j).getStartRotationX();
                        double startRotationY = animation.get(j).getStartRotationY();
                        double endRotationX = animation.get(j).getEndRotationX();
                        double endRotationY = animation.get(j).getEndRotatioonY();
                        int duration = animation.get(j).getDuration();
                        int startTime = animation.get(j).getStartAnimationTime();
                        double pivotX = animation.get(j).getPivotX();
                        double pivotY = animation.get(j).getPivotY();
                        postDelayed(
                                new myRotationThread(data.get(i).getLocationX(), data.get(i).getLocationY(),
                                        startRotationX, endRotationX, startRotationY, endRotationY,
                                        mImageView[i], duration, mBitmap[i], width, height, (float) pivotX,
                                        (float) pivotY), startTime);
                    } else if (animation.get(j).getAnimType().equals("frame")) {
                        int duration = animation.get(j).getDuration();
                        int startTime = animation.get(j).getStartAnimationTime();
                        double pivotX = animation.get(j).getPivotX();
                        double pivotY = animation.get(j).getPivotY();
                        postDelayed(new myFrameThread(data.get(i).getLocationX(), data.get(i).getLocationY(),
                                mImageView[i], duration, mBitmap, mBitmap[i], width, height, (float) pivotX,
                                (float) pivotY), startTime);
                    }
                }
            }
        }
    }

    private void translate(int startX, int startY, int endX, int endY, ImageView target, int duration) {
        target.setVisibility(View.VISIBLE);
        PropertyValuesHolder xValue = PropertyValuesHolder.ofFloat("x", startX, endX);
        PropertyValuesHolder yValue = PropertyValuesHolder.ofFloat("y", startY, endY);
        ObjectAnimator anim = ObjectAnimator
                .ofPropertyValuesHolder(target, xValue, yValue);
        anim.setDuration(duration);
        anim.start();
    }

    private void alpha(float alpha1, float alpha2, ImageView target, int duration) {
        target.setVisibility(View.VISIBLE);
        PropertyValuesHolder alphaValue = PropertyValuesHolder.ofFloat("alpha", alpha1, alpha2);

        ObjectAnimator anim = ObjectAnimator
                .ofPropertyValuesHolder(target, alphaValue);
        anim.setDuration(duration);
        anim.start();
    }

    private void scale(float startX, float endX, float startY, float endY, ImageView target, int duration) {
        target.setVisibility(View.VISIBLE);
        PropertyValuesHolder scaleXValue = PropertyValuesHolder.ofFloat("scaleX", startX, endX);
        PropertyValuesHolder scaleYValue = PropertyValuesHolder.ofFloat("scaleY", startY, endY);
        ObjectAnimator anim = ObjectAnimator
                .ofPropertyValuesHolder(target, scaleXValue, scaleYValue);
        anim.setDuration(duration);
        anim.start();
    }

    private void rotation(float startX, float endX, float startY, float endY, ImageView target,
            int duration) {
        target.setVisibility(View.VISIBLE);
        PropertyValuesHolder scaleXValue = PropertyValuesHolder.ofFloat("rotationX", startX, endX);
        PropertyValuesHolder scaleYValue = PropertyValuesHolder.ofFloat("rotationY", startY, endY);
        ObjectAnimator anim = ObjectAnimator
                .ofPropertyValuesHolder(target, scaleXValue, scaleYValue);
        anim.setDuration(duration);
        anim.start();
    }

    private void frame(ImageView target, int duration, Bitmap[] bitmap) {
        target.setVisibility(View.VISIBLE);
        AnimationDrawable animaton = new AnimationDrawable();
        for (int i = 0; i < bitmap.length; i++) {
            Drawable drawable = new BitmapDrawable(bitmap[i]);
            animaton.addFrame(drawable, duration / bitmap.length);
        }
        target.setImageDrawable(animaton);
        animaton.start();
    }

    private class myTranslateThread implements Runnable {
        private int mStartX;
        private int mStartY;
        private int mEndX;
        private int mEndY;
        private ImageView mTarget;
        private int mDuration;
        private int mLocationX;
        private int mLocationY;
        private Bitmap mBitmap;
        private int mWidth;
        private int mHeight;
        private float mPivotX;
        private float mPivotY;

        public myTranslateThread(int locationX, int locationY, int startX, int startY, int endX, int endY,
                ImageView target, int duration, Bitmap bitmap, int width, int height, float pivotX,
                float pivotY) {
            this.mStartX = startX;
            this.mStartY = startY;
            this.mEndX = endX;
            this.mEndY = endY;
            this.mTarget = target;
            this.mDuration = duration;
            this.mLocationX = locationX;
            this.mLocationY = locationY;
            this.mBitmap = bitmap;
            this.mWidth = width;
            this.mHeight = height;
            this.mPivotX = pivotX;
            this.mPivotY = pivotY;
        }

        @Override
        public void run() {
            //同时执行每一种动画
            translate(mStartX, mStartY, mEndX, mEndY, mTarget, mDuration);
            setImageLocation(mLocationX, mLocationY, mTarget, mBitmap, mWidth, mHeight, mPivotX, mPivotY);
        }
    }

    private class myScaleThread implements Runnable {
        private float mStartX;
        private float mStartY;
        private float mEndX;
        private float mEndY;
        private ImageView mTarget;
        private int mDuration;
        private int mLocationX;
        private int mLocationY;
        private Bitmap mBitmap;
        private int mWidth;
        private int mHeight;
        private float mPivotX;
        private float mPivotY;

        public myScaleThread(int locationX, int locationY, double startX, double endX, double startY,
                double endY, ImageView target, int duration, Bitmap bitmap, int width, int height,
                float pivotX, float pivotY) {
            this.mStartX = (float) startX;
            this.mStartY = (float) startY;
            this.mEndX = (float) endX;
            this.mEndY = (float) endY;
            this.mTarget = target;
            this.mDuration = duration;
            this.mLocationX = locationX;
            this.mLocationY = locationY;
            this.mBitmap = bitmap;
            this.mWidth = width;
            this.mHeight = height;
            this.mPivotX = pivotX;
            this.mPivotY = pivotY;
        }

        @Override
        public void run() {
            //同时执行每一种动画
            scale(mStartX, mEndX, mStartY, mEndY, mTarget, mDuration);
            setImageLocation(mLocationX, mLocationY, mTarget, mBitmap, mWidth, mHeight, mPivotX, mPivotY);
        }
    }

    private class myAlphaThread implements Runnable {
        private float mAlpha1;
        private float mAlpha2;
        private ImageView mTarget;
        private int mDuration;
        private int mLocationX;
        private int mLocationY;
        private Bitmap mBitmap;
        private int mWidth;
        private int mHeight;
        private float mPivotX;
        private float mPivotY;

        public myAlphaThread(int locationX, int locationY, double alpha1, double alpha2, ImageView target,
                int duration, Bitmap bitmap, int width, int height, float pivotX, float pivotY) {
            this.mAlpha1 = (float) alpha1;
            this.mAlpha2 = (float) alpha2;
            this.mTarget = target;
            this.mDuration = duration;
            this.mLocationX = locationX;
            this.mLocationY = locationY;
            this.mBitmap = bitmap;
            this.mWidth = width;
            this.mHeight = height;
            this.mPivotX = pivotX;
            this.mPivotY = pivotY;
        }

        @Override
        public void run() {
            //同时执行每一种动画
            alpha(mAlpha1, mAlpha2, mTarget, mDuration);
            setImageLocation(mLocationX, mLocationY, mTarget, mBitmap, mWidth, mHeight, mPivotX, mPivotY);
        }
    }

    private class myRotationThread implements Runnable {
        private float mStartX;
        private float mEndX;
        private float mStartY;
        private float mEndY;
        private ImageView mTarget;
        private int mDuration;
        private int mLocationX;
        private int mLocationY;
        private Bitmap mBitmap;
        private int mWidth;
        private int mHeight;
        private float mPivotX;
        private float mPivotY;

        public myRotationThread(int locationX, int locationY, double startX, double endX, double startY,
                double endY, ImageView target, int duration, Bitmap bitmap, int width, int height,
                float pivotX, float pivotY) {
            this.mStartX = (float) startX;
            this.mEndX = (float) endX;
            this.mStartY = (float) startY;
            this.mEndY = (float) endY;
            this.mTarget = target;
            this.mDuration = duration;
            this.mLocationX = locationX;
            this.mLocationY = locationY;
            this.mBitmap = bitmap;
            this.mWidth = width;
            this.mHeight = height;
            this.mPivotX = pivotX;
            this.mPivotY = pivotY;
        }

        @Override
        public void run() {
            //同时执行每一种动画
            rotation(mStartX, mEndX, mStartY, mEndY, mTarget, mDuration);
            setImageLocation(mLocationX, mLocationY, mTarget, mBitmap, mWidth, mHeight, mPivotX, mPivotY);
        }
    }

    private class myFrameThread implements Runnable {
        private ImageView mTarget;
        private int mDuration;
        private Bitmap[] mBitmaps;
        private int mLocationX;
        private int mLocationY;
        private Bitmap mBitmap;
        private int mWidth;
        private int mHeight;
        private float mPivotX;
        private float mPivotY;

        public myFrameThread(int locationX, int locationY, ImageView target, int duration, Bitmap[] bitmaps,
                Bitmap bitmap, int width, int height, float pivotX, float pivotY) {
            this.mTarget = target;
            this.mDuration = duration;
            this.mBitmaps = bitmaps;
            this.mLocationX = locationX;
            this.mLocationY = locationY;
            this.mBitmap = bitmap;
            this.mWidth = width;
            this.mHeight = height;
            this.mPivotX = pivotX;
            this.mPivotY = pivotY;
        }

        @Override
        public void run() {
            //同时执行每一种动画
            frame(mTarget, mDuration, mBitmaps);
            setImageLocation(mLocationX, mLocationY, mTarget, mBitmap, mWidth, mHeight, mPivotX, mPivotY);
        }
    }

    private void setImageLocation(int x, int y, ImageView v, Bitmap bitmap, int width, int height,
            float pivotX, float pivotY) {
        //x距离左边的距离百分比
        //y距离上边的距离百分比
        float finalX = ViewUtil.getScreenWidth(getContext()) * x / 100;
        float finalY = ViewUtil.getScreenHeight(getContext()) * y / 100;
        LayoutParams layoutParams = (LayoutParams) v.getLayoutParams();
        layoutParams.topMargin = (int) finalY;
        layoutParams.leftMargin = (int) finalX;
        layoutParams.height = height;
        layoutParams.width = width;
        v.setPivotX(pivotX);
        v.setPivotY(pivotY);
        v.invalidate();
        v.setImageBitmap(bitmap);
    }

    private int percentConvertPx(int x) {
        float finalX = ViewUtil.getScreenWidth(getContext()) * x / 100;
        return (int) finalX;
    }

    private int percentConvertPy(int y) {
        float finalY = ViewUtil.getScreenHeight(getContext()) * y / 100;
        return (int) finalY;
    }

    public void clearView() {
        mParentView.removeAllViews();
    }
}
