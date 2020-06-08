package com.evgnngve.numbertheorytools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateModTable(View view) {
        EditText moduliText = (EditText) findViewById(R.id.modulo_user_input);
        Editable moduliEditable = moduliText.getText();
        String moduliString = moduliEditable.toString();
        Integer modulus = new Integer(moduliString);

        //Create Table
        ArrayList<ArrayList<Integer>> modTable = new ArrayList<>();
        for(int a = 0; a < modulus; a++ ) { //Increasing powers of a
            if(a!=modulus-1) {
                modTable.add(tableRow(a, modulus, false));//Add a row
            } else{
                modTable.add(tableRow(a,modulus,true)); //We've reached the final row, the row that shows index.
            }
        }
        //Show table
        //For now just import text to a string then show it on android


    }

    //Calculates a single row in our modulo table, returns index if it's the final one
    public static ArrayList<Integer> tableRow(int a, int modulus,boolean trackIndexing){
        ArrayList<Integer> indexing = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        int n=2;
        //int modulus = 3;
        //System.out.print("       ");
        row.add(a);
        indexing.add(1);
        for(int i = 0;i<modulus;i++){
            double power = Math.pow(a,n);
            int remainder = (int) (power % modulus);
            row.add(remainder);
            //System.out.print(remainder+", ");
            indexing.add(n);
            n++;
            //indexing.add(i);
            //System.out.println((Math.pow((double) a,(double) i)) % i );
        }
        System.out.println();
        if(trackIndexing) {

            return indexing;
//            System.out.println("_______");
//            System.out.print("a^(n): ");
//            for (Integer i : indexing) {
//                System.out.print(i + ", ");
//            }
        }
        return row;
    }
}
