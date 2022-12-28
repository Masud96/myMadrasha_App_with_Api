package com.masud.masudmyproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.masud.masudmyproject.Adapters.DeleteNoticeAdapter;

import java.util.ArrayList;
import java.util.List;

public class DeleteNoticeActivity extends AppCompatActivity {

    private DatabaseReference reference;
    private ArrayList<NoticeData> list;
    private RecyclerView deleteRV;
    private DeleteNoticeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_notice);
        deleteRV = findViewById(R.id.deleteNoticeRV);

        reference = FirebaseDatabase.getInstance().getReference().child("Notice");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                   NoticeData data = dataSnapshot.getValue(NoticeData.class);
                    list.add(data);
                }
                adapter = new DeleteNoticeAdapter(list,DeleteNoticeActivity.this);
                deleteRV.setLayoutManager(new LinearLayoutManager(DeleteNoticeActivity.this));
                deleteRV.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }
}