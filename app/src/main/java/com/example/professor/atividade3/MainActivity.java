package com.example.professor.atividade3;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener {

    private TextView txtTexto;
    private EditText edtTexto;
    private SeekBar skbTamanho;
    private CheckBox ckbNegrito;
    private CheckBox ckbItalico;
    private CheckBox ckbMaiusculas;
    private ImageButton btnEnviar;
    private TextView txtTamanho;
    private RadioGroup rdgCor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTexto = findViewById(R.id.txtTexto);
        edtTexto = findViewById(R.id.edtTexto);
        skbTamanho = findViewById(R.id.skbTamanho);
        txtTamanho = findViewById(R.id.txtTamanho);
        ckbNegrito = findViewById(R.id.ckbNegrito);
        ckbItalico = findViewById(R.id.ckbItalico);
        ckbMaiusculas = findViewById(R.id.ckbMaiusculas);
        rdgCor = findViewById(R.id.rdgCor);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(this);
        skbTamanho.setOnSeekBarChangeListener(this);
        rdgCor.setOnCheckedChangeListener(this);

        ckbNegrito.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    txtTexto.setTypeface(null, Typeface.BOLD);
                    if(ckbItalico.isChecked())
                        txtTexto.setTypeface(null, Typeface.BOLD_ITALIC);
                } else {
                    txtTexto.setTypeface(null, Typeface.NORMAL);
                    if(ckbItalico.isChecked())
                        txtTexto.setTypeface(null, Typeface.ITALIC);
                    else
                        txtTexto.setTypeface(null, Typeface.NORMAL);
                }
            }
        });

        ckbItalico.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    txtTexto.setTypeface(null, Typeface.ITALIC);
                    if(ckbNegrito.isChecked())
                        txtTexto.setTypeface(null, Typeface.BOLD_ITALIC);
                } else {
                    txtTexto.setTypeface(null, Typeface.NORMAL);
                    if(ckbNegrito.isChecked())
                        txtTexto.setTypeface(null, Typeface.BOLD);
                    else
                        txtTexto.setTypeface(null, Typeface.NORMAL);
                }
            }
        });

        ckbMaiusculas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    txtTexto.setAllCaps(true);
                else
                    txtTexto.setAllCaps(false);
            }
        });
    }

    @Override
    public void onClick(View v) {
        txtTexto.setText(edtTexto.getText().toString());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        txtTexto.setTextSize(progress);
        txtTamanho.setText(String.valueOf(progress)+"sp");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        RadioButton checkedRadioButton = group.findViewById(checkedId);
        if (checkedRadioButton.getId() == R.id.rdbVermelho)
            txtTexto.setTextColor(Color.parseColor("#FF0000"));
        if (checkedRadioButton.getId() == R.id.rdbVerde)
            txtTexto.setTextColor(Color.parseColor("#00FF00"));
        if (checkedRadioButton.getId() == R.id.rdbAzul)
            txtTexto.setTextColor(Color.parseColor("#0000FF"));
    }

}
