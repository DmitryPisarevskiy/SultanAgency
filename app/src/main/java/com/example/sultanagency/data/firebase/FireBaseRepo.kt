package com.example.sultanagency.data.firebase

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sultanagency.logic.entities.Publication
import com.example.sultanagency.logic.usecases.UkEntityConverter
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import java.io.ByteArrayOutputStream

class FireBaseRepo: IRemoteRepo {
    val database = Firebase.database
    val storage = FirebaseStorage.getInstance()
    val sRef = storage.reference
    val dbRef = database.getReference("Publications")

    override suspend fun insertPost(post: Publication) {
        val postRef = dbRef.child(post.id)
        val picturesRef = sRef.child(post.id)
        for (i in post.pictures.indices) {
            val bitmap = post.pictures[i]
            val picRef = picturesRef.child(i.toString())
            val baos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val up: UploadTask = picRef.putBytes(baos.toByteArray())
            up.continueWithTask {task->
                picRef.downloadUrl
            }.addOnCompleteListener {task->
                post.picturesRef.add(task.result.toString())
            }
        }
        postRef.setValue(UkEntityConverter.getPostFB(post))
    }

    override fun getAllPosts(): LiveData<List<Publication>> {
        val ld = MutableLiveData<List<Publication>>()
        val mList = mutableListOf<Publication>()
        dbRef.addValueEventListener(object:ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach {child ->
                    val post = child.getValue(PublicationFB::class.java)
                    mList.add(UkEntityConverter.getPostFromFB(post!!))
                }
                ld.value = mList
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
        return ld
    }

    override suspend fun deletePostById(postId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun findPostById(postId: String): PublicationFB? {
        TODO("Not yet implemented")
    }

}