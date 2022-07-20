package com.example.exam_t3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exam_t3_2.Entities.Contact;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        String contactJson = getIntent().getStringExtra("CONTACT");
        Contact contact = new Gson().fromJson(contactJson, Contact.class);

        ImageView ivAvatar = findViewById(R.id.ivAvatar);
        TextView tvName = findViewById(R.id.tvContactName);
        TextView tvNumber = findViewById(R.id.tvContactNumber);

        Picasso.get().load("https://loremflickr.com/cache/resized/65535_51791973972_9d56c65e1f_320_240_nofilter.jpg").into(ivAvatar);
        tvName.setText(contact.name);
        tvNumber.setText(contact.number);

        Button btnCall =  findViewById(R.id.idCall);
        Button btnSms =  findViewById(R.id.idSms);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);

                callIntent.setData(Uri.parse("tel:"+ contact.number));//change the number
                view.getContext().startActivity(callIntent);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri sms_uri = Uri.parse("smsto:"+ contact.number);
                Intent sms_intetnt = new Intent(Intent.ACTION_SENDTO, sms_uri);
                sms_intetnt.putExtra("cuerpo","mensaje");
                view.getContext().startActivity(sms_intetnt);
            }
        });
    }
}