package com.example.multiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        this.declancheur ( );
    }

    @Override
    protected void onStart ( )
    {
        super.onStart ( );
        Toast toast = Toast.makeText (this, "onStart", Toast.LENGTH_SHORT );
        toast.show ( );
    }

    @Override
    protected void onRestart ( )
    {
        super.onRestart ( );
        Toast toast = Toast.makeText (this, "onRestart", Toast.LENGTH_SHORT );
        toast.show ( );
    }

    @Override
    protected void onResume ( )
    {
        super.onResume ( );
        Toast toast = Toast.makeText (this, "onResume", Toast.LENGTH_SHORT );
        toast.show ( );
    }

    @Override
    protected void onPause ( )
    {
        super.onPause ( );
        Toast toast = Toast.makeText (this, "onPause", Toast.LENGTH_SHORT );
        toast.show ( );
    }

    @Override
    protected void onStop ( )
    {
        super.onStop ( );
        Toast toast = Toast.makeText (this, "onStop", Toast.LENGTH_SHORT );
        toast.show ( );

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast toast = Toast.makeText (this, "onDestroy", Toast.LENGTH_SHORT );
        toast.show ( );
    }

    public void lancerOperation ( View view, char operateur )
    {
        Intent i = new Intent(this, OperationActivity.class );
        i.putExtra ("operateur", operateur );
        startActivity ( i );
    }

    private void declancheur ( )
    {
        this.ajouterAction ( R.id.buttonAddition      , '+' );
        this.ajouterAction ( R.id.buttonMultiplication, 'x' );
    }

    private void ajouterAction ( int identifiant, char operateur )
    {
        Button boutton = findViewById ( identifiant );
        boutton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                lancerOperation ( v, operateur );
            }
        });
    }
}