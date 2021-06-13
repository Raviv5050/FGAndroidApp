package com.example.flightgearandroidapp.views;

import android.os.Build;
import android.util.Log;
import android.view.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.flightgearandroidapp.view_model.ViewModel;

import java.util.jar.Attributes;
import java.util.function.Predicate;

public class JoystickView extends View{

    private Paint paint;

    private float xValBigCircle;
    private float yValBigCircle;
    private float xValSmallCircle;
    private float yValSmallCircle;
    private double bigCircleRadius;
    private double smallCircleRadius;
    private double aileron;
    private double elevator;
    public Runnable onChange;




    public JoystickView(Context context) {
        super(context);
        this.paint = new Paint();
        this.aileron = 0f;
        this.elevator = 0f;
    }

    public JoystickView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.paint = new Paint();
        this.aileron = 0f;
        this.elevator = 0f;
    }

    public JoystickView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.paint = new Paint();
        this.aileron = 0f;
        this.elevator = 0f;
    }


    @Override
    public void onDraw(Canvas canvas) {
         super.onDraw(canvas);

        paint.setColor(Color.parseColor("#00ffff"));
        canvas.drawCircle(this.xValBigCircle,this.yValBigCircle, (float)this.bigCircleRadius+6, paint);

        /**
         paint.setColor(Color.parseColor( "#2a0575"));
         canvas.drawCircle(this.xValBigCircle, this.yValBigCircle, (float)this.bigCircleRadius, paint);

         paint.setColor(Color.parseColor("#5f9ea0"));
         canvas.drawCircle(this.xValSmallCircle, this.yValSmallCircle, (float)this.smallCircleRadius, paint);
         **/

        paint.setColor(Color.parseColor( "#2f4f4f"));
        canvas.drawCircle(this.xValBigCircle, this.yValBigCircle, (float)this.bigCircleRadius, paint);

        paint.setColor(Color.parseColor("#ff4500"));
        canvas.drawCircle(this.xValSmallCircle, this.yValSmallCircle, (float)this.smallCircleRadius, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w,h,oldw,oldh);
        this.smallCircleRadius = 0.175f * Math.min(w,h);
        this.xValSmallCircle = w / 2.0f;
        this.yValSmallCircle = h / 2.0f;
        this.bigCircleRadius = 0.35f * Math.min(w,h);
        this.xValBigCircle = w / 2.0f;
        this.yValBigCircle = h / 2.0f;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventAction = event.getAction();
        if (eventAction == MotionEvent.ACTION_MOVE)
        {
            joystickMove(event.getX(), event.getY());
        }
        if (eventAction == MotionEvent.ACTION_UP)
        {
            joystickStopMove(event.getX(), event.getY());
        }
        return true;
    }

    public void joystickMove(float x, float y)
    {
        float distanceX = Math.abs(x - xValBigCircle);
        float distanceY = Math.abs(y - yValBigCircle);
        if ((bigCircleRadius >= distanceX) && (bigCircleRadius >= distanceY))
        {
            xValSmallCircle = x;
            yValSmallCircle = y;

            aileron = (x - xValBigCircle)/bigCircleRadius;
            elevator = -1f*((y - yValBigCircle)/bigCircleRadius);
        }
        try {
            this.onChange.run(aileron,elevator);
        } catch (Exception e) {

        }
        invalidate();
    }

    public void joystickStopMove(float x, float y)
    {
        xValSmallCircle = xValBigCircle;
        yValSmallCircle = yValBigCircle;
        aileron = 0d;
        elevator = 0d;
        try {
            this.onChange.run(aileron,elevator);
        } catch (Exception e) {

        }
        invalidate();
    }

}
