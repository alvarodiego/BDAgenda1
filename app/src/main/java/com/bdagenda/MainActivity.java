package com.bdagenda;




import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	public EditText etci, etna, etap, etce;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etci=(EditText)findViewById(R.id.editText1);
		etna=(EditText)findViewById(R.id.editText2);
		etap=(EditText)findViewById(R.id.editText3);
		etce=(EditText)findViewById(R.id.editText4);
	}
	//inicio codigo
	public void fagregar1(View v){
		BaseDatos dbobject = new BaseDatos(this,"administracion", null,1);
		SQLiteDatabase bd = dbobject.getWritableDatabase();
		
		
		
		String ced=etci.getText().toString();
		if(cedula.valida(ced))
		{
			
			
			String nom=etna.getText().toString();
			if(nom.length()==0)
			{
				Toast.makeText(this,"Campo Nombre Requerido",Toast.LENGTH_SHORT).show();
			}
			else
			{
				
				String ape=etap.getText().toString();
				if(ape.length()==0)
				{
					Toast.makeText(this,"Campo Apellido Requerido",Toast.LENGTH_SHORT).show();
					
				}
				else{
				String cel=etce.getText().toString();
				if(cel.length()==0){
					Toast.makeText(this,"Campo Celular Requerido",Toast.LENGTH_SHORT).show();
				}
				else{
				ContentValues registro = new ContentValues();
				registro.put("ci", ced);
				registro.put("nombre", nom);
				registro.put("apellido", ape);
				registro.put("celular", cel);
				bd.insert("alumnos",null,registro);
				bd.close();
				etci.setText("");
				etna.setText("");
				etap.setText("");
				etce.setText("");
				Toast.makeText(this,"Alumno Agregado",Toast.LENGTH_SHORT).show();
				}
				}
				}
				
			
		}
		else
		{
			Toast.makeText(this,"Cedula Incorrecta",Toast.LENGTH_SHORT).show();
			Toast.makeText(this,"VERIFICAR",Toast.LENGTH_SHORT).show();
		}
		
		
	}//fin agregar
	
	public void fconsultar(View v){
		BaseDatos dbobject = new BaseDatos(this,"administracion",null,1);
		SQLiteDatabase bd = dbobject.getWritableDatabase();
		String ced = etci.getText().toString();
		Cursor fila = bd.rawQuery("select nombre,apellido,celular from alumnos where ci="+ced, null);
		if(fila.moveToFirst()){
			etna.setText(fila.getString(0));
			etap.setText(fila.getString(1));
			etce.setText(fila.getString(2));
		}else
			Toast.makeText(this, "No Existe Cedula",Toast.LENGTH_SHORT).show();
		bd.close();
	}
	
	public void fmodificar(View v){
		BaseDatos dbobject = new BaseDatos(this,"administracion",null,1);
		SQLiteDatabase bd = dbobject.getWritableDatabase();
		String ced=etci.getText().toString();
		String nom=etna.getText().toString();
		String ape=etap.getText().toString();
		String cel=etce.getText().toString();
		ContentValues registro = new ContentValues();
		registro.put("nombre", nom);
		registro.put("apellido", ape);
		registro.put("celular", cel);
		int cant = bd.update("alumnos",registro, "ci="+ced,null);
		bd.close();
		if(cant==1)
			Toast.makeText(this,"Datos ACTUALIZADOS",Toast.LENGTH_SHORT).show();
		else
			Toast.makeText(this,"ALUMNO NO EXISTE",Toast.LENGTH_SHORT).show();
		
	}
	
	public void fborrar(View v){
		BaseDatos dbobject = new BaseDatos(this,"administracion",null,1);
		SQLiteDatabase bd = dbobject.getWritableDatabase();
		String ced=etci.getText().toString();
		int cant = bd.delete("alumnos","ci="+ced, null);
		bd.close();
		etci.setText("");
		etna.setText("");
		etap.setText("");
		etce.setText("");
		if(cant==1)
			Toast.makeText(this,"ALUMNO BORRADO",Toast.LENGTH_SHORT).show();
		else
			Toast.makeText(this,"ALUMNO NO EXISTE",Toast.LENGTH_SHORT).show();
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

