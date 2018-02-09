package izv.example.com.paint;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by yusas on 02/02/2018.
 */
//Poder dibujar diferentes tipos de figuras, cambiar de color, grosor de linea
public class VistaPintada extends View {

    static Paint pincel = new Paint();
    static String estilo = "linea";
    static Paint.Style style = Paint.Style.STROKE;
    private final Path path = new Path();
    private Bitmap bitmap;
    static Canvas backgroundCanvas;
    private float x0, y0, xN, yN, radius;

    public VistaPintada(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x0 = x;
                y0 = y;
                switch (estilo) {
                    case "linea":
                        xN = x0;
                        yN = y0;
                        path.moveTo(x0, y0);
                        break;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                switch (estilo) {
                    case "linea":
                        x0 = xN;
                        y0 = yN;
                        path.quadTo(x0, y0, (x + x0) / 2, (y + y0) / 2);
                        break;
                }
                xN = x;
                yN = y;
                switch (estilo) {
                    case "circulo":
                        radius = (float) Math.sqrt(Math.pow(xN - x0, 2) + Math.pow(yN - y0, 2));
                        break;
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                switch (estilo) {
                    case "linea":
                        x0 = xN;
                        y0 = yN;
                        break;
                }
                xN = x;
                yN = y;
                switch (estilo) {
                    //case LINE:
                    //    backgroundCanvas.drawLine(x0, y0, xN, yN, pincel);
                    //    break;
                    case "cuadrado":
                        backgroundCanvas.drawRect(x0, y0, xN, yN, pincel);
                        break;
                    case "circulo":
                        backgroundCanvas.drawCircle(x0, y0, radius, pincel);
                        break;
                    case "linea":
                        backgroundCanvas.drawPath(path, pincel);
                        path.reset();
                        break;
                }
                invalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        pincel.setAntiAlias(true);
        pincel.setStyle(style);
        canvas.drawBitmap(bitmap, 0, 0, null);
        switch (estilo) {
           // case LINE:
           //     canvas.drawLine(x0, y0, xN, yN, pincel);
            //    break;
            case "cuadrado":
                canvas.drawRect(x0, y0, xN, yN, pincel);
                break;
            case "circulo":
                canvas.drawCircle(x0, y0, radius, pincel);
                break;
            case "linea":
                canvas.drawPath(path, pincel);
                break;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        backgroundCanvas = new Canvas(bitmap);
    }

    public static void borraCanvas(){
        Paint pincel = new Paint();
        pincel.setColor(Color.WHITE);
        backgroundCanvas.drawRect(0,0,backgroundCanvas.getWidth(),backgroundCanvas.getHeight(),pincel);
    }

}

