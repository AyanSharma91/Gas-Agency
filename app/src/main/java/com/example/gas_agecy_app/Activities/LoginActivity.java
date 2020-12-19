package com.example.gas_agecy_app.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gas_agecy_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class LoginActivity extends AppCompatActivity {
//    EditText editText, editText2;
//    Button button;
//    FirebaseAuth auth;
//    TextView textView;
//    public static String uid;
//    String email,password;
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        editText = findViewById(R.id.email);
//        editText2 = findViewById(R.id.password);
//        button = findViewById(R.id.btn_LogIn);
//        textView = findViewById(R.id.text_view);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(LoginActivity.this,RegistrationActivity.class);
//                startActivity(i);
//            }
//        });
//        auth = FirebaseAuth.getInstance();
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                email = editText.getText().toString().trim();
//                password = editText2.getText().toString().trim();
//                if(email.isEmpty())
//                {
//                    editText.setError("Please enter email");
//                    editText.requestFocus();
//                }
//                else if(password.isEmpty())
//                {
//                    editText2.setError("Please enter password");
//                    editText2.requestFocus();
//                }
//                signinFunction(email,password);
//            }
//        });
//}
//    public void signinFunction(String email,String password){
//        auth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(LoginActivity.this,"Login In Successful",Toast.LENGTH_SHORT).show();
//                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                            if(user != null)
//                            {uid = user.getUid();}
//                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                            startActivity(intent);
//
//                        } else {
//                            Log.w("EmailPassword", "signInWithEmail:failure", task.getException());
//                            Toast.makeText(LoginActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }

}