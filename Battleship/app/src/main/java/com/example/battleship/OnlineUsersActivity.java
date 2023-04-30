package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;

public class OnlineUsersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OnlineUsersAdapter adapter;
    private List<User> userList;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_users);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userList = new ArrayList<>();
        adapter = new OnlineUsersAdapter(this, userList);

        recyclerView.setAdapter(adapter);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        getAllUsers();
    }

    private void getAllUsers() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        db.collection("users")
                .orderBy("username", Query.Direction.ASCENDING)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        userList.clear();
                        for (DocumentSnapshot document : task.getResult()) {
                            if (!document.getId().equals(currentUser.getUid())) {
                                User user = document.toObject(User.class);
                                userList.add(user);
                            }
                        }
                        adapter.notifyDataSetChanged();
                    } else {
                        // Log the error
                    }
                });
    }
}