package com.LPDW.morpion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.LPDW.morpion.Model.Data;

public class MainActivity extends Activity
{
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Function called when play button is clicked
     *
     * @param v
     */
    public void launchGame(View v)
    {
        // Get the two pseudo fields values
        EditText pseudoOne  = (EditText)findViewById(R.id.pseudo1Text);
        EditText pseudoTwo  = (EditText)findViewById(R.id.pseudo2Text);
        String pseudoOneValue = pseudoOne.getText().toString();
        String pseudoTwoValue = pseudoTwo.getText().toString();

        // If one of two pseudos are null or equals at "pseudo", render a toast
        if (pseudoTwoValue.trim().length() == 0 ||
            pseudoOneValue.trim().length() == 0 )
        {

            Toast toast = Toast.makeText(this, "YOU MUST HAVE A PLAYER NAME !", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            // Call the data object and pass the pseudo values into it
            try {
                Data data = Data.getInstance();
                // Set scores
                data.setScoresPlayer1(0);
                data.setScoresPlayer2(0);

                data.setPseudo1(pseudoOneValue);
                data.setPseudo2(pseudoTwoValue);

                // pass to the play activity
                Intent intent = new Intent(this, PlayActivity.class);
                startActivity(intent);

            } catch(Exception e) {
                Log.v("ERREUR D\'INSTANCIATION", "exception", e);
            }
        }
    }
}
