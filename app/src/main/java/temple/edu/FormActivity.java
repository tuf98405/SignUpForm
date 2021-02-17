package temple.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button save = findViewById(R.id.buttonSave);

        TextView emailText = findViewById(R.id.editEmailAddress);
        TextView passwordText = findViewById(R.id.editPassword);
        TextView passwordText2 = findViewById(R.id.editPassword2);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.emailError).setVisibility(View.INVISIBLE);
                findViewById(R.id.passwordError2).setVisibility(View.INVISIBLE);
                findViewById(R.id.sampleText).setVisibility(View.INVISIBLE);
                boolean check = true;

                if (!emailText.getText().toString().contains("@") || !emailText.getText().toString().contains(".com")){
                    TextView emailError = findViewById(R.id.emailError);
                    emailError.setVisibility(View.VISIBLE);
                    emailError.setText("Invalid Email");
                    check = false;
                }

                if (!passwordText.getText().toString().equals(passwordText2.getText().toString())){
                    TextView passwordError2 = findViewById(R.id.passwordError2);
                    passwordError2.setVisibility(View.VISIBLE);
                    passwordError2.setText("Passwords do not match");
                    check = false;
                }

                if (check == true){
                    TextView confirm = findViewById(R.id.sampleText);
                    confirm.setVisibility(View.VISIBLE);
                    TextView firstName = findViewById(R.id.editFirstName);
                    TextView lastName = findViewById(R.id.editLastName);
                    confirm.setText(String.format("Welcome %s %s. Thank you for signing up!", firstName.getText(), lastName.getText()));
                }

            }
        });

    }
}