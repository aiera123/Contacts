package com.example.contact.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.Contact.R;
import com.example.Contact.adapter.ContactAdapter;
import com.example.Contact.database.DBHelper;
import com.example.Contact.model.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    DBHelper dbHelper;
    List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);
        dbHelper = new DBHelper(this);

        fab.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AddEditContactActivity.class)));

        loadContacts();
    }

    private void loadContacts() {
        contactList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                contactList.add(new Contact(
                        cursor.getInt(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_PHONE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_EMAIL))
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();

        ContactAdapter adapter = new ContactAdapter(contactList, contact ->
                Toast.makeText(MainActivity.this, "Clicked: " + contact.getName(), Toast.LENGTH_SHORT).show());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}