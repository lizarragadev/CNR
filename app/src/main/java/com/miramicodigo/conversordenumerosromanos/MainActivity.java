package com.miramicodigo.conversordenumerosromanos;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String ERROR = "El numero introducido es incorrecto";
    public static int millares = 0, centenas = 0, decenas = 0, unidades = 0;
    public static String [][] romanos={{"","I","II","III","IV","V","VI","VII","VIII","IX"},
            {"","X","XX","XXX","XL","L","LX","LXX","LXX","XC"},
            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
            {"","M","MM","MMM","Mv","v","vM","vMM","vMMM","Mx"}};
    private EditText etNumDecimal;
    private Button btnDecToRom, btnReset;
    private TextView tvRomano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumDecimal = (EditText) findViewById(R.id.etNumDec);
        btnDecToRom = (Button) findViewById(R.id.btnDecToRom);
        btnReset = (Button) findViewById(R.id.btnReset);
        tvRomano = (TextView) findViewById(R.id.tvRomano);

        btnDecToRom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvRomano.setText(convertirDecimalARomano(etNumDecimal.getText().toString().trim()));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNumDecimal.setText("");
                tvRomano.setText("");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.item_acerca_de:
                createSimpleDialog().show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }

    public AlertDialog createSimpleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.tv_main_acercade)
                .setMessage(getString(R.string.tv_dialogo_msg))
                .setPositiveButton(getString(R.string.tv_dialogo_btn),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });

        return builder.create();
    }

    private String convertirDecimalARomano(String numero) {
        try{
            obtenerNotDesarrollada(Integer.valueOf(numero));
            return obtenerRomano();
        }catch (NumberFormatException e){
            System.out.println(ERROR);
        }
        catch(Exception e){
            System.out.println(ERROR);
        }
        return "";
    }

    public void obtenerNotDesarrollada(int numero) {
        millares = (int)numero / 1000;
        centenas = (int)numero % 1000 / 100;
        decenas = (int)numero % 1000 % 100 / 10;
        unidades = (int)numero % 1000 % 100 % 10;
    }

    public String obtenerRomano(){
        return romanos[3][millares]+""+
                romanos[2][centenas]+""+
                romanos[1][decenas]+""+
                romanos[0][unidades]+"";
    }
}
