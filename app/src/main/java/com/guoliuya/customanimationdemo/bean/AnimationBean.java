package com.guoliuya.customanimationdemo.bean;

import java.util.List;

/**
 * Created by guoliuya on 16/7/25.
 */
public class AnimationBean {

    /**
     * imageName : img0
     * width : 400
     * height : 300
     * locationX : -10
     * locationY : 50
     * animation : [{"animType":"translate","pivotX":1,"pivotY":0.5,"time":3,"order":3,"StartAnimationTime":1,"duration":2000,"imageNum":40,"startTranslateX":-10,"endTranslateX":20,"startTranslateY":50,"endTranslateY":50,"startScaleS":1,"endScaleS":2,"startScaleSy":1,"endScaleSy":2,"startAlphaA":1,"endAlphaA":0.5,"startRotationX":1,"endRotationX":0.5,"startRotationY":0.5,"endRotatioonY":-1},{"animType":"translate","pivotX":1,"pivotY":0.5,"time":3,"order":3,"StartAnimationTime":2000,"duration":3000,"imageNum":40,"startTranslateX":20,"endTranslateX":25,"startTranslateY":50,"endTranslateY":50,"startScaleS":1,"endScaleS":2,"startScaleSy":1,"endScaleSy":2,"startAlphaA":1,"endAlphaA":0.5,"startRotationX":1,"endRotationX":0.5,"startRotationY":0.5,"endRotatioonY":-1},{"animType":"rotation","pivotX":1,"pivotY":0.5,"time":3,"order":3,"StartAnimationTime":2000,"duration":3000,"imageNum":40,"startTranslateX":50,"endTranslateX":60,"startTranslateY":50,"endTranslateY":50,"startScaleS":1,"endScaleS":2,"startScaleSy":1,"endScaleSy":2,"startAlphaA":1,"endAlphaA":0.5,"startRotationX":10,"endRotationX":1,"startRotationY":1,"endRotatioonY":1},{"animType":"translate","pivotX":1,"pivotY":0.5,"time":3,"order":3,"StartAnimationTime":5000,"duration":1000,"imageNum":40,"startTranslateX":25,"endTranslateX":70,"startTranslateY":50,"endTranslateY":50,"startScaleS":1,"endScaleS":2,"startScaleSy":1,"endScaleSy":2,"startAlphaA":1,"endAlphaA":0.5,"startRotationX":1,"endRotationX":0.5,"startRotationY":0.5,"endRotatioonY":-1}]
     */

    private List<DataEntity> data;

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        private String imageName;
        private int width;
        private int height;
        private int locationX;
        private int locationY;
        /**
         * animType : translate
         * pivotX : 1.0
         * pivotY : 0.5
         * time : 3
         * order : 3
         * StartAnimationTime : 1
         * duration : 2000
         * imageNum : 40
         * startTranslateX : -10
         * endTranslateX : 20
         * startTranslateY : 50
         * endTranslateY : 50
         * startScaleS : 1.0
         * endScaleS : 2.0
         * startScaleSy : 1.0
         * endScaleSy : 2.0
         * startAlphaA : 1.0
         * endAlphaA : 0.5
         * startRotationX : 1.0
         * endRotationX : 0.5
         * startRotationY : 0.5
         * endRotatioonY : -1.0
         */

        private List<AnimationEntity> animation;

        public String getImageName() {
            return imageName;
        }

        public void setImageName(String imageName) {
            this.imageName = imageName;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getLocationX() {
            return locationX;
        }

        public void setLocationX(int locationX) {
            this.locationX = locationX;
        }

        public int getLocationY() {
            return locationY;
        }

        public void setLocationY(int locationY) {
            this.locationY = locationY;
        }

        public List<AnimationEntity> getAnimation() {
            return animation;
        }

        public void setAnimation(List<AnimationEntity> animation) {
            this.animation = animation;
        }

        public static class AnimationEntity {
            private String animType;
            private double pivotX;
            private double pivotY;
            private int time;
            private int order;
            private int StartAnimationTime;
            private int duration;
            private int imageNum;
            private int startTranslateX;
            private int endTranslateX;
            private int startTranslateY;
            private int endTranslateY;
            private double startScaleS;
            private double endScaleS;
            private double startScaleSy;
            private double endScaleSy;
            private double startAlphaA;
            private double endAlphaA;
            private double startRotationX;
            private double endRotationX;
            private double startRotationY;
            private double endRotatioonY;

            public String getAnimType() {
                return animType;
            }

            public void setAnimType(String animType) {
                this.animType = animType;
            }

            public double getPivotX() {
                return pivotX;
            }

            public void setPivotX(double pivotX) {
                this.pivotX = pivotX;
            }

            public double getPivotY() {
                return pivotY;
            }

            public void setPivotY(double pivotY) {
                this.pivotY = pivotY;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getStartAnimationTime() {
                return StartAnimationTime;
            }

            public void setStartAnimationTime(int StartAnimationTime) {
                this.StartAnimationTime = StartAnimationTime;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public int getImageNum() {
                return imageNum;
            }

            public void setImageNum(int imageNum) {
                this.imageNum = imageNum;
            }

            public int getStartTranslateX() {
                return startTranslateX;
            }

            public void setStartTranslateX(int startTranslateX) {
                this.startTranslateX = startTranslateX;
            }

            public int getEndTranslateX() {
                return endTranslateX;
            }

            public void setEndTranslateX(int endTranslateX) {
                this.endTranslateX = endTranslateX;
            }

            public int getStartTranslateY() {
                return startTranslateY;
            }

            public void setStartTranslateY(int startTranslateY) {
                this.startTranslateY = startTranslateY;
            }

            public int getEndTranslateY() {
                return endTranslateY;
            }

            public void setEndTranslateY(int endTranslateY) {
                this.endTranslateY = endTranslateY;
            }

            public double getStartScaleS() {
                return startScaleS;
            }

            public void setStartScaleS(double startScaleS) {
                this.startScaleS = startScaleS;
            }

            public double getEndScaleS() {
                return endScaleS;
            }

            public void setEndScaleS(double endScaleS) {
                this.endScaleS = endScaleS;
            }

            public double getStartScaleSy() {
                return startScaleSy;
            }

            public void setStartScaleSy(double startScaleSy) {
                this.startScaleSy = startScaleSy;
            }

            public double getEndScaleSy() {
                return endScaleSy;
            }

            public void setEndScaleSy(double endScaleSy) {
                this.endScaleSy = endScaleSy;
            }

            public double getStartAlphaA() {
                return startAlphaA;
            }

            public void setStartAlphaA(double startAlphaA) {
                this.startAlphaA = startAlphaA;
            }

            public double getEndAlphaA() {
                return endAlphaA;
            }

            public void setEndAlphaA(double endAlphaA) {
                this.endAlphaA = endAlphaA;
            }

            public double getStartRotationX() {
                return startRotationX;
            }

            public void setStartRotationX(double startRotationX) {
                this.startRotationX = startRotationX;
            }

            public double getEndRotationX() {
                return endRotationX;
            }

            public void setEndRotationX(double endRotationX) {
                this.endRotationX = endRotationX;
            }

            public double getStartRotationY() {
                return startRotationY;
            }

            public void setStartRotationY(double startRotationY) {
                this.startRotationY = startRotationY;
            }

            public double getEndRotatioonY() {
                return endRotatioonY;
            }

            public void setEndRotatioonY(double endRotatioonY) {
                this.endRotatioonY = endRotatioonY;
            }
        }
    }
}
