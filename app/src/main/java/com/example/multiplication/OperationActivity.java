package com.example.multiplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OperationActivity extends AppCompatActivity
{
    protected int  operande1;
    protected int  operande2;

    protected char operateur;

    /* Méthode permettant la génaration des opérandes */
    public void genererOperandes ( )
    {
        this.operande1 = ( int ) ( ( Math.random ( ) * 9 ) + 1 );
        this.operande2 = ( int ) ( ( Math.random ( ) * 9 ) + 1 );
    }

    /* Méthode permettant la génaration du calcul et change l'affichage */
    public void genererCalcul ( View view )
    {
        this.genererOperandes ( );

       // Intent intent = view.g

        this.operateur = getIntent ( ).getStringExtra ("operateur" ).charAt ( 0 );

        TextView theOperation = ( TextView ) findViewById ( R.id.operation );
        theOperation.setText ( this.toString ( ) );
    }

    public void verifierOperation (View view )
    {
        EditText reponse = ( EditText ) findViewById ( R.id.answer );

        try
        {
            String solution;

            ImageView image = ( ImageView ) findViewById ( R.id.imageView2 );

            if ( this.getSolution ( ) == Integer.parseInt ( reponse.getText ( ).toString ( ) ) )
            {
                solution = "Bravo !";
                image.setImageResource ( R.drawable.bien );
                this.genererCalcul ( view );
                reponse.setText ( "" );
            }
            else
            {
                solution = "Mauvaise réponse";
                image.setImageResource ( R.drawable.pasbien );
            }

            Toast message = Toast.makeText ( this, solution, Toast.LENGTH_LONG );

            message.show ( );
        }
        catch ( Exception e)
        {
            Log.e ( "Problème Conversion", e.getMessage ( ) );

            ImageView image = ( ImageView ) findViewById ( R.id.imageView2 );

            image.setImageResource ( R.drawable.erreur );
        }
    }

    public double getSolution (  )
    {
        switch ( this.operateur )
        {
            case 'x' : return this.operande1 * this.operande2;
            case '+' : return this.operande1 + this.operande2;
        }
        return 0.0;
    }

    /*+----------------------+*/
    /*| Méthodes surchargées |*/
    /*+----------------------+*/

    @Override
    protected void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_operation );

        this.genererCalcul( null );
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

    @NonNull
    @Override
    public String toString ( )
    {
        return this.operande1 + " "  + this.operateur + " " + this.operande2 + " = ";
    }
}