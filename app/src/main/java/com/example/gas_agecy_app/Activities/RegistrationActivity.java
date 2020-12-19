package com.example.gas_agecy_app.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gas_agecy_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegistrationActivity extends AppCompatActivity {
//    EditText editText,editText2,editText3;
//    Button button;
//    FirebaseAuth auth;
//    TextView textView;
//    DatabaseReference databasenote;
//    String name,email,password,uid;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_registration);
//        editText = findViewById(R.id.name);
//        editText2 = findViewById(R.id.email);
//        editText3 = findViewById(R.id.password);
//        button = findViewById(R.id.btn_LogIn);
//        textView = findViewById(R.id.text_view);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(RegistrationActivity.this,LoginActivity.class);
//                startActivity(i);
//            }
//        });
//        auth = FirebaseAuth.getInstance();
//        databasenote = FirebaseDatabase.getInstance().getReference("UserDetails");
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                name = editText.getText().toString().trim();
//                email = editText2.getText().toString().trim();
//                password = editText3.getText().toString().trim();
//                if(name.isEmpty())
//                {
//                    editText.setError("Please enter Name");
//                    editText.requestFocus();
//                }
//                else if(email.isEmpty())
//                {
//                    editText2.setError("Please enter Email Id");
//                    editText2.requestFocus();
//                }
//                else if(password.isEmpty())
//                {
//                    editText3.setError("Please enter Password");
//                    editText3.requestFocus();
//                }
//                else{
//                    validityFunction(name,email,password);
//                }
//            }
//        });
//    }
//    public void validityFunction(final String name, final String email, final String password){
//        FirebaseDatabase.getInstance().getReference("UserDetails")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists())
//                            for(DataSnapshot dataSnapshot:snapshot.getChildren()){
//                                String uname = dataSnapshot.child("name").getValue().toString();
//                                if(uname.equals(name)){
//                                    Toast.makeText(RegistrationActivity.this,"Username is already in use,Please try another!",Toast.LENGTH_SHORT).show();
//                                }
//                                else{
//                                    auth.fetchSignInMethodsForEmail(email)
//                                            .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
//                                                @Override
//                                                public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
//                                                    boolean isNew = task.getResult().getSignInMethods().isEmpty();
//                                                    if(isNew){
//                                                        signUpFunction(name,email,password);
//                                                    }
//                                                    else{
//                                                        Toast.makeText(RegistrationActivity.this,"Email is already registered,Please try another!",Toast.LENGTH_SHORT).show();
//                                                    }
//                                                }
//                                            });
//                                }
//                            }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//    }
//    public void signUpFunction(final String name, String email, String password){
//        auth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(RegistrationActivity.this,"Registration Successful!",Toast.LENGTH_SHORT).show();
//                            FirebaseUser user = auth.getCurrentUser();
//                            assert user != null;
//                            uid = user.getUid();
//                            HashMap<String, Object> hashMap = new HashMap<>();
//                            hashMap.put("name",name);
//                            hashMap.put("uid",uid);
//                            databasenote.child(uid).setValue(hashMap);
//                            Intent i = new Intent(RegistrationActivity.this,LoginActivity.class);
//                            startActivity(i);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Toast.makeText(RegistrationActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }
}