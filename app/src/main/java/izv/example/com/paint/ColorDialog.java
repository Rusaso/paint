package izv.example.com.paint;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ColorDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_dialog);
        ImageButton btRojo, btNegro, btAzul;
        btRojo = findViewById(R.id.btRojo);
        btNegro = findViewById(R.id.btNegro);
        btAzul = findViewById(R.id.btAzul);

        btRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VistaPintada.pincel.setColor(Color.RED);
                finish();
            }
        });
        btNegro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VistaPintada.pincel.setColor(Color.BLACK);
                finish();
            }
        });
        btAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VistaPintada.pincel.setColor(Color.BLUE);
                finish();
            }
        });
    }
}
