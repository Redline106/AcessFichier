package com.example.ali_j.acessfichier;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    String nomFichier ="monFichier";
    EditText saisi;
    TextView affichage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saisi=(EditText)findViewById(R.id.saisi);
        affichage=(TextView)findViewById(R.id.affichage);
    }

    public void enregFichier(View view){
        String texte =saisi.getText().toString();
        if (texte!=null && !texte.isEmpty()){
            try {
                FileOutputStream fos;
                fos = openFileOutput(nomFichier, Context.MODE_APPEND);
                fos.write(texte.getBytes());
                fos.close();
                saisi.setText("");
            }catch(FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }

        }

        }


    public void lireFichier(View view) {
        FileInputStream fis;
        try {
            fis = openFileInput(nomFichier);
            byte[] buffer = new byte[1024];
            StringBuilder contenu = new StringBuilder();
            while ((fis.read(buffer)) != -1) {
                contenu.append(new String(buffer));

            }
            fis.close();
            affichage.setText(contenu);







        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
