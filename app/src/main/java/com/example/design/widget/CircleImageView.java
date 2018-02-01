package com.example.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.example.design.R;

/**
 * Created by Administrator on 2018/1/30.
 */

public class CircleImageView extends AppCompatImageView {
    private int circleWidth;
    private int circleColor;
    private Paint paint;
    private BitmapShader bitmapShader;
    private int drawable;
    private Bitmap bitmap;
    private boolean shouldInitShader = false;

    public CircleImageView(Context context) {
        this(context, null);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView);
            circleWidth = (int) typedArray.getDimension(R.styleable.CircleImageView_circle_width, 0);
            circleColor = typedArray.getColor(R.styleable.CircleImageView_circle_color, Color.WHITE);
            drawable = typedArray.getResourceId(R.styleable.CircleImageView_android_src, R.drawable.lake);
            setImageResource(drawable);
            typedArray.recycle();
        }
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
    }

    @Override
    public void setImageResource(int resId) {
        drawable = resId;
        bitmap = BitmapFactory.decodeResource(getResources(), resId);
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            shouldInitShader = false;
            initShader();
            invalidate();
        } else {
            shouldInitShader = true;
        }
    }

    private void initShader() {
        Bitmap originBitmap = bitmap;
        int originWidth = originBitmap.getWidth(), originHeight = originBitmap.getHeight();
        float widthRatio = (float) getMeasuredWidth() / originWidth, heightRatio = (float) getMeasuredHeight() / originHeight;
        Matrix matrix = new Matrix();
        matrix.preScale(widthRatio, heightRatio);
        bitmap = Bitmap.createBitmap(originBitmap, 0, 0, originWidth, originHeight, matrix, false);
        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (bitmap == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        int widthSpec = widthMeasureSpec;
        if (widthMode == MeasureSpec.UNSPECIFIED) {
            widthSpec = MeasureSpec.makeMeasureSpec(bitmap.getWidth(), MeasureSpec.EXACTLY);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            widthSpec = MeasureSpec.makeMeasureSpec(Math.min(bitmap.getWidth(), width), MeasureSpec.EXACTLY);
        }

        int heightSpec = heightMeasureSpec;
        if (heightMode == MeasureSpec.UNSPECIFIED) {
            heightSpec = MeasureSpec.makeMeasureSpec(bitmap.getHeight(), MeasureSpec.EXACTLY);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            heightSpec = MeasureSpec.makeMeasureSpec(Math.min(bitmap.getHeight(), height), MeasureSpec.EXACTLY);
        }

        super.onMeasure(widthSpec, heightSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (shouldInitShader) {
            shouldInitShader = false;
            initShader();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (bitmap == null) return;
        canvas.save();
        int centerX = getMeasuredWidth() / 2, centerY = getMeasuredHeight() / 2;
        int radius = Math.min(getMeasuredHeight(), getMeasuredWidth()) / 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(circleWidth);
        paint.setColor(circleColor);
        canvas.drawCircle(centerX, centerY, radius - circleWidth, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setShader(bitmapShader);
        canvas.drawCircle(centerX, centerY, radius - circleWidth, paint);
        paint.setShader(null);
        canvas.restore();
    }
}
