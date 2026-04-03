package com.example.contact.activities;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contact.database.DBHelper;
import com.example.contact.model.Contact;

public class AddContactActivity extends AppCompatActivity {

    EditText etFirst, etLast, etPhone, etEmail, etCompany;
    Button btnSave;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        db = new DBHelper(this);

        etFirst = findViewById(R.id.etFirstName);
        etLast = findViewById(R.id.etLastName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etCompany = findViewById(R.id.etCompany);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String first = etFirst.getText().toString();
            String last = etLast.getText().toString();
            String phone = etPhone.getText().toString();
            String email = etEmail.getText().toString();
            String company = etCompany.getText().toString();

            if(first.isEmpty() || phone.isEmpty()){
                Toast.makeText(this, "First Name and Phone required", Toast.LENGTH_SHORT).show();
                return;
            }

            Contact c = new Contact(0, first, last, phone, email, company);
            db.insertContact(c);

            Toast.makeText(this, "Contact Saved", Toast.LENGTH_SHORT).show();
            finish(); // go back to main screen
        });
    }
}
