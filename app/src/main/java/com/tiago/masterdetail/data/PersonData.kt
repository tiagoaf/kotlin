package com.tiago.masterdetail.data

import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.FirebaseFirestore
import java.util.ArrayList
import android.content.ContentValues.TAG


/**
 * Created by tiago on 15/02/18.
 */
object PersonData {

    val ITEMS: MutableList<Person> = ArrayList()

    val ITEM_MAP: MutableMap<Number, Person> = HashMap()

    init {

        var db = setup();

        db.collection("person-collection")
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (document in task.result) {
                            Log.d(TAG, document.id + " => " + document.data)
                        }
                    } else {
                        Log.w(TAG, "Error getting documents.", task.exception)
                    }
                }
    }

    private fun setup(): FirebaseFirestore {
        // [START get_firestore_instance]
        val db = FirebaseFirestore.getInstance()
        // [END get_firestore_instance]

        // [START set_firestore_settings]
        val settings = FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build()
        db.firestoreSettings = settings
        // [END set_firestore_settings]

        return db;
    }

    private fun addPerson(item: Person) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }
}