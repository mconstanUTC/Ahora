package com.example.erika;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class Inicio extends Activity {
EditText inf, supe, it;
ListView ls;
Chronometer c;
ArrayAdapter<Integer>adapter;
ArrayList<Integer> datos=new ArrayList<Integer>();
ArrayList<Integer> datos1=new ArrayList<Integer>();
int contador=0,k,con=0;
int numero,des,has;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        inf=(EditText)findViewById(R.id.n1);
        supe=(EditText)findViewById(R.id.n2);
        it=(EditText)findViewById(R.id.n3);
        ls=(ListView)findViewById(R.id.lista1);
        c=(Chronometer)findViewById(R.id.crono);
		
	}

	public void Empezar(View v){
		k=0;
		datos.clear();
		ls.setAdapter(null);
		adapter = new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_list_item_1, datos);
		numero=Integer.parseInt(it.getText().toString());
		des=Integer.parseInt(inf.getText().toString());
		has=Integer.parseInt(supe.getText().toString());
		c.setBase(SystemClock.elapsedRealtime());
		c.start();
		for(int i=des;i<=has;i++){
			
			if(i%3==0){
				
				datos1.add(i);
				contador++;
				
			}
			
			
		}		
    		this.c.setOnChronometerTickListener(new OnChronometerTickListener() {
    			
    			
    			@Override
    			public void onChronometerTick(Chronometer chronometer) {
    				// TODO Auto-generated method stub
    				
    				
    				
    				con++;
    				if(con>=3){
    					
    					if(con%3==0){
    						
    						if(k<=numero-1){
    							
    						datos.add(datos1.get(k));
    						adapter.notifyDataSetChanged();
    						ls.setAdapter(adapter);
    						k++;
    						contador--;
    						}else{
    							
    								c.stop();
    								
    								
    								
    							
    						}
    					}
    				}
    					
    				
    					
    					
    			
    				
    			}});
    	}




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
