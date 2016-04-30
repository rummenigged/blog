package blog.com.br.blog.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import blog.com.br.blog.R;

/**
 * Created by LGPC on 29/04/2016.
 */
public class Home extends AppCompatActivity {

    Button logIn;
    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);

     /*   logIn = (Button) findViewById(R.id.log_in);
        signUp = (Button) findViewById(R.id.sign_up);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(this,Login.class);
                startActivity(i);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(this,SignUp.class)
            }
        });
*/
    }

}
