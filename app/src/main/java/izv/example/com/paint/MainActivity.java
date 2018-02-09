package izv.example.com.paint;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        setContentView(R.layout.activity_main);

        ImageButton btPincel = findViewById(R.id.btPincel);
        ImageButton btColor = findViewById(R.id.btColor);
        final ImageButton btBorrar = findViewById(R.id.btBorrar);

        if(btPincel.getSolidColor()==Color.BLACK){
            btColor.setBackgroundColor(Color.BLACK);
        }else if(btPincel.getSolidColor()==Color.RED){
            btColor.setBackgroundColor(Color.RED);
        }else if(btPincel.getSolidColor()==Color.BLUE){
            btColor.setBackgroundColor(Color.BLUE);
        }

        btPincel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, GrosorDialog.class);
                startActivity(i);
            }
        });

        btColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ColorDialog.class);
                startActivity(i);
            }
        });

        btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VistaPintada.borraCanvas();
            }
        });
        VistaPintada.pincel.setStrokeWidth(10);
    }
}
