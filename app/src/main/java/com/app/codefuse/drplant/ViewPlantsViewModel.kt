package com.app.codefuse.drplant

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class ViewPlantsViewModel : ViewModel() {
    val TAG = "----"

    val db = Firebase.firestore

    fun fetchData() {
        Log.d(TAG, "---------------")

        db.collection("supported_plants")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {

                    Log.d(TAG, "---------------")
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }

    }
}