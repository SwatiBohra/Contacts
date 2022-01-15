package com.example.contacts;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contacts.Model.Contact;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    CircleImageView profile_image;
    TextView name,pNum;
    TextView contactsv;

    StringBuilder contactsS;

    FirebaseUser firebaseUser;
    DatabaseReference reference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.text_name);
        pNum = findViewById(R.id.text_num);
        contactsv = findViewById(R.id.textview2);
        contactsS = new StringBuilder("");

        profile_image = findViewById(R.id.img1);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("contacts");

        //reference.child("Someone").child("name").setValue("Someone");
        //reference.child("Someone").child("number").setValue("54654565462");



        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
              //  if (!snapshot.hasChild(firebaseUser.getUid())) {
                  //  Contact contact = snapshot.getValue(Contact.class);
                   // name.setText(contact.getName());
                  //  pNum.setText(contact.getNumber());
                   // profile_image.setImageResource(R.mipmap.display);
               // }
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String temp = dataSnapshot.child("name").getValue(String.class);
                    contactsS.append(temp).append("   ");

                    Long tempNum = dataSnapshot.child("number").getValue(Long.class);
                    contactsS.append(tempNum).append("\n");
                }
//                String cName = snapshot.child("Someone").child("name").getValue(String.class);
              //  String cNum = snapshot.child("name").getValue(String.class);
  //              contactsS.append(cName).append("\n");

                contactsv.setText(contactsS.toString());
                //contactsv.setText(contactsS.toString());
               // name.setText(cName);
                //pNum.setText(cNum);
                //profile_image.setImageResource(R.mipmap.display);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

