package com.mastercoding.firebase_app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ttview: TextView = findViewById(R.id.txtview)
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        database = Firebase.database.reference
        //write database
        database.child("Price").setValue("1000 $")

        //Reading Data from firebase
        val postlistener = object : ValueEventListener {
            //valueevent listners and post listners deals with data as a type of snapshots
            //we need to get data from the data snapshot


            override fun onDataChange(snapshot: DataSnapshot) {
                val gold_price = snapshot.value
                ttview.text = gold_price.toString()

            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
database.child("Price").addValueEventListener(postlistener)
    }


    }

