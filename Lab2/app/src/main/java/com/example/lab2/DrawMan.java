package com.example.lab2;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


public class DrawMan extends View {
    int i =0;

    public DrawMan(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public DrawMan(Context context) {
        super(context);
    }

    private final Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        drawMan(canvas);
        invalidate();
    }

    private int[] bitmapPixels;
    private void drawMan(Canvas canvas) {
        int x = canvas.getWidth();
        int y = canvas.getHeight() ;
        float s = Math.min(x,y);
        s=s/10;
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(20);
        draw_body(s,canvas,paint);
        draw_limbs(s,canvas,paint);
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void draw_body (float s, Canvas canvas, Paint paint) {
        canvas.drawCircle(s*5,s, s - 10,paint);
        canvas.drawCircle(s*4, (float) (s*2.5), 10,paint);
        canvas.drawCircle(s*6, (float) (s*2.5), 10,paint);
        canvas.drawCircle((float) (s*4.5),s*5, 10 ,paint);
        canvas.drawCircle((float) (s*5.5),s*5, 10 ,paint);
        canvas.drawLine(s*4,(float)(s*2.5),s*6,(float)(s*2.5), paint);
        canvas.drawLine((float)(s*4.5),s*5,(float)(s*5.5),s*5,paint);
        canvas.drawLine(s*5,s*2,s*5,s*5, paint);
    }

    private void draw_limbs (float s, Canvas canvas, Paint paint) {
        if (i==1) {
            //arm1
            canvas.drawLine(s * 4, (float) (s * 2.5), s * 3, s * 4, paint);
            canvas.drawLine(s * 3, s * 4, s * 1, s * 5, paint);
            canvas.drawCircle(s * 3, s * 4, 10, paint);
            //arm2
            canvas.drawLine(s * 6, (float) (s * 2.5), s * 7, s * 4, paint);
            canvas.drawLine(s * 7, s * 4, s * 7, s * 6, paint);
            canvas.drawCircle(s * 7, s * 4, 10, paint);
            //leg1
            canvas.drawLine((float) (s * 4.5), s * 5, s * 5, (float) (s * 7.25), paint);
            canvas.drawLine(s * 5, (float) (s * 7.25), (float) (s * 7.5), s * 10, paint);
            canvas.drawCircle(s * 5, (float) (s * 7.25), 10, paint);
            //leg2
            canvas.drawLine((float) (s * 5.5), s * 5, s * 4, s * 7, paint);
            canvas.drawLine(s * 4, s * 7, s * 5, s * 10, paint);
            canvas.drawCircle(s * 4, s * 7, 10, paint);
            i=0;
        }
        else {
            //arm1
            canvas.drawLine(s * 4, (float) (s * 2.5), (float) (s * 4.3), s * 4, paint);
            canvas.drawLine((float) (s * 4.3), s * 4,(float) (s * 4.3), s * 6, paint);
            canvas.drawCircle((float) (s * 4.3), s * 4, 10, paint);
            //arm2
            canvas.drawLine(s * 6, (float) (s * 2.5), s * 6, (float) (s * 4.5), paint);
            canvas.drawLine(s * 6, (float) (s * 4.5), (float) (s * 4.5), s * 6, paint);
            canvas.drawCircle(s * 6, (float) (s * 4.5), 10, paint);
            //leg1
            canvas.drawLine((float) (s * 4.5), s * 5, s * 3, s * 7, paint);
            canvas.drawLine(s * 3, s * 7, s * 3, s * 10, paint);
            canvas.drawCircle(s * 3, s * 7, 10, paint);
            //leg2
            canvas.drawLine((float) (s * 5.5), s * 5, (float) (s * 6.5), s * 7, paint);
            canvas.drawLine((float) (s * 6.5), s * 7, s * 8, s * 10, paint);
            canvas.drawCircle((float) (s * 6.5), s * 7, 10, paint);
            i=1;
        }
    }

}

