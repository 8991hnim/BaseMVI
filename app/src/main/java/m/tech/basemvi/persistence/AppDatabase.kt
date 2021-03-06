package m.tech.basemvi.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import m.tech.basemvi.models.Post

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPostDao(): PostDao

    companion object {
        const val DATABASE_NAME = "app_db"
    }
}