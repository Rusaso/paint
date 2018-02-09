package izv.example.com.paint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class GrosorDialog extends AppCompatActivity {

    private ImageButton btLinea, btCuadrado,btCirculo;
    private Button btGrosorU,btGrosorD;
    private TextView tvGrosor;
    private float grosor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grosor_dialog);
        btLinea = findViewById(R.id.btLinea);
        btCuadrado = findViewById(R.id.btCuadrado);
        btCirculo = findViewById(R.id.btCirculo);
        btGrosorD = findViewById(R.id.btGrosorD);
        btGrosorU = findViewById(R.id.btGrosorU);
        tvGrosor = findViewById(R.id.tvGrosor);

        grosor= VistaPintada.pincel.getStrokeWidth();
        tvGrosor.setText(""+grosor);

        btLinea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VistaPintada.estilo="linea";
                finish();
            }
        });
        btCuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VistaPintada.estilo="cuadrado";
                finish();
            }
        });
        btCirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VistaPintada.estilo="circulo";
                finish();
            }
        });

        btGrosorD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grosor--;
                VistaPintada.pincel.setStrokeWidth(grosor);
                tvGrosor.setText(""+grosor);
            }
        });

        btGrosorU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grosor++;
                VistaPintada.pincel.setStrokeWidth(grosor);
                tvGrosor.setText(""+grosor);
            }
        });
    }
}
