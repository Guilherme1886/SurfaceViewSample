package com.gui.toledo.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class SurfaceViewSample extends SurfaceView implements SurfaceHolder.Callback {

    private final SurfaceHolder surfaceHolder;
    private final Paint paint;
    private final Paint paintText;
    private Float touchX, touchY;

    public SurfaceViewSample(Context context) {
        super(context);

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        paintText = new Paint();
        paintText.setColor(Color.BLUE);
        paintText.setTextSize(50f);

        setFocusable(true);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchX = event.getX();
        touchY = event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
            drawCircleOnSurface();
        }
        return true;
    }

    private void drawCircleOnSurface() {
        Canvas canvas = null;
        try {
            canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                synchronized (surfaceHolder) {
                    canvas.drawColor(Color.WHITE);
                    canvas.drawCircle(touchX, touchY, 50, paint);
                    canvas.drawText("x: " + touchX.intValue() + " y: " + touchY.intValue(), touchX + 55f, touchY + 15f, paintText);
                }
            }
        } finally {
            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
