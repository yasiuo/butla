package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.test2.company.*;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LosingMachine losowator = new LosingMachine();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LosSlowo(View view) {
        TextView textview = (TextView) findViewById(R.id.textView3);
        Resources res = getResources();
        String[] slowa = res.getStringArray(R.array.listaSlow);
        Random rand = new Random();

        textview.setText(slowa[rand.nextInt(slowa.length)]);
    }

    public void adOs(View view){
        TextInputEditText textInputEditText = (TextInputEditText) findViewById(R.id.textInputEditText);
        String text = String.valueOf(textInputEditText.getText());

        if (text.equals("")){
            return;
        }

        losowator.dodGracz(text);
        textInputEditText.setText("");
    }

    public void los (View view){
        TextView textview = (TextView) findViewById(R.id.textView);

        if (losowator.getLudzie().size()<2){
            textview.setText("pan debil co osob ma " + losowator.getLudzie().size());
            return;
        }

        textview.setText(losowator.los());

    }

    public void returnMain(View view){
        setContentView(R.layout.activity_main);
    }

    public void returnKalambury(View view){
        setContentView(R.layout.kalambury);
    }

    public void returnButelka(View view){
        setContentView(R.layout.butelka);
    }


    public void goLayout2(View view){
        setContentView(R.layout.layout2test);
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linear);
        int i=0;
        for(Node x : losowator.getLudzie()){
            TextView text = new TextView(this);
            text.setText(x.getImie() + "  | " + x.getWaga());

            Button button = new Button(this);
            button.setText("usun");
//            button.setTag(i,text);
            int finalI = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    losowator.getLudzie().remove(finalI);
                    goLayout2(view);
                }
            });

            linearLayout.addView(text);
            linearLayout.addView(button);
            i++;
        }
    }
}